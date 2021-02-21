object Solution {
  def findPairs(nums: Array[Int], k: Int): Int = {
    var counter: Int = 0

    var firstPart: List[Int] = List()
    var secondPart: List[Int] = List()

    for (i <- 0 to nums.length - 1) {
      var isExist1 = false

      for (f <- firstPart) {
        if (nums(i) == f) {
          isExist1 = true
        }
      }

      if (!isExist1) {
        for (j <- 0 to nums.length - 1) {
          if (i != j) {
            if (minus(nums(i), nums(j)) == k) {
              var isExist2 = false

              for (s <- secondPart) {
                if (nums(j) == s) {
                  isExist2 = true
                }
              }

              if (!isExist2) {
                counter += 1
                firstPart = firstPart :+ nums(i)
                secondPart = secondPart :+ nums(j)
              }
            }
          }
        }
      }
    }

    counter
  }

  def minus(a: Int, b: Int): Int = {
    return a - b
  }
}