import akka.actor.typed.ActorSystem
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.{Directives, Route}

import scala.concurrent.ExecutionContext

trait  Router {
  def route:Route
}

class MyRouter(calculatorRepository: ICalculatorRepository)(implicit system: ActorSystem[_], ex:ExecutionContext) extends Router with  Directives {
  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
  import io.circe.generic.auto._

  override def route = concat(
//    pathPrefix("calculator") {
//      path(Segment) { expression =>
//        get {
//          complete(calculatorRepository.calculate(expression.toString))
//        }
//      }
//    }
    pathPrefix("calculator") {
      path(Segment) { expression =>
        get {
          complete(calculatorRepository.calculate(expression.toString))
        }
      }
    }
  )
}