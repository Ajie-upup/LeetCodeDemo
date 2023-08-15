package demo07_AcWing.class05_动态规划.group01_背包问题;

import java.util.Scanner;

/**
 * @author ajie
 * @date 2023/8/10
 * @description:
 */
public class code01_01背包问题_二维 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int packCount = sc.nextInt();
        int totalVolume = sc.nextInt();
        // 体积
        int[] volume = new int[packCount + 1];
        // 价值
        int[] worth = new int[packCount + 1];
        for (int i = 1; i <= packCount; i++) {
            volume[i] = sc.nextInt();
            worth[i] = sc.nextInt();
        }
        // 竖轴表示当前放不放第 i 个物品
        // 横轴表示当前最大体积数
        int[][] pack = new int[packCount + 1][totalVolume + 1];
        for (int i = 1; i <= packCount; i++) {
            // i 表示存放物品
            for (int j = 1; j <= totalVolume; j++) {
                if (j < volume[i]) {
                    // 当前背包容量装不进第i个物品，则价值等于前i-1个物品
                    pack[i][j] = pack[i - 1][j];
                } else {
                    // 能装，需进行决策是否选择第i个物品
                    pack[i][j] = Math.max(pack[i - 1][j], pack[i - 1][j - volume[i]] + worth[i]);
                }
            }
        }
        System.out.println(pack[packCount][totalVolume]);
    }

}
