package demo07_AcWing.class05_动态规划.group01_背包问题;

import java.util.Scanner;

/**
 * @author ajie
 * @date 2023/8/15
 * @description:
 */
public class code04_完全背包问题_一维 {
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

        int[] pack = new int[totalVolume + 1];
        for (int i = 1; i <= packCount; i++) {
            for (int j = volume[i]; j <= totalVolume; j++) {
                pack[j] = Math.max(pack[j], pack[j - volume[i]] + worth[i]);
            }
        }
        System.out.println(pack[totalVolume]);
    }
}
