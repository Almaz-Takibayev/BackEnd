import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.{Behaviors, LoggerOps}

object CalculatorBot {
  def apply(): Behavior[Calculator.Result] = {
    bot()
  }

  private def bot(): Behavior[Calculator.Result] =
    Behaviors.receive { (context, message) =>
      context.log.info("Result of expression {} is {}", message.expression.substring(0, message.expression.length-1), message.result)
      Behaviors.stopped
    }
}
