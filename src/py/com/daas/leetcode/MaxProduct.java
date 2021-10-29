package py.com.daas.leetcode;

public class MaxProduct {

  public static void main(String[] args) {
    MaxProduct twoSum = new MaxProduct();
    System.out.println("maxProduct = " + twoSum.maxProduct(new int[]{0, 2}));
    System.out.println("maxProduct = " + twoSum.maxProduct(new int[]{-4, -3}));
    System.out.println("maxProduct = " + twoSum.maxProduct(new int[]{-2, 0, -1}));
    System.out.println("maxProduct = " + twoSum.maxProduct(new int[]{2, 3, -2, 4}));
  }

  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int max = nums[0];
    int min = nums[0];
    int maxProduct = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int a = nums[i] * max;
      int b = nums[i] * min;
      max = Math.max(Math.max(a, b), nums[i]);
      min = Math.min(Math.min(a, b), nums[i]);
      maxProduct = Math.max(maxProduct, max);
    }

    return maxProduct;
  }

}
