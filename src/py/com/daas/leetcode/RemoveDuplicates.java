package py.com.daas.leetcode;

import static py.com.daas.leetcode.BaseExercise.logResult;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates twoSum = new RemoveDuplicates();
        logResult("countSubstrings", String.valueOf(twoSum.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3, 4, 4, 5})));
        logResult("countSubstrings", String.valueOf(twoSum.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4})));
    }

    public int removeDuplicates(int[] nums) {
        // iterar sobre los numeros y guardarlos en un hashmap
        // si ya existe solo ignorarlo
        if (nums.length == 1)
            return 1;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
