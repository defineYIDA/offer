package link;

import java.util.NoSuchElementException;

/**
 * @Author: zl
 * @Date: 2019/4/13 17:10
 */
public class LinkedList<T> {
    private static class  Node<T>{
        Node<T> prev;
        T item;
        Node<T> next;
        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node<T> first;
    private Node<T> last;
    private int size =0;

    //新增元素
    public boolean add(T t) {
        linkLast(t);
        return true;
    }
    //指定位置加入元素
    public void add(int index,T element) throws Exception {
        if(!(index >= 0 && index <= size)){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    void linkLast(T t) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, t, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    /**
     * Inserts element e before non-null Node succ.
     */
    void linkBefore(T t, Node<T> succ) {
        // assert succ != null;
        final Node<T> pred = succ.prev;
        final Node<T> newNode = new Node<>(pred, t, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }
    private void linkFirst(T t) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(null, t, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    public T get(int index) {
        if(!(index >= 0 && index < size)){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        return node(index).item;
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    /**
     * 根据索引查找元素
     * @param index
     * @return
     */
    Node<T> node(int index) {
        // assert isElementIndex(index);
        //这里做了个均衡，判断当前索引的位置和中间位置的大小关系
        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    //删除元素
    public T remove(int index) {
        if(!(index >= 0 && index < size)){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        return unlink(node(index));
    }
    public T removeFirst() {
        final Node<T> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }
    T unlink(Node<T> x) {
        // assert x != null;
        final T element = x.item;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;
        //直接前驱为null，首节点
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }
    //替换节点
    public T set(int index, T element) {
        if(!(index >= 0 && index < size)){
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        Node<T> x = node(index);
        T oldVal = x.item;
        x.item = element;
        return oldVal;
    }
    public int size(){
        return size;
    }

    public void addFirst(T t) {
        linkFirst(t);
    }

    public T getFirst() {
        final Node<T> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }
    private T unlinkFirst(Node<T> f) {
        // assert f == first && f != null;
        final T element = f.item;
        final Node<T> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.add("a" );
        list.add("b" );
        list.add("c" );
        list.add("d" );
        list.add("e" );
        list.add("f" );
        System.out.println(list.size());
        list.remove(3);
        list.add(2, "新节点" );
        list.set(4, "替换");
        for (int i = 0; i <list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}


