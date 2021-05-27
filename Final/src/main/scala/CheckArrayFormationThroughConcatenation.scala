class CheckArrayFormationThroughConcatenation {
  def canFormArray(arr: Array[Int], pieces: Array[Array[Int]]): Boolean = {
    var map: Map[Int, Array[Int]] = Map[Int, Array[Int]]()

    for (piece <- pieces) {
      map += (piece(0) -> piece)
    }

    var i = 0

    while (i < arr.size) {
      if (!(map.contains(arr(i)))) return false
      var piece = map.get(arr(i)).get
      for (j <- 0 until piece.size) {
        if (piece(j) != arr(i)) return false
        i += 1
      }
    }

    return true
  }
}