package py.com.daas.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class ContainsDuplicate {

  public static void main(String[] args) {
    ContainsDuplicate twoSum = new ContainsDuplicate();
    System.out.println("containsDuplicate = " + twoSum.containsDuplicate(new int[]{1,2,3,1}));
  }

  public boolean containsDuplicate(int[] nums) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if(hashMap.containsKey(nums[i])) {
        hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
      } else {
        hashMap.put(nums[i], 1);
      }
    }

    return (nums.length > hashMap.size());
  }


}
