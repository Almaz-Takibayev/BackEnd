import scala.concurrent.Future

trait ICalculatorRepository {
//  def calculate(expression: String): Future[String]
  def calculate(expression: String): Future[Calculation]
}