package interview.小米;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/9/6 18:50
 */
public class Main {
    public static void main(String[] args) {
        //使用1-9字符表示，可以重复使用
        //bulidTree("1(2(3,4(,5)),6(7,))");
        //System.out.println(solution("1(2(3,4(,5)),6(7,))"));
        //int[] in = {500, 1};
        //System.out.println(solution(in, 1000));
        System.out.println(Integer.toString(-10, 10));
        System.out.println(test(-10, 10));
    }
    static String test(int m, int n) {
        //判断最大进/小制
        if (n > 36 || n < 2 || n == 10) {
            return m + "";
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;//正数
        if (m < 0) {
            flag = false;//负数
            m = -m;
        }
        while (m > 0) {
            int tmp = m % n;
            if (tmp > 9) {
                sb.append((char)((tmp - 10) + 'A'));
            } else {
                sb.append(tmp);
            }
            m /= n;
        }
        if (!flag) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    static String solution(String in) {
        //处理先序遍历的字符串，到队列,需要把空节点也表示出来
        if ("".equals(in)) {
            return null;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (c >= '0' && c <= '9') {
                queue.add(c - '0');
                if (in.charAt(i + 1) != '(') {
                    queue.add(null);
                    queue.add(null);
                }
            } else if (c == '(' && i < in.length() - 1 && in.charAt(i + 1) == ',') {
                queue.add(null);
            } else if (c == ')' && i > 0 && in.charAt(i - 1) == ',') {
                queue.add(null);
            }
        }
        TreeNode root = core(queue);
        StringBuilder sb = new StringBuilder();
        mid(root, sb);
        return sb.toString();
    }
    private static TreeNode core(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        Integer c = queue.poll();
        if (c == null) {
            return null;
        }
        TreeNode root = new TreeNode(c);
        root.left = core(queue);
        root.right = core(queue);
        return root;
    }
    private static void mid(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        mid(root.left, sb);
        sb.append(root.val);
        mid(root.right, sb);
    }

    static String solution(TreeNode node) {
        //中序遍历
        if (node == null) {
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        return "";
    }
    //构建树
    static TreeNode bulidTree(String input) {
        //
        return bulidTreeCore(input, 0, input.length() - 1);
    }
    static TreeNode bulidTreeCore(String in, int l, int r) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode((int)in.charAt(l));
/*        l++;
        if (l > r || in.charAt(r) != ')' || in.charAt(l) != ')') {
            return null;
        }
        l++;
        r--;
        //找到左右节点分割的index(逗号的位置)

        if (l != ',') {

            root.left = bulidTreeCore(in, l,);
        }
        if (r != ',') {

            root.right = bulidTreeCore(in, );
        }*/
        return root;
    }
    static int findIndex() {
        return 1;
    }
    /**
     * 树节点
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    static int solution(int[] prices, int budget) {
        if (prices.length == 0) {
            return 0;
        }
        //最贵的买起
        Arrays.sort(prices);
        int count = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (budget >= prices[i]) {
                count += budget / prices[i];
                budget = budget % prices[i];
            }
        }
        return count;
    }
    //https://www.nowcoder.com/discuss/247902?type=0&order=0&pos=30&page=1
    //https://github.com/hhfgeg/myCodes/blob/master/codes/printMidTree.cpp
}
