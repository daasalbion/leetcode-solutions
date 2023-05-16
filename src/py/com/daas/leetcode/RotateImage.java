package py.com.daas.leetcode;

import java.util.Arrays;

public class RotateImage {
    /*

    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

    Input: matrix = [
        [1,2,3],
        [4,5,6],
        [7,8,9]
    ]
    Output: [
        [7,4,1],
        [8,5,2],
        [9,6,3]
    ]
    */

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public void rotate(int[][] matrix) {
        /*
            0)
            1 -> 3 -> 9 -> 7
            2 -> 6 -> 8 -> 4

         */
        int n = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < n - i; j++) {
                int val1 = matrix[i][j];
                int val2 = matrix[j][n - i];
                int val3 = matrix[n - i][n - j];
                int val4 = matrix[n - j][i];
                matrix[i][j] = val4;
                matrix[j][n - i] = val1;
                matrix[n - i][n - j] = val2;
                matrix[n - j][i] = val3;
            }
        }
        Arrays.stream(matrix).forEach(r -> System.out.println(Arrays.toString(r)));
    }
}
