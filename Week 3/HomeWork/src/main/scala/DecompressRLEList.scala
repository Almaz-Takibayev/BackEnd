object Solution {
  def decompressRLElist(nums: Array[Int]): Array[Int] = {
    var counter = 0

    for (i <- 0 to nums.length - 1 by 2) {
      counter += nums(i)
    }

    var result = new Array[Int](counter)

    counter = 0

    for (i <- 0 to nums.length - 1 by 2) {
      for (j <- 0 to nums(i) - 1) {
        result(counter) = nums(i + 1)
        counter += 1
      }
    }

    return result
  }
}