package subject;

import stack.Stack;

/**
 * @Author: zl
 * @Date: 2019/5/18 17:20
 */
public class Pro31 {
    /**
     *压入顺序和弹出顺序是否匹配
     * 思路：
     *如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。
     * 如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，
     * 直到把下一个需要弹出的数字压入栈顶为止。如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，
     * 那么该序列不可能是一个弹出序列。
     *
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (stack.size() > 0 && stack.peek() == popped[j]) {
                stack.pop();
                j++;

            }
        }
        return stack.size() == 0;

    }
}
