package py.com.daas.leetcode;

public class BaseExercise {

    private BaseExercise() {}

    public static void logResult(String name, String result) {
        String message = String.format("exercise = %s, result = %s", name, result);
        System.out.println(message);
    }
}
