package py.com.daas.leetcode;

import static py.com.daas.leetcode.BaseExercise.logResult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        MergeKLists twoSum = new MergeKLists();
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(4);
        listNode12.next = new ListNode(5);
        listNode11.next = listNode12;

        ListNode listNode21 = new ListNode(1);
        ListNode listNode23 = new ListNode(3);
        listNode23.next = new ListNode(4);
        listNode21.next = listNode23;

        ListNode listNode31 = new ListNode(2);
        ListNode listNode32 = new ListNode(6);
        listNode31.next = listNode32;
        List<ListNode> list = new ArrayList<>();
        list.add(listNode11);
        list.add(listNode21);
        list.add(listNode31);

        logResult("mergeTwoLists", twoSum.mergeKLists(list.toArray(new ListNode[0])).toString());
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode ptr = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            if (curr.next != null) {
                queue.add(curr.next);
            }
            if (head == null) {
                head = curr;
                ptr = head;
            } else {
                ptr.next = curr;
                ptr = ptr.next;
            }
        }
        return head;
    }

}
