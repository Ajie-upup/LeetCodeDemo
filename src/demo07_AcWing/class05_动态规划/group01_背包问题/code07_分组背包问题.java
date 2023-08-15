package demo07_AcWing.class05_动态规划.group01_背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ajie
 * @date 2023/8/15
 * @description:
 */
public class code07_分组背包问题 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int groupCount = Integer.parseInt(split[0]);
        int totalVolume = Integer.parseInt(split[1]);
        int[] pack = new int[totalVolume + 1];
        int[] volume = new int[105];
        int[] worth = new int[105];

        for (int i = 1; i <= groupCount; i++) {
            String[] s = br.readLine().split(" ");
            int group = Integer.parseInt(s[0]);  //输入几组数据
            for (int j = 0; j < group; j++) {
                String[] ss = br.readLine().split(" ");
                volume[j] = Integer.parseInt(ss[0]);
                worth[j] = Integer.parseInt(ss[1]);
            }
            //从V开始往前遍历 有限个数
            for (int j = totalVolume; j >= 0; j--) {
                for (int k = 0; k < group; k++) { //遍历每一个组
                    if (j >= volume[k]) {
                        pack[j] = Math.max(pack[j], pack[j - volume[k]] + worth[k]);
                    }
                }
            }
        }
        System.out.println(pack[totalVolume]);
    }
}
