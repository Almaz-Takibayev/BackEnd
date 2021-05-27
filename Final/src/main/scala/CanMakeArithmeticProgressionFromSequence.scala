class CanMakeArithmeticProgressionFromSequence {
  def bubbleSort(arr: Array[Int]): Array[Int] = {
    var didSwap = false

    for (i <- 0 until arr.length - 1) {
      if (arr(i + 1) < arr(i)) {
        val temp = arr(i)
        arr(i) = arr(i + 1)
        arr(i + 1) = temp
        didSwap = true
      }
    }

    if (didSwap) {
      bubbleSort(arr)
    }
    else {
      arr
    }
  }

  def canMakeArithmeticProgression(arr: Array[Int]): Boolean = {
    var nums = bubbleSort(arr)

    var difference = nums(1) - nums(0)

    for (i <- 0 until nums.size - 1) {
      if (difference != (nums(i + 1) - nums(i))) {
        return false
      }
    }

    return true
  }
}
