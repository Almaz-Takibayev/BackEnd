class MaximumDepthOfNaryTree {
  def maxDepth(root: Node): Int = {
    if (root == null) {
      return 0
    }

    var max = 0

    for (i <- 0 until root.children.size) {
      val child = root.children(i)
      max = Math.max(max, maxDepth(child))
    }

    return max + 1
  }
}
