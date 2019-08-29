package top100interview;

import java.util.Stack;

/**
 * @Author: zl
 * @Date: 2019/8/29 9:02
 */
public class leetcode20 {
    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (isTar(t)) {
                if (!stack.isEmpty() && reverse(stack.peek()) == t) {
                    stack.pop();
                } else {
                    stack.add(t);
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isTar(char c) {
        if (c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']') {
            return true;
        }
        return false;
    }

    private char reverse(char c) {
        if (c == '(') {
            return ')';
        }
        if (c == '{') {
            return '}';
        }
        if (c == '[') {
            return ']';
        }
        return c;
    }
}
