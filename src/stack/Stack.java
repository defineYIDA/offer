package stack;
import link.LinkedList;
/**
 * @Author: zl
 * @Date: 2019/4/14 0:25
 */
public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<T>();
    int count = 0;
    public void push(T v) {
        count++;
        storage.addFirst(v);
    }
    public T peek() {
        return storage.getFirst();
    }
    public T pop() {
        count--;
        return storage.removeFirst();
    }
    public boolean isEmpty() {
        return storage.isEmpty();
    }
    public int size(){
        return count;
    }
    public String toString() { return storage.toString(); }
}
