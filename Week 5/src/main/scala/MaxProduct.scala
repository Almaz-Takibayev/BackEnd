object Solution {
  def maxProduct(nums: Array[Int]): Int = {
    nums.sorted.slice(nums.length-2, nums.length).reduce((i, j) => (i-1)*(j-1))
  }
}