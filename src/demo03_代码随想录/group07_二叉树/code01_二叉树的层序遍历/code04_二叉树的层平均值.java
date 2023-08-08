package demo03_代码随想录.group07_二叉树.code01_二叉树的层序遍历;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ajie
 * @date 2023/8/7
 * @description: https://leetcode.cn/problems/average-of-levels-in-binary-tree/
 */
public class code04_二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.offer(root);
        while (!nodeDeque.isEmpty()) {
            int size = nodeDeque.size();
            double levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeDeque.poll();
                levelSum += node.val;
                if (node.left != null) {
                    nodeDeque.offer(node.left);
                }
                if (node.right != null) {
                    nodeDeque.offer(node.right);
                }
            }
            res.add(levelSum / size);
        }
        return res;
    }
}
