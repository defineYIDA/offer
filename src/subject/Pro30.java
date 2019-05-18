package subject;

import stack.Stack;

/**
 * @Author: zl
 * @Date: 2019/5/18 17:11
 */
public class Pro30 {
    Stack<Integer> mainStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int node) {
        if (minStack.size() == 0 || minStack.peek() > node) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
        mainStack.push(node);
    }

    public void pop() {
        if (minStack.size() > 0 && mainStack.size() > 0) {
            mainStack.pop();
            minStack.pop();
        }

    }

    public int top() {
        return mainStack.peek();
    }

    public int min() {
        if (minStack.size() > 0) {
            return minStack.peek();
        }
        return -1;
    }
}
