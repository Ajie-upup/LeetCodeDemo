package demo03_代码随想录.group07_二叉树.code01_二叉树的层序遍历;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ajie
 * @date 2023/8/7
 * @description: https://leetcode.cn/problems/binary-tree-right-side-view/
 */
public class code03_二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.offer(root);
        while (!nodeDeque.isEmpty()) {
            int size = nodeDeque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeDeque.poll();
                list.add(0, node.val);
                if (node.left != null) {
                    nodeDeque.offer(node.left);
                }
                if (node.right != null) {
                    nodeDeque.offer(node.right);
                }
            }
            res.add(list.get(0));
        }
        return res;
    }
}
