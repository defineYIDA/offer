package link;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/3/13 22:16
 */
public class StaticLinkedList<T> {
    /**
     * 节点类
     * @param <T>
     */
    public static class Node<T>{
        private T value;
        private int cur;

        public Node(T data, int cur){
            this.value = data;
            this.cur = cur;
        }
    }
    private Node<T>[] data;
    private static int MAXSIZE = 1000; //初始化相对建立的大一些，以便有空闲空间保证插入时不至于溢出

    public StaticLinkedList(){
        data = new Node[MAXSIZE];
        initList(data);
    }

    public StaticLinkedList(int maxsize){
        data = new Node[maxsize];
        initList(data);
    }

    /**
     * 初始化静态链表
     * 将一维数组data中的各分量链成一备用链表
     * @param data
     */
    private void initList(Node<T>[] data) {
        for(int i=0; i<data.length-1;i++){
            data[i] = new Node<T>(null, i+1);	//初始化每个节点的cur值，为其数组中下标加1，指向下一个元素
        }
        data[data.length-1] = new Node<T>(null, 0);	//数组最后一个元素的cur，用来存放第一个插入元素的下标，即第一个有值元素的下标
    }

    /**
     * 顺序添加元素
     * @param item 待添加的元素
     * @return
     */
    public boolean add(T item){
        int newCur = data[0].cur;	//第一个空闲空间的下标
        int temp = data[newCur].cur;	//保存第一个空闲空间的游标
        Node<T> newNode = new Node<T>(item, 0);	//新添加元素，由于是最后一个元素，其游标置0
        data[newCur] = newNode;
        if(data[0].cur>1){
            data[newCur-1].cur = newCur;	//如果静态链表不为空，应在添加时将前一元素的游标和新元素的下标联系起来
        }
        data[0].cur = temp;	//新的空闲空间，赋给第一个元素的游标
        data[data.length-1].cur = 1;	//最后一个元素的游标存放第一个有值元素的下标，为1
        return true;
    }

    /**
     * 静态链表的插入操作
     * @param item 待插入的元素
     * @param index 插入元素的位置
     * @return
     */
    public boolean insert(T item, int index){
        int ccur = data[data.length-1].cur;	//数组最后一个节点的游标
        for(int i=0;i<index-1;i++){	//遍历，获取index之前一元素
            ccur = data[ccur].cur;
        }
        int nextcur = data[ccur].cur;	//将前一元素的游标保存
        data[ccur].cur = data[0].cur;	//将新增加的元素的下标赋给前一元素的游标
        int newCur = data[0].cur;
        Node<T> newNode = new Node<T>(item, nextcur); //下标赋值，插入到两元素之间
        data[newCur] = newNode;	//增加新元素
        data[0].cur++;	//第一个元素的cur加1
        return true;
    }

    @Override
    public String toString() {
        String str = "[ ";
        int ccur = data[data.length-1].cur;
        while(data[ccur].value!=null) {
            str = str + data[ccur].value + " ";
            ccur = data[ccur].cur;
        }
        str = str + "]";
        return str;
    }


    public static void main(String[] var){
        ArrayList<Integer> al=new ArrayList<>();
    }

}
