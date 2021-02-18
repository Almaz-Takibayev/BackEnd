object Solution {
  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = {
    var result = new Array[Int](k)

    var arr = new Array[Int](mat.length)

    var counter = 0

    var maxNum = 0
    var minNum = mat(0).length

    for (i <- 0 to mat.length - 1) {
      counter = 0
      for (j <- 0 to mat(i).length - 1) {
        counter += mat(i)(j)
      }
      if (maxNum < counter) {
        maxNum = counter
      }
      if (minNum > counter) {
        minNum = counter
      }
      arr(i) = counter
    }

    counter = 0

    for (i <- minNum to maxNum) {
      for (j <- 0 to arr.length - 1) {
        if (i == arr(j)) {
          result(counter) = j
          counter += 1
        }

        if (counter == k) {
          return result
        }
      }
    }

    return arr
  }
}
