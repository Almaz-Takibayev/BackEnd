import akka.actor.typed.ActorSystem
import org.slf4j.{Logger, LoggerFactory}

import scala.io.StdIn

object Main extends App {
  implicit val log: Logger = LoggerFactory.getLogger(getClass)

  val system: ActorSystem[CalculatorMain.UserInput] =
    ActorSystem(CalculatorMain(), "input")

  system ! CalculatorMain.UserInput(userInput())

  def userInput(): String = {
    var input: String = ""
    var expression: String = ""

    while (!input.contains('=')) {
      input = StdIn.readLine()
      if (input.contains('=') && input.indexOf('=') != input.length - 1) {
        input = input.slice(0, input.indexOf('=') + 1);
      }
      expression += input.replaceAll("\\s", "")
    }
    //    println(expression)
    return expression
  }
}
