package demo07_AcWing.class05_动态规划.group01_背包问题;

import java.util.Scanner;

/**
 * @author ajie
 * @date 2023/8/14
 * @description:
 */
public class code02_01背包问题_一维 {
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
            for (int j = totalVolume; j >= volume[i]; j--) {
                // j 表示当前体积大小
                // i 表示当前是否放第 i 个物品
                pack[j] = Math.max(pack[j], pack[j - volume[i]] + worth[i]);
            }
        }
        System.out.println(pack[totalVolume]);
    }
}
