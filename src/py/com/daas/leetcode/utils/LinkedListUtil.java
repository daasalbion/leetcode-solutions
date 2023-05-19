package py.com.daas.leetcode.utils;

import java.util.List;
import java.util.stream.Collectors;

public class LinkedListUtil {

    private LinkedListUtil() {
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode build(String strArray) {
        List<Integer> values = strArray.trim().chars()
                .filter(Character::isDigit)
                .boxed()
                .map(c -> c-'0')
                .collect(Collectors.toList());
        ListNode fakeHead = new ListNode(-1);
        ListNode pointer = fakeHead;
        for (Integer v : values) {
            ListNode current = new ListNode(v);
            pointer.next = current;
            pointer = current;
        }

        return fakeHead.next;
    }

    public static ListNode build(int data) {
        return new ListNode(data, null);
    }

    /**
     * @param data     int
     * @param listNode node
     * @return
     */
    public static ListNode build(int data, ListNode listNode) {
        ListNode newListNode = build(data);
        listNode.next = newListNode;
        return newListNode;
    }

    public static void print(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.printf("%s", head.val);
            head = head.next;
            if (head != null)
                System.out.print(", ");
        }
        System.out.print("]");
        System.out.println("");
    }
}
