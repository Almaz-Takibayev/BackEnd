object Solution {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    var nums01 = nums1.distinct
    var nums02 = nums2.distinct

    var count = 0

    for (i <- 0 to nums01.length - 1) {
      for (j <- 0 to nums02.length - 1) {
        if (nums01(i) == nums02(j)) {
          count += 1
        }
      }
    }

    var result = new Array[Int](count)

    count = 0

    for (i <- 0 to nums01.length - 1) {
      for (j <- 0 to nums02.length - 1) {
        if (nums01(i) == nums02(j)) {
          result(count) = nums01(i)
          count += 1
        }
      }
    }

    return result
  }
}