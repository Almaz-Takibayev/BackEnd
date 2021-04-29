import akka.actor.typed.ActorSystem
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{Directives, Route}

import scala.concurrent.ExecutionContext

trait  Router {
  def route:Route
}

class MyRouter(todoRepository: TodoRepository)(implicit system: ActorSystem[_],  ex:ExecutionContext)
  extends Router
    with  Directives
    with TodoDirectives
    with ValidatorDirectives {

  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
  import io.circe.generic.auto._

  override def route = concat(
    path("ping") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "pong"))
      }
    },
    pathPrefix("todos") {
      concat(
        pathEndOrSingleSlash {
          concat(
            get {
              handleWithGeneric(todoRepository.all()) {
                todos => complete(todos)
              }
            },
            post {
              entity(as[CreateTodo]) { createTodo =>
                validate(!todoRepository.existTitle(createTodo.title), ApiError.duplicateTitleError.message) {
                  validateWith(CreateTodoValidator)(createTodo) {
                    handleWithGeneric(todoRepository.create(createTodo)) { todo => complete(todo) }
                  }
                }
              }
            }
          )
        },
        path(Segment) { id =>
          put {
            entity(as[UpdateTodo]) { updateTodo =>
              validate(!todoRepository.existTitle(updateTodo.title), ApiError.duplicateTitleError.message) {
                validateWith(UpdateTodoValidator)(updateTodo) {
                  handleWithGeneric(todoRepository.update(id, updateTodo)) { todo => complete(todo) }
                }
              }
            }
          }
        }
      )
    }
  )
}