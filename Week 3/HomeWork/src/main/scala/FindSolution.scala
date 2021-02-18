/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     def f(x: Int, y: Int): Int = {}
 * };
 */

object Solution {
  def findSolution(customfunction: CustomFunction, z: Int): List[List[Int]] = {
    var result: List[List[Int]] = List()

    var y = 1000

    for (x <- 1 to 1000) {
      while (y > 1 && customfunction.f(x, y) > z) {
        y -= 1
      }
      if (customfunction.f(x, y) == z) {
        result = List(x, y) :: result
      }
    }

    return result
  }
}
