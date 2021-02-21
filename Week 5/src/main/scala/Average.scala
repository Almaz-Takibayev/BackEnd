object Solution {
  def average(salary: Array[Int]): Double = {
    salary.sorted.slice(1, salary.length-1).reduce((a, b) => a+b).toDouble/(salary.length-2)
  }
}