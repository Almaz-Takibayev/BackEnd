object Solution {
  def buildArray(target: Array[Int], n: Int): List[String] = {
    var result: List[String] = List()

    var i = 1
    var j = 0

    while (i <= n && i <= target(target.length - 1)) {
      if (i == target(j)) {
        j += 1
        result = result :+ "Push"
      }
      else {
        result = result :+ "Push"
        result = result :+ "Pop"
      }

      i += 1
    }

    return result
  }
}