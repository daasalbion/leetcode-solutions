package py.com.daas.leetcode;

public class MaxProfit {

  public static void main(String[] args) {
    MaxProfit twoSum = new MaxProfit();
    System.out.println("maxProfix = " + twoSum.maxProfit(new int[]{7,1,5,3,6,4}));
  }

  public int maxProfitBruteForce(int[] prices) {
    int profit = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        int diff = prices[j] - prices[i];
        if(diff > 0 && diff > profit) {
          profit = diff;
        }
      }
    }

    return profit;
  }

  public int maxProfit(int[] prices) {
    int minprice = Integer.MAX_VALUE;
    int maxprofit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minprice)
        minprice = prices[i];
      else if (prices[i] - minprice > maxprofit)
        maxprofit = prices[i] - minprice;
    }
    return maxprofit;
  }


}
