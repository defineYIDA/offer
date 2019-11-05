package interview.携程;

import link.ListNode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: zl
 * @Date: 2019/9/4 18:26
 */
public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        if (head == null) {
            return null;
        }
        //构建两个临时链表
        ListNode dummy1 = new ListNode(-1);//小于等于m
        ListNode dummy2 = new ListNode(-1);//大于m
        ListNode pNode = head, d1 = dummy1, d2 = dummy2;
        while (pNode != null) {
            if (pNode.val < m) {
                d1.next = pNode;
                d1 = d1.next;
                //d1.next = null;
            } else {
                d2.next = pNode;
                d2 = d2.next;
                //d2.next = null;
            }
            pNode = pNode.next;
        }
        d1.next = null;
        d2.next = null;
        if (dummy1.next != null) {
            d1.next = dummy2.next;
            return dummy1.next;
        } else {
            return dummy2.next;
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        /*Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }*/
        //((ur)jjij(oi))
        System.out.println(resolve("((ur)jjij(oi))"));
    }
    //               ((ur)oi)
    static String resolve(String expr) {
        if (expr == null) {
            return "";
        }
        Stack<Character> stack = new Stack<>();//使用栈来匹配左右括号
        StringBuilder sbTarget = new StringBuilder();//用来存储最终的字符串
        StringBuilder sb = new StringBuilder();

        int len = expr.length();
        for (int i = 0; i < len; i++) {
            char c = expr.charAt(i);
            if (c == '(') {
                if (stack.empty()) {
                    sbTarget.append(sb);
                    sb = new StringBuilder();
                }
                stack.push(c);
            } else if (c == ')') {
                if (stack.pop() == '(') {
                    //翻转字符串
                    if (stack.empty()) { //栈空代表字符串已经翻转完成
                        sbTarget.append(sb.reverse());
                        sb = new StringBuilder();
                    } else {
                        if ((stack.size() & 1) == 1) {

                        } else {
                            sb = sb.reverse();
                        }
                    }
                } else {
                    //非法输入
                    throw new IllegalArgumentException();
                }
            } else {
                //为需要翻转的字符
                sb.append(c);
            }
        }
        return sbTarget.toString();
    }
    /**
     * 任务调度
     * 时间限制：C/C++语言 1000MS；其他语言 3000MS
     * 内存限制：C/C++语言 65536KB；其他语言 589824KB
     * 题目描述：
     * 在m个节点的分布式计算系统中，有一批任务需要执行，每个任务需要的时间是array[i]，每个节点同一时间只能执行一个任务，每个节点只能执行连续的任务，例如i,i+1,i+2,但是不能执行i,i+2。请问任务完成的最短时间
     *
     * 输入
     * 输入数据包含两行
     *
     * 第一行，空格分隔的两个整数m和n，分别表示节点个数和任务个数(m>0,n>=0)
     *
     * 第二行，空格分隔的正整数序列，表示每个任务需要的时间
     *
     * 输出
     * 一个整数，表示最短完成时间
     *
     *
     * 样例输入
     * 3 5
     * 1 5 3 4 2
     * 样例输出
     * 6
     *
     * 提示
     * 第一个节点执行：任务1和任务2，耗时=1+5=6
     * 第二个节点执行：任务3，耗时=3
     * 第三个节点执行：任务4和任务5，耗时=4+2=6
     * 所以，总最短耗时=6
     * https://www.nowcoder.com/discuss/245186?type=0&order=0&pos=6&page=1
     * https://www.nowcoder.com/discuss/245156?type=0&order=0&pos=18&page=1
     */

}
