object Solution {
  def kidsWithCandies(candies: Array[Int], extraCandies: Int): Array[Boolean] = {
    var result = new Array[Boolean](candies.length)

    var maxCandy = 0

    for (candy <- candies) {
      if (candy > maxCandy) {
        maxCandy = candy
      }
    }

    var i = 0

    for (candy <- candies) {
      if (candy + extraCandies >= maxCandy) {
        result(i) = true
      }
      else {
        result(i) = false
      }

      i += 1
    }

    result
  }
}