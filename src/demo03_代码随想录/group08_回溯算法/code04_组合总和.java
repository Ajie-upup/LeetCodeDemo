package demo03_代码随想录.group08_回溯算法;

import java.util.*;

/**
 * @author ajie
 * @date 2023/8/9
 * @description: https://leetcode.cn/problems/combination-sum/
 */
public class code04_组合总和 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, target, 0);
        return res;
    }

    private void backTracking(int[] candidates, int target, int begin) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int index = begin; index < candidates.length; index++) {
            path.offer(candidates[index]);
            backTracking(candidates, target - candidates[index], index);
            // 回溯
            path.removeLast();
        }
    }

}
