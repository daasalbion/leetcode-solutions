package py.com.daas.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

  public static void main(String[] args) {
    MergeIntervals twoSum = new MergeIntervals();
    System.out.println("mergeIntervals = " + Arrays.toString(twoSum.mergeIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
  }

  /*

  a + b + c = 0
  b + c = 0 - a
  * Solution: [[-1, 0, 1], [-1, -1, 2]]
  * order [-4, -1, -1, 2, 1, 2]
  * */
  public int[][] mergeIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    LinkedList<int[]> merged = new LinkedList<>();
    for (int[] interval : intervals) {
      if(merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.add(interval);
      } else {
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }

    return merged.toArray(new int[merged.size()][]);
  }

}
