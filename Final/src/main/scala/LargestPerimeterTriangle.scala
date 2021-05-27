class LargestPerimeterTriangle {
  def bubbleSort(nums: Array[Int]): Array[Int] = {
    var didSwap = false

    for(i <- 0 until nums.length - 1) {
      if(nums(i+1) < nums(i)) {
        val temp = nums(i)
        nums(i) = nums(i+1)
        nums(i+1) = temp
        didSwap = true
      }
    }

    if (didSwap) {
      bubbleSort(nums)
    }
    else {
      nums
    }
  }

  def largestPerimeter(nums: Array[Int]): Int = {

    var arr = bubbleSort(nums)

    var result = 0

    for (i <- 0 to arr.size-3) {
      if (arr(i)<arr(i+1)+arr(i+2) && arr(i+1)<arr(i)+arr(i+2) && arr(i+2)<arr(i)+arr(i+1)) {
        result = (arr(i) + arr(i+1) + arr(i+2))
      }
    }

    return result
  }
}
