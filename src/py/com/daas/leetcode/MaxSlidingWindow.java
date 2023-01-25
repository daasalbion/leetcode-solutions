package py.com.daas.leetcode;

import static py.com.daas.leetcode.BaseExercise.logResult;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        MaxSlidingWindow function = new MaxSlidingWindow();
        logResult("maxSlidingWindow1", Arrays.toString(function.maxSlidingWindow1(new int[]{1, 3, -1, -3, 5, 3, 6, 7},
                3)));
        logResult("maxSlidingWindow", Arrays.toString(function.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 1) return nums;

        int i = 0;
        int resultLength = nums.length - k + 1;
        int[] result = new int[resultLength];

        do {
            int windowLength = i + k;
            result[i] = Integer.MIN_VALUE;
            for (int j = i; j < windowLength; j++) {
                if (nums[j] > result[i]) {
                    result[i] = nums[j];
                }
            }
            i++;
        } while (i < resultLength);

        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1. Use a deque to store the indexes and make sure head has the largest number
        // 2. For each incoming element, we first check whether it's bigger than the nums[last element] of dq. If so, continue to remove nums[last element] of dq
        // 3. Check each head element to see if they are >= (end - k + 1) range. If not, remove head
        // 4. If end + 1 >= k, we update the result using nums[deque.peekFirst()] as head is always the big number's index
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (!deque.isEmpty() && nums[deque.peekLast()] < cur) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }
            deque.addLast(i);

            if (!deque.isEmpty() && (i + 1 >= k)) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
