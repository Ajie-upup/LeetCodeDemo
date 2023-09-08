package demo03_代码随想录.group10_动态规划;

/**
 * @author ajie
 * @date 2023/8/10
 * @description: https://leetcode.cn/problems/unique-binary-search-trees/
 */
public class code07_不同的二叉搜索树 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // i 表示当前使用节点个数
            for (int j = 1; j <= i; j++) {
                // 以 j 为首节点的二叉树的个数
                // j - 1 表示左边子节点的个数
                // i - j 表示右边子节点的个数
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
