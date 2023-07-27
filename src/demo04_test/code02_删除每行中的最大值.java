package demo04_test;

import java.util.Arrays;
import java.util.List;

/**
 * @author ajie
 * @date 2023/7/27
 * @description: https://leetcode.cn/problems/delete-greatest-value-in-each-row/
 */
public class code02_删除每行中的最大值 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 4}, {3, 3, 1}};
        deleteGreatestValue(grid);
    }

    public static int deleteGreatestValue(int[][] grid) {
        // 每一列的最大值之和
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, grid[j][i]);
            }
            res += max;
        }
        return res;
    }

}
