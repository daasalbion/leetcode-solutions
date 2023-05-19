package py.com.daas.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import py.com.daas.leetcode.utils.LinkedListUtil;
import py.com.daas.leetcode.utils.LinkedListUtil.ListNode;

public class PalindromeLinkedList {
    /*
    Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

    Input: head = [1,2,2,1]
    Output: true
    Input: head = [1,2]
    Output: false
     */
    public static void main(String[] args) {
        PalindromeLinkedList exercise = new PalindromeLinkedList();
        ListNode head = LinkedListUtil.build("[1");
        ListNode head2 = LinkedListUtil.build("[1,1,2,1]");
        ListNode head3 = LinkedListUtil.build("[1,2]");
        System.out.println(exercise.isPalindrome2(head));
        System.out.println(exercise.isPalindrome2(head2));
        System.out.println(exercise.isPalindrome(head3));
    }

    public boolean isPalindrome(ListNode head) {
        // reverse head and then compare one by one
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.add(head);
            head = head.next;
        }

        while (!deque.isEmpty()) {
            ListNode left = deque.peekFirst();
            ListNode right = deque.peekLast();
            if (left != null && right != null && left.val == right.val) {
                deque.pollFirst();
                deque.pollLast();
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        // find the middle
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        //[2,1]
        // slowPtr is in the middle, we can reverse
        ListNode fakeHead = new ListNode(-1);
        ListNode pointer = slowPtr;
        while (pointer != null) {
            ListNode next = pointer.next;
            pointer.next = fakeHead.next;
            fakeHead.next = pointer;
            pointer = next;
        }
        ListNode halfInverted = fakeHead.next;

        while (head != null && halfInverted != null) {
            if (head.val == halfInverted.val) {
                head = head.next;
                halfInverted = halfInverted.next;
            } else {
                return false;
            }
        }

        return true;
    }

}
