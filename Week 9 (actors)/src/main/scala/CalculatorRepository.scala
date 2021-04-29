import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors
import scala.concurrent.Future

object CalculatorRepository {
  sealed trait Command
  final case class Calculate(expression: String, replyTo: ActorRef[String]) extends Command

  def apply(): Behavior[Command] = Behaviors.receiveMessage {
    case Calculate(expression, replyTo) => {
      val calculatorApp = new CalculatorApp
      replyTo ! calculatorApp.calculate(expression)
      Behaviors.same
    }
  }


//  def apply(): Behavior[Command] = Behaviors.receiveMessage {
//    case Calculate(expression, replyTo) => {
//      val calculatorApp = new CalculatorApp
//      replyTo ! calculatorApp.calculate(expression)
//      Behaviors.same
//    }
//  }
}