package py.com.daas.leetcode;

public class BaseExercise {

    private BaseExercise() {}

    public static void printLine() {
        System.out.println();
    }

    public static void printWithTab(Object object) {
        String message = String.format("%s\t", object);
        System.out.print(message);
    }

    public static void logResult(String name, String result) {
        String message = String.format("exercise = %s, result = %s", name, result);
        System.out.println(message);
    }
}
