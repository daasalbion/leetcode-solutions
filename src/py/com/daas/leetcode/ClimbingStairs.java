package py.com.daas.leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs exercise = new ClimbingStairs();
        System.out.println(exercise.climbStairs(3));
    }

    /*
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Example 1:

    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

    Example 2:

    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step

     */
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int oneStep = 1;
        int twoStep = 2;
        int steps = 0;
        for (int i = 3; i <= n; i++) {
            steps = oneStep + twoStep;
            oneStep = twoStep;
            twoStep = steps;
        }

        return steps;
    }
}
