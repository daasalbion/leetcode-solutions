package py.com.daas.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

  public static void main(String[] args) {
    ValidParentheses twoSum = new ValidParentheses();
    System.out.println("isValid = " + twoSum.isValid("()"));
    System.out.println("isValid = " + twoSum.isValid("[(}]"));
  }

  public boolean isValid(String s) {
    // validations
    if ((s.length() % 2 != 0)) return false;

    Deque<Character> deque = new ArrayDeque<>();
    for (Character ch : s.toCharArray()) {
      if (ch == '(' || ch == '[' || ch == '{') {
        deque.addFirst(ch);
      } else if (ch == '}' || ch == ']' || ch == ')') {
        if(deque.isEmpty()) return false;

        Character prev = deque.peekFirst();
        if ((prev == '{' && ch == '}') || (prev == '[' && ch == ']') || (prev == '(' && ch == ')')) {
          deque.removeFirst();
        } else {
          return false;
        }
      }
    }

    return deque.isEmpty();
  }


}
