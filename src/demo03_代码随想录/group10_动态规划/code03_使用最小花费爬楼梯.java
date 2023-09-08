package demo03_代码随想录.group10_动态规划;

/**
 * @author ajie
 * @date 2023/8/9
 * @description: https://leetcode.cn/problems/min-cost-climbing-stairs/
 */
public class code03_使用最小花费爬楼梯 {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1) {
            return 0;
        }
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
