package demo08_面试高频;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ajie
 * @date 2023/9/12
 * @description:
 */
public class code11_组合 {
    private List<List<Integer>> res = new ArrayList<>();

    private List<Integer> paths = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return res;
    }

    private void combineHelper(int n, int k, int cur) {
        // 剪枝：如果当前 paths 中的元素个数 + 剩余元素个数 不足 k
        if (paths.size() + (n - cur + 1) < k) {
            return;
        }
        // 递归终止条件
        if (paths.size() == k) {
            res.add(new ArrayList<>(paths));
            return;
        }
        // 1. 将当前元素加入到集合中
        paths.add(cur);
        combineHelper(n, k, cur + 1);

        // 2. 不将当前元素加入到集合中
        paths.remove(paths.size() - 1);
        combineHelper(n, k, cur + 1);
    }
}
