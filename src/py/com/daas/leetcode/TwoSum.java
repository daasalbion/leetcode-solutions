package py.com.daas.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println("twoSum = " + Arrays.toString(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("twoSumWithHash = " + Arrays.toString(twoSum.twoSumWithHash(new int[]{3, 2, 4}, 6)));
    }

    //[2,7,11,15], 9
    // brute force
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public int[] twoSumWithHash(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            // buscas el que falta
            int sus = target - nums[i];
            if (hashMap.containsKey(sus) && hashMap.get(sus) != i) {
                return new int[]{i, hashMap.get(sus)};
            }
        }

        return new int[]{};
    }

}
