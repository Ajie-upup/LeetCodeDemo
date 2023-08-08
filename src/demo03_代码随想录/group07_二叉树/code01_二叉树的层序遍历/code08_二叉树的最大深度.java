package demo03_代码随想录.group07_二叉树.code01_二叉树的层序遍历;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ajie
 * @date 2023/8/8
 * @description: https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class code08_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return depth;
    }
}
