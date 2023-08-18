package demo07_AcWing.class05_动态规划.group02_线性DP;

import java.util.Scanner;

/**
 * @author ajie
 * @date 2023/8/15
 * @description:
 */
public class code01_数字三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n + 1][n + 1];
        // 三角形读取模板
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                nums[i][j] = sc.nextInt();

            }
        }
        // 从下往上迭代
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                // 左下角数字 与 右下角数字取最大值
                nums[i][j] = Math.max(nums[i + 1][j], nums[i + 1][j + 1]) + nums[i][j];
            }
        }
        System.out.println(nums[0][0]);
    }
}
