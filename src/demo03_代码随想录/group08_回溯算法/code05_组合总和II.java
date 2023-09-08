package demo03_代码随想录.group08_回溯算法;

import java.util.*;

/**
 * @author ajie
 * @date 2023/8/9
 * @description: https://leetcode.cn/problems/combination-sum-ii/description/
 */
public class code05_组合总和II {
    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            // 剪枝 -- 去除重复元素带来的重复数据组合情况
            if (index > begin && candidates[index] == candidates[index - 1]) {
                continue;
            }
            path.addLast(candidates[index]);
            backTracking(candidates, target - candidates[index], index + 1);
            path.removeLast();
        }
    }
}
