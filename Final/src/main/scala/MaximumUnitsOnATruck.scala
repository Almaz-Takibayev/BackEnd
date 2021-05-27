class MaximumUnitsOnATruck {
  def maximumUnits(boxTypes: Array[Array[Int]], truckSize: Int): Int = {
    var result = 0
    var sizeOfTruck = truckSize


    var boxes = Array.fill[Int](1001)(0)

    for (i <- 0 until boxTypes.length) {
      boxes(boxTypes(i)(1)) += boxTypes(i)(0)
    }

    var i = 1000

    while (i >= 0) {
      if (boxes(i) > 0) {
        if (boxes(i) <= sizeOfTruck) {
          result = result + (boxes(i) * i)
          sizeOfTruck = sizeOfTruck - boxes(i)
        }
        else if (sizeOfTruck < boxes(i) && sizeOfTruck != 0) {
          result = result + (sizeOfTruck * i)
          sizeOfTruck = 0
        }
      }

      if (sizeOfTruck == 0) {
        return result
      }

      i -= 1
    }

    return result
  }
}
