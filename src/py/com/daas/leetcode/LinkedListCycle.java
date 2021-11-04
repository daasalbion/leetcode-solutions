package py.com.daas.leetcode;

public class LinkedListCycle {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    LinkedListCycle list = new LinkedListCycle();
    ListNode listNode4 = new ListNode(-4, new ListNode(2));
    ListNode listNode3 = new ListNode(0, listNode4);
    ListNode listNode2 = new ListNode(2, listNode3);
    ListNode listNode1 = new ListNode(3, listNode2);

    System.out.println("isValid = " + list.hasCycle(listNode1));
  }

  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    // two pointers
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != null && fast != null) {
      if (slow == fast) return true;
      slow = slow.next;
      if (fast.next == null) break;
      fast = fast.next.next;
    }

    return false;
  }

}
