package demo07_AcWing.class05_动态规划.group01_背包问题;

import java.util.Scanner;

/**
 * @author ajie
 * @date 2023/8/15
 * @description:
 */
public class code05_多重背包问题I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int packCount = sc.nextInt();
        int totalVolume = sc.nextInt();
        // 体积
        int[] volume = new int[packCount + 1];
        // 价值
        int[] worth = new int[packCount + 1];
        // 物品数量
        int[] count = new int[packCount + 1];
        for (int i = 1; i <= packCount; i++) {
            volume[i] = sc.nextInt();
            worth[i] = sc.nextInt();
            count[i] = sc.nextInt();
        }

        int[] pack = new int[totalVolume + 1];

        for (int i = 1; i <= packCount; i++) {
            for (int j = totalVolume; j >= volume[i]; j--) {
                for (int k = 1; k <= count[i] && j >= k * volume[i]; k++) {
                    pack[j] = Math.max(pack[j] , pack[j - k * volume[i]] + k * worth[i]);
                }
            }
        }
        System.out.println(pack[totalVolume]);
    }
}
