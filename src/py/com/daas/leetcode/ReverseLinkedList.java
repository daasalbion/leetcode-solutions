package py.com.daas.leetcode;

import java.util.Stack;

import py.com.daas.leetcode.utils.LinkedListUtil;
import py.com.daas.leetcode.utils.LinkedListUtil.ListNode;

public class ReverseLinkedList {

    /*
    Given the head of a singly linked list, reverse the list, and return the reversed list.
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]
     */

    public static void main(String[] args) {
        LinkedListUtil.ListNode head = LinkedListUtil.build(1);
        LinkedListUtil.ListNode two = LinkedListUtil.build(2, head);
        LinkedListUtil.ListNode three = LinkedListUtil.build(3, two);
        LinkedListUtil.ListNode four = LinkedListUtil.build(4, three);
        LinkedListUtil.build(5, four);

        LinkedListUtil.print(head);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode newHead = reverseLinkedList.reverseList3(head);
        LinkedListUtil.print(newHead);
    }

    public ListNode reverseList2(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        ListNode pointer = head;
        while (pointer != null) {
            ListNode next = pointer.next;
            // 1 -> null
            // 2 -> 1 -> null
            // ...
            // 5 -> 4 -> 3 -> 2 -> 1
            pointer.next = fakeHead.next;
            // last pointer updated
            fakeHead.next = pointer;
            pointer = next;
        }

        return fakeHead.next;
    }

    public ListNode reverseList3(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        reverse(head, fakeHead);
        return fakeHead.next;
    }

    private ListNode reverse(ListNode head, ListNode fakeHead) {
        if (head == null) {
            return fakeHead;
        }

        ListNode tail = reverse(head.next, fakeHead);
        tail.next = head;
        head.next = null;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        // 5, 4, 3, 2, 1
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        ListNode newHead = new ListNode(0);
        ListNode pointer = newHead;
        // 0 -> 5 -> 4
        while (!stack.isEmpty()) {
            ListNode current = stack.pop();
            pointer.next = current;
            pointer = current;
        }

        pointer.next = null;

        return newHead.next;
    }

}
