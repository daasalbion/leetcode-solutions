package py.com.daas.leetcode.array;

import static py.com.daas.leetcode.BaseExercise.logResult;
import static py.com.daas.leetcode.BaseExercise.printLine;
import static py.com.daas.leetcode.BaseExercise.printWithTab;

public class Arrays {

    public static void main(String[] args) {
        /*
            Caracteristicas
            1) homogeneo
            2) tamanho fijo
         */
        // definitions
        int[] zeroes = new int[5];
        int[] nums = new int[]{1, 3, 4, 5};
        int[][] matrix = {{1, 3}, {1, 3}};
        int[][][] arr = {{{1, 2}, {3, 4}}, {{5, 6}}};
        logResult("matrix", java.util.Arrays.toString(matrix));
        logResult("arr", java.util.Arrays.toString(arr));

        printRow(zeroes);
        printRow(nums);
        printMat(matrix);
    }

    private static void printRow(int[] row) {
        for (int c: row)
            printWithTab(String.valueOf(c));
        printLine();
    }

    private static void printMat(int[][] mat) {
        // se obtienen las filas
        for (int[] c: mat)
            printRow(c);
        printLine();
    }
}
