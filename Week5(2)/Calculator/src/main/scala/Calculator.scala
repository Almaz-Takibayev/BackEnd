import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}

object Calculator {
  final case class Expression(expression: String, replyTo: ActorRef[Result])
  final case class Result(result: String, expression: String, from: ActorRef[Expression])

  val calculatorApp = new CalculatorApp()

  def apply(): Behavior[Expression] = Behaviors.receive { (context, message) =>
    context.log.info("Your expression is {}", message.expression)
    message.replyTo ! Result(calculatorApp.calculate(message.expression), message.expression, context.self)
    Behaviors.same
  }
}