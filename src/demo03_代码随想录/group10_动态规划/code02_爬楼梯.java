package demo03_代码随想录.group10_动态规划;

/**
 * @author ajie
 * @date 2023/8/9
 * @description: https://leetcode.cn/problems/climbing-stairs/
 */
public class code02_爬楼梯 {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
