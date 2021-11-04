package py.com.daas.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ReverseList {

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
    ReverseList list = new ReverseList();
    ListNode listNode4 = new ListNode(4);
    ListNode listNode3 = new ListNode(3, listNode4);
    ListNode listNode2 = new ListNode(2, listNode3);
    ListNode listNode1 = new ListNode(1, listNode2);

    System.out.println("isValid = " + list.reverseList(listNode1));
    System.out.println("isValid = " +  list.reverseListIterative(listNode1));
  }

  public ListNode reverseList(ListNode head) {
    ListNode fakeNode = new ListNode(-1);
    reverse(fakeNode, head);
    return fakeNode.next;
  }

  public ListNode reverseListIterative(ListNode head) {
    ListNode fakeNode = new ListNode(-1);
    ListNode node = head;
    while (node != null) {
      ListNode nodeNext = node.next;
      node.next = fakeNode.next;
      fakeNode.next = node;
      node = nodeNext;
    }
    return fakeNode.next;
  }

  public ListNode reverse(ListNode fakeNode, ListNode head) {
    if (head == null) {
      return fakeNode;
    } else {
      ListNode tail = reverse(fakeNode, head.next);
      tail.next = head;
      head.next = null;
      return head;
    }
  }

}
