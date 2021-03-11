import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object CalculatorMain {

  final case class UserInput(expression: String)

  def apply(): Behavior[UserInput] =
    Behaviors.setup { context =>
      val calculator = context.spawn(Calculator(), "calculator")

      Behaviors.receiveMessage { message =>
        val replyTo = context.spawn(CalculatorBot(), message.expression)
        calculator ! Calculator.Expression(message.expression, replyTo)
        Behaviors.same
      }
    }

}