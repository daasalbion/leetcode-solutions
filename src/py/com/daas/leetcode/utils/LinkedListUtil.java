package py.com.daas.leetcode.utils;

public class LinkedListUtil {

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

    public static ListNode build(int data) {
        return new ListNode(data, null);
    }

    /**
     * @param data int
     * @param listNode node
     * @return
     */
    public static ListNode build(int data, ListNode listNode) {
        ListNode newListNode = build(data);
        listNode.next = newListNode;
        return newListNode;
    }

    public static void print(ListNode head) {
        while(head != null) {
            System.out.println(head.val + ", ");
            head = head.next;
        }
        System.out.println("END");
    }
}
