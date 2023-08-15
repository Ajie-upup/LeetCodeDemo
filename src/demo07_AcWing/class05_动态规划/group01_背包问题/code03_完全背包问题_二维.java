package demo07_AcWing.class05_动态规划.group01_背包问题;

import java.util.Scanner;

/**
 * @author ajie
 * @date 2023/8/14
 * @description:
 */
public class code03_完全背包问题_二维 {
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
        int[][] pack = new int[packCount + 1][totalVolume + 1];
        for (int i = 1; i <= packCount; i++) {
            // volume[i] 开始
            for (int j = volume[i]; j <= totalVolume; j++) {
                pack[i][j] = pack[i - 1][j];
                if (j - volume[i] >= 0){
                    // 注意 pack[i][j - volume[i]] 与 01背包问题不同的点
                    pack[i][j] = Math.max(pack[i][j], pack[i][j - volume[i]] + worth[i]);
                }
            }
        }
        System.out.println(pack[packCount][totalVolume]);
    }
}
