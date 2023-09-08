package demo03_代码随想录.group10_动态规划;

/**
 * @author ajie
 * @date 2023/8/10
 * @description: https://leetcode.cn/problems/integer-break/
 */
public class code06_整数拆分 {
    public static void main(String[] args) {
        integerBreak(10);
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        // 2 拆分的乘积最大为 1
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                // 下一个数字可以拆分成上一个数字 + 1      ---> 添加 dp[i] 做比较
                // 下一个数字也可以拆分成 j 和 i - j 的和,i - j 不继续拆分  ---> j * (i - j)
                // 下一个数字也可以拆分成 j 和 i - j 的和,i - j 继续拆分  ---> j * dp(i - j)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
