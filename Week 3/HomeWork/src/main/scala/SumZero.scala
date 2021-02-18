object Solution {
  def sumZero(n: Int): Array[Int] = {
    var firstPart = 0
    var lastPart = 0

    var result = new Array[Int](n)

    var counter = 1

    if (n % 2 == 1) {
      result(n - 1) = 0
      counter = 2
    }

    for (i <- 0 to n - counter by 2) {
      firstPart -= 1
      lastPart += 1

      result(i) = firstPart
      result(i + 1) = lastPart
    }

    return result
  }
}