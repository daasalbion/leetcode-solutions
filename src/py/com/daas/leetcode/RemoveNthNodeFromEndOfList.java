package py.com.daas.leetcode;

import py.com.daas.leetcode.utils.LinkedListUtil;
import py.com.daas.leetcode.utils.LinkedListUtil.ListNode;

public class RemoveNthNodeFromEndOfList {

    /*
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]

    Example 2:

    Input: head = [1], n = 1
    Output: []

    Input: head = [1,2], n = 1
    Output: [1]
     */
    public static void main(String[] args) {
        LinkedListUtil.ListNode head = LinkedListUtil.build(1);
        /*LinkedListUtil.ListNode two = LinkedListUtil.build(2, head);
        LinkedListUtil.ListNode three = LinkedListUtil.build(3, two);
        LinkedListUtil.ListNode four = LinkedListUtil.build(4, three);
        LinkedListUtil.build(5, four);*/

        LinkedListUtil.print(head);
        RemoveNthNodeFromEndOfList exercise = new RemoveNthNodeFromEndOfList();
        //exercise.removeNthFromEnd(head, 2);
        exercise.removeNthFromEnd(head, 1);
        LinkedListUtil.print(head);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        // [1, 2, 3, 4, 5] n = 2
        // fast -> [3] -> 4 -> 5 -> null
        // slow -> [1] -> 2 -> 3
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
