import akka.actor.typed.{ActorRef, ActorSystem}
import akka.http.scaladsl.server.{Directives, Route}
import akka.util.Timeout

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.duration.DurationInt

trait  Router {
  def route:Route
}

class MyRouter(calculatorRepository: ActorRef[CalculatorRepository.Command])(implicit system: ActorSystem[_], ex:ExecutionContext) extends Router with  Directives {

  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
  import io.circe.generic.auto._
  import akka.actor.typed.scaladsl.AskPattern.schedulerFromActorSystem
  import akka.actor.typed.scaladsl.AskPattern.Askable

  implicit val timeout: Timeout = 3.seconds

  override def route = concat(
    pathPrefix("calculator") {
      path(Segment) { expression =>
        get {
          //          complete(calculatorRepository.ask(CalculatorRepository.Calculate(expression)))
          val maybeJob: Future[String] =
            calculatorRepository.ask(CalculatorRepository.Calculate(expression, _))
          rejectEmptyResponse {
            complete(maybeJob)
          }
        }
      }
    }
  )
}