package py.com.daas.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import py.com.daas.leetcode.utils.LinkedListUtil;
import py.com.daas.leetcode.utils.LinkedListUtil.ListNode;

public class MergeTwoSortedLists {

    /*
    You are given the heads of two sorted linked lists list1 and list2.

    Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

    Return the head of the merged linked list.

    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]
    Example 2:

    Input: list1 = [], list2 = []
    Output: []
    Example 3:

    Input: list1 = [], list2 = [0]
    Output: [0]
     */
    public static void main(String[] args) {
        LinkedListUtil.ListNode list1 = LinkedListUtil.build("[1,2,4]");
        LinkedListUtil.ListNode list2 = LinkedListUtil.build("[1,2,4]");

        MergeTwoSortedLists exercise = new MergeTwoSortedLists();
        ListNode newHead = exercise.mergeTwoLists(list1, list2);
        LinkedListUtil.print(newHead);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        Deque<ListNode> deque = new ArrayDeque<>();
        // 1 -> 1 -> 3
        while (p1 != null || p2 != null) {
            if (p1 != null && p2 != null) {
                if (p1.val == p2.val) {
                    deque.add(p1);
                    deque.add(p2);
                    p1 = p1.next;
                    p2 = p2.next;
                } else if (p1.val < p2.val) {
                    deque.add(p1);
                    p1 = p1.next;
                } else {
                    deque.add(p2);
                    p2 = p2.next;
                }
            } else if (p1 != null) {
                deque.add(p1);
                p1 = p1.next;
            } else {
                deque.add(p2);
                p2 = p2.next;
            }
        }

        ListNode fakeHead = new ListNode(-1);
        ListNode pointer = fakeHead;
        // [1,1,2,3,4,4]
        while (!deque.isEmpty()) {
            // 1
            ListNode current = deque.pollFirst();
            // -1 -> 1
            // 1 -> 1
            pointer.next = current;
            pointer = current;
        }
        pointer.next = null;

        return fakeHead.next;
    }
}
