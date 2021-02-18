/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
  def getDecimalValue(head: ListNode): Int = {
    var result = 0

    var listHead = head

    while (listHead != null) {
      result = (result * 2) + listHead.x
      listHead = listHead.next
    }

    return result
  }
}