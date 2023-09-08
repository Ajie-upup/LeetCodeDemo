package demo03_代码随想录.group10_动态规划;

/**
 * @author ajie
 * @date 2023/8/9
 * @description: https://leetcode.cn/problems/unique-paths-ii/
 */
public class code05_不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col = obstacleGrid[0].length;
        int[] dp = new int[col];
        // 将第一步置为初始位置
        dp[0] = 1;
        for (int[] cols : obstacleGrid) {
            for (int i = 0; i < cols.length; i++) {
                if (cols[i] == 1) {
                    dp[i] = 0;
                } else if (i > 0) {
                    dp[i] = dp[i] + dp[i - 1];
                }
            }
        }
        // 最后位置在终点位置前一格
        return dp[col - 1];
    }
}
