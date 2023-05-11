package py.com.daas.leetcode;

import static py.com.daas.leetcode.BaseExercise.logResult;

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        AddTwoNumbers exercise = new AddTwoNumbers();
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(9, listNode3);
        ListNode list1 = new ListNode(9, listNode4);

        ListNode listNode24 = new ListNode(9);
        ListNode listNode6 = new ListNode(9, listNode24);
        ListNode list2 = new ListNode(9, listNode6);

        ListNode result = exercise.addTwoNumbers(list1, list2);
        logResult("addTwoNumbers", result.toString());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // podes invertir l1 y l2
        ListNode result = new ListNode(-1);
        ListNode prev = result;
        ListNode curr;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            curr = new ListNode(sum % 10);
            prev.next = curr;
            prev = curr;
        }
        // sumarlos
        // invertir de nuevo
        return result.next;
    }

}
