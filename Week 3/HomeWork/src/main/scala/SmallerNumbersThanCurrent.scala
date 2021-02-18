object Solution {
  def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
    var result = new Array[Int](nums.length)

    for (i <- 0 to nums.length - 1) {
      var res = 0
      for (j <- 0 to nums.length - 1) {
        if (nums(i) > nums(j)) {
          res += 1
        }
      }
      result(i) = res
    }

    return result
  }
}