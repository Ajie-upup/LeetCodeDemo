package demo03_代码随想录.group07_二叉树.code01_二叉树的层序遍历;

import javafx.util.Pair;

import java.util.*;

/**
 * @author ajie
 * @date 2023/8/7
 * @description: https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
 */
public class code05_N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        if (root != null) {
            // root 校验
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                Node node = queue.poll();
                list.add(node.val);
                if (node.children != null) {
                    for (Node childrenNode : node.children) {
                        queue.offer(childrenNode);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
