class IntersectionOfTwoArrays {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    var set1 = nums1.toSet
    var set2 = nums2.toSet

    var result = List[Int]()

    for (s1 <- set1) {
      for (s2 <- set2) {
        if (s1 == s2) {
          result = s1 :: result
        }
      }
    }

    return result.toArray
  }
}
