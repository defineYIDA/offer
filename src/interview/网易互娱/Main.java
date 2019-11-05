package interview.网易互娱;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/9/7 18:48
 */
public class Main {
    final TreeNode node = new TreeNode(1);
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int size = Integer.valueOf(sc.nextLine());
        int[] in = new int[size];
        for (int i = 0; i < size; i++) {
            in[i] = Integer.valueOf(sc.nextLine());
        }
        pro1(size, in);*/
        //----------------------------------------------
/*        Scanner sc = new Scanner(System.in);
        //树的颗树
        int size = Integer.valueOf(sc.nextLine());
        int[] in = new int[size];
        for (int i = 0; i < size; i++) {
            //每一颗树的节点个数
            int nodeCount = Integer.valueOf(sc.nextLine());
            int[][] tree = new int[nodeCount][3];
            for (int j = 0; j < nodeCount; j++) {
                String s = sc.nextLine();
                String[] arr = s.split(" ");
                tree[j][0] = Integer.valueOf(arr[0]);//val
                tree[j][1] = Integer.valueOf(arr[1]);//left
                tree[j][2] = Integer.valueOf(arr[2]);//right
            }
            pro2(nodeCount, tree);
        }*/
        //----------------------------------------------------

        Scanner sc = new Scanner(System.in);
        //测试用例个数
        int size = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < size; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            int len = Integer.valueOf(arr[0]);//间隔天数
            if (len < 0) {
                len = 0;
            }
            int count = Integer.valueOf(arr[1]);//固定天数
            String d = sc.nextLine();
            String[] day = d.split(" ");
            int[] days = new int[count];//固定的天
            for (int j = 0; j < count; j++) {
                days[j] = Integer.valueOf(day[j]);
            }
            pro3(len, count, days);
        }
    }
    //3
    private static void pro3(int len, int count, int[] days) {
        if (len > 30) {
            System.out.println(0);
            return;
        }
        //用数组来做hash
        //int[] check = new int[31];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            //check[days[i]]++;
            set.add(days[i]);
        }
        int res = 0;
        int cur = 1;
        int k = 0;
        for (; cur <= 30; cur += (len + 1)) {
            if (!set.contains(cur)) {
                res++;
                k = len;
            } else if (k == 0) {
                k = len;
                res++;
            } else k--;
        }
        System.out.println(res);
    }
    //4
    //1

    private static void pro1(int s, int[] in) {
        if (s < 1) {
            return;
        }
        for (int i = 0; i < s; i++) {
            int l = Integer.MIN_VALUE;
            int r = 1;
            int cur = in[i];
            int c = 0;
            //找到右到左第一个不为0的位置
            while ((l & cur) == 0) {
                l >>>= 1;
                c++;
            }
            while (l > r && (((l & cur) == 0 &&(r & cur) == 0) || ((l & cur) != 0 && (r & cur) != 0))) {
                 l >>>= 1;
                r <<= 1;
            }
            if (l == r || r > l) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    //2
    private static void pro2(int size, int[][] tree) {
        //构建二叉树
        TreeNode root = bulidTree(size, tree);
        //层序遍历，计数值
        judge(root);
    }
    private static void judge(TreeNode root) {
        if (root == null) {
            System.out.println("NO");
            return;
        }
        int min = Integer.MIN_VALUE;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (node != null) {
                    count += node.val;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            //上一层的和小于下一层和
            if (count > min) {
                min = count;
            } else {
                System.out.println("NO");
                return;
            }
            count = 0;
        }
        System.out.println("YES");
    }
    private static TreeNode bulidTree(int size, int[][] tree) {
        int[] check = new int[size];
        for (int i = 0; i < size; i++) {
            if (tree[i][1] != -1) {
                check[tree[i][1]]++;
            }
            if (tree[i][2] != -1) {
                check[tree[i][2]]++;
            }
        }
        int index = -1;//根节点的位置
        for (int i = 0; i < size; i++) {
            //根节点，不会作为左右节点
            if (check[i] == 0) {
                index = i;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException();
        }
        //构建根节点
        return bulidTreeCore(tree, new TreeNode(tree[index][0]), tree[index]);
    }
    private static TreeNode bulidTreeCore(int[][] tree, TreeNode root, int[] data) {
        //左结点不为null
        if (data[1] != -1) {
            int[] leftData = tree[data[1]];
            root.left = bulidTreeCore(tree, new TreeNode(leftData[0]), leftData);
        }
        if (data[2] != -1) {
            int[] rightData = tree[data[2]];
            root.right = bulidTreeCore(tree, new TreeNode(rightData[0]), rightData);
        }
        return root;
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
