package py.com.daas.leetcode;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static py.com.daas.leetcode.BaseExercise.logResult;

public class MergeTwoLists {

    public static void main(String[] args) {
        MergeTwoLists twoSum = new MergeTwoLists();
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        listNode12.next = new ListNode(4);
        listNode11.next = listNode12;

        ListNode listNode21 = new ListNode(1);
        ListNode listNode23 = new ListNode(3);
        listNode23.next = new ListNode(4);
        listNode21.next = listNode23;

        logResult("mergeTwoLists", twoSum.mergeTwoLists(listNode11, listNode21).toString());
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (nonNull(list1) && nonNull(list2)) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        if (isNull(list1)) return list2;

        return list1;
    }

    public static class ListNode {
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

}
