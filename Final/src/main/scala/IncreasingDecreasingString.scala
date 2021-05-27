class IncreasingDecreasingString {
  def sum(arr: Array[Int]): Int = {
    var result = 0

    for (a <- arr) {
      result += a
    }

    return result
  }

  def sortString(s: String): String = {
    var isSorted = false

    var arr = Array.fill[Int](26)(0)

    var chars = s.toLowerCase.toCharArray

    for (i <- 0 until chars.length) {
      arr(chars(i).toInt - 97) += 1
    }

    var result: String = ""

    while (!isSorted) {
      for (i <- 0 until 26) {
        if (arr(i) != 0) {
          result = result.concat((i + 97).toChar.toString)
          arr(i) -= 1
        }
      }

      var j = 25

      while (j >= 0) {
        if (arr(j) != 0) {
          result = result.concat((j + 97).toChar.toString)
          arr(j) -= 1
        }
        j -= 1
      }

      if (sum(arr) == 0) {
        isSorted = true
      }
    }

    return result
  }
}
