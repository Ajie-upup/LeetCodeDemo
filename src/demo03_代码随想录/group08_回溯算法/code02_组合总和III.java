package demo03_代码随想录.group08_回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ajie
 * @date 2023/8/8
 * @description: https://leetcode.cn/problems/combination-sum-iii/
 */
public class code02_组合总和III {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1, 0);
        return res;
    }

    private void backTracking(int k, int target, int cur, int sum) {
        if (path.size() == k) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        // 剪枝
        if (sum > target || cur > 9 || path.size() > k) {
            return;
        }
        path.add(cur);
        sum += cur;
        backTracking(k, target, cur + 1, sum);
        // 回溯
        path.remove(path.size() - 1);
        sum -= cur;
        backTracking(k, target, cur + 1, sum);
    }

}
