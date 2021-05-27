class ValidAnagram {
  def isAnagram(s: String, t: String): Boolean = {
    if (s.length != t.length) {
      return false
    }

    var chars1 = s.toCharArray.sortWith(_ < _)
    var chars2 = t.toCharArray.sortWith(_ < _)

    for (i <- 0 until chars1.length) {
      if (chars1(i) != chars2(i)) {
        return false
      }
    }

    return true
  }
}