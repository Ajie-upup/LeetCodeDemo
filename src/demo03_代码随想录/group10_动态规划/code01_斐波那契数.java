package demo03_代码随想录.group10_动态规划;

/**
 * @author ajie
 * @date 2023/8/9
 * @description: https://leetcode.cn/problems/fibonacci-number/
 */
public class code01_斐波那契数 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
