object Solution {
  def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
    var months: Array[Int] = Array(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    var days: Int = 0
    var daysOfTheWeek = Array("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    for (i <- 1971 to year - 1) {
      if (isLeapYear(i)) {
        days = add(days, 1)
      }
      days = add(days, 365)
    }

    for (i <- 1 to month - 1) {
      if (i == 2 && isLeapYear(year)) {
        days = add(days, 1)
      }

      days = add(days, months(i))
    }

    days = add(days, day)

    return daysOfTheWeek(add(3, days) % 7)
  }

  def isLeapYear(year: Int): Boolean = {
    if (year % 400 == 0) {
      return true
    }
    if (year % 100 == 0) {
      return false
    }
    if (year % 4 == 0) {
      return true
    }
    return false

  }

  def add(a: Int, b:Int): Int = {
    return a+b
  }
}