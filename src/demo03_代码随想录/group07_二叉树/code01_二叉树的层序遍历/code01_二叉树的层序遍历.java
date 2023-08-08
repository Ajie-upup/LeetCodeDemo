package demo03_代码随想录.group07_二叉树.code01_二叉树的层序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ajie
 * @date 2023/8/2
 * @description: https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */
public class code01_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.add(root);
        while (!nodeDeque.isEmpty()) {
            int size = nodeDeque.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = nodeDeque.poll();
                list.add(node.val);
                if (node.left != null) {
                    nodeDeque.offer(node.left);
                }
                if (node.right != null) {
                    nodeDeque.offer(node.right);
                }
                --size;
            }
            res.add(list);
        }
        return res;
    }

}
