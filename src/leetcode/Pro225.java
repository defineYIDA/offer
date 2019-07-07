package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zl
 * @Date: 2019/7/7 10:20
 */
public class Pro225 {
    Queue<Integer> q1 = null;
    Queue<Integer> q2 = null;
    int front;
    /** Initialize your data structure here. */
    public Pro225() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        front = x;
        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size() > 1) {
            front = q1.poll();
            q2.add(front);
        }
        int res = q1.poll();
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        return front;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main (String[] args) {
        Pro225 p = new Pro225();
        p.push(1);
        p.push(2);
        p.push(3);
        p.pop();
        p.pop();
        p.pop();
        System.out.println(p.empty());
    }
}
