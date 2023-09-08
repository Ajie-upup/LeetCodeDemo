package demo03_代码随想录.group10_动态规划;

import java.util.Arrays;

/**
 * @author ajie
 * @date 2023/8/9
 * @description: https://leetcode.cn/problems/unique-paths/
 */
public class code04_不同路径 {
    public int uniquePaths(int row, int col) {
        int[] dp = new int[col];
        Arrays.fill(dp, 1);
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[col - 1];
    }
}
