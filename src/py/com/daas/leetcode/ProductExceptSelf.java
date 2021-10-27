package py.com.daas.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class ProductExceptSelf {

  public static void main(String[] args) {
    ProductExceptSelf twoSum = new ProductExceptSelf();
    System.out.println("productExceptSelfBruteForce = " + Arrays.toString(twoSum.productExceptSelfBruteForce(new int[]{1,2,3,4})));
    System.out.println("productExceptSelf = " + Arrays.toString(twoSum.productExceptSelf(new int[]{1,2,3,4})));
  }

  // brute force
  public int[] productExceptSelfBruteForce(int[] nums) {
    int[] result = new int[nums.length];
    Arrays.fill(result, 1);
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if(j != i) {
          result[i] *= nums[j];
        }
      }
    }

    return result;
  }

  public int[] productExceptSelf(int[] nums) {
    int[] ln = new int[nums.length];
    int[] rn = new int[nums.length];
    int[] result = new int[nums.length];
    ln[0] = nums[0];
    rn[nums.length-1] = nums[nums.length-1];
    for (int i = 1; i < nums.length; i++) {
      ln[i] = nums[i] * ln[i-1];
    }
    for (int i = nums.length - 2; i >= 0; i--) {
      rn[i] = nums[i] * rn[i+1];
    }

    result[0] = rn[1];
    result[nums.length-1] = ln[nums.length-2];

    for (int i = 1; i < nums.length - 1; i++) {
      result[i] = rn[i+1] * ln[i-1];
    }

    return result;
  }


}
