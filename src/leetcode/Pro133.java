package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/6/22 22:34
 */
public class Pro133 {
    //思路：
    //    dfs遍历
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return dfs(node);
    }
    HashMap<Node, Node> map = new HashMap<>();

    private Node dfs(Node node) {
        if (!map.containsKey(node)) {
            Node copy = new Node(node.val, new ArrayList<Node>());
            map.put(node, copy);
            List<Node> list = node.neighbors;
            for (Node n : list) {
                copy.neighbors.add(dfs(n));
            }
        }
        return map.get(node);
    }
}
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};