package demo03_代码随想录.group07_二叉树.code01_二叉树的层序遍历;

/**
 * @author ajie
 * @date 2023/8/8
 * @description: https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 */
public class code09_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
