package py.com.daas.leetcode;

import py.com.daas.leetcode.utils.LinkedListUtil.ListNode;

public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle list = new LinkedListCycle();
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(-4, listNode2);
        ListNode listNode0 = new ListNode(0, listNode4);
        listNode2.next = listNode0;
        ListNode head = new ListNode(3, listNode2);

        //LinkedListUtil.print(head);

        System.out.println("isValid = " + list.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        //[3,2,0,-4,2]
        // 3, 2, 0, -4
        // 2, -4, -4, 2
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr)
                return true;
        }

        return false;
    }

}
