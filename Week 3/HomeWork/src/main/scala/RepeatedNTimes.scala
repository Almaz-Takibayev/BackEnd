object Solution {
  def repeatedNTimes(A: Array[Int]): Int = {
    var result: Int = 0
    for (i <- 0 to A.length - 1) {
      var counter = 0
      for (j <- 0 to A.length - 1) {
        if (A(i) == A(j)) {
          counter += 1
        }
      }
      if (counter == (A.length / 2)) {
        result = A(i)
      }
    }

    return result
  }
}