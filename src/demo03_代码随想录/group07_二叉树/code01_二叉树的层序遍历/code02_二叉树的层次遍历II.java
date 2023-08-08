package demo03_代码随想录.group07_二叉树.code01_二叉树的层序遍历;

import java.util.*;

/**
 * @author ajie
 * @date 2023/8/3
 * @description: https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 */
public class code02_二叉树的层次遍历II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.offer(root);
        while (!nodeDeque.isEmpty()) {
            int size = nodeDeque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeDeque.poll();
                list.add(node.val);
                if (node.left != null) {
                    nodeDeque.offer(node.left);
                }
                if (node.right != null) {
                    nodeDeque.offer(node.right);
                }
            }
            res.add(0, list);
        }
        return res;
    }
}
