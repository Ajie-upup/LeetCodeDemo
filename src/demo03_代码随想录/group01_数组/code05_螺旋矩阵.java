package demo03_代码随想录.group01_数组;

/**
 * @author ajie
 * @date 2023/7/31
 * @description: https://leetcode.cn/problems/spiral-matrix-ii/
 */
public class code05_螺旋矩阵 {
    public static void main(String[] args) {
        generateMatrix(3);
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 定义循环次数
        int loop = 1;
        // 定义填充数
        int count = 1;
        // 定义循环开始的坐标 (start,start)
        int start = 0;
        // 定义下标
        int i, j;
        while (loop <= (n / 2)) {
            // 向右 不取最后一位
            // 注意元素遍历开始的坐标是变化的，需要根据 start 动态变化
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }
            // 向下
            for (i = start; i < n - loop; i++) {
                // 注意 j
                res[i][j] = count++;
            }
            // 向左 不取最后一位
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }
            // 向上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            loop++;
            start++;
        }

        if (n % 2 != 0) {
            res[start][start] = count;
        }
        return res;
    }

}
