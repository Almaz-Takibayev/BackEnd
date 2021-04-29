import scala.concurrent.Future

class CalculatorApp {
  def calculate(expression: String): String = {
    var operations: List[Char] = List()
    var numbers: List[Double] = List()

    var number = ""

    var hasDot: Boolean = false

    for (i <- 0 to expression.length - 1) {
      if (isOperation(expression.charAt(i)) && !isOperation(expression.charAt(0))) {
        if (!isOperation(expression.charAt(i - 1))) {
          operations = operations :+ expression.charAt(i)

          numbers = numbers :+ number.toDouble
          number = ""

          hasDot = false
        }
        else {
          return "Incorrect input"
        }
      }
      else if (isDigit(expression.charAt(i))) {
        number += expression.charAt(i)
      }
      else if (isElementOfNumber(expression.charAt(i)) && isDigit(expression.charAt(i - 1)) && isDigit(expression.charAt(i + 1)) && !hasDot) {
        number += expression.charAt(i)
        hasDot = true
      }
      else {
        return "Incorrect input"
      }
    }

    val result = getResult(numbers, operations)

    val resultInt = result.toInt

    if (resultInt == result) {
      return resultInt.toString
    }
    else {
      return result.toString
    }
  }

  def isOperation(c: Char): Boolean = {
    if (c == '+' || c == '-' || c == '*' || c == '!' || c == '=') {
      return true
    }

    return false
  }

  def isDigit(c: Char): Boolean = {
    if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
      return true
    }

    return false
  }

  def isElementOfNumber(c: Char): Boolean = {
    if (c == '.') {
      return true
    }

    return false
  }

  def getResult(numbers: List[Double], operations: List[Char]): Double = {
    var result = numbers(0)

    for (i <- 1 to numbers.length - 1) {
      result = operate(result, numbers(i), operations(i - 1))
    }

    return result
  }

  def operate(result: Double, number: Double, operation: Char): Double = {
    var res = result

    if (operation == '+') {
      res += number
    }
    else if (operation == '-') {
      res -= number
    }
    else if (operation == '*') {
      res *= number
    }
    else if (operation == '!') {
      if (number != 0) {
        res /= number
      }
      else {
        Future.successful("You can not divide number to 0!")
      }
    }

    return res
  }
}