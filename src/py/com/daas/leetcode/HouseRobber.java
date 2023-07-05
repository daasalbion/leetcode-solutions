package py.com.daas.leetcode;

public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[]{1, 3, 1}));
        System.out.println(houseRobber.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(houseRobber.rob(new int[]{1, 3, 7, 8, 0, 7}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length < 3) return Math.max(nums[0], nums[1]);

        // max(nums[i-2] + nums[i], nums[i-1])
        int firstHouse = nums[0];
        int secondHouse = Math.max(firstHouse, nums[1]);
        int result = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length; i++) {
            int sum = nums[i] + firstHouse;
            result = Math.max(secondHouse, sum);
            firstHouse = secondHouse;
            secondHouse = sum;
        }

        return result;
    }

}
