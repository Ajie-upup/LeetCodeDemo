package demo03_代码随想录.group08_回溯算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ajie
 * @date 2023/8/8
 * @description: https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
public class code03_电话号码的字母组合 {
    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        int len = digits.length();
        StringBuilder path = new StringBuilder();
        backTracking(digits, len, 0, path);
        return res;
    }

    private void backTracking(String digits, int len, int cur, StringBuilder path) {
        if (cur == len) {
            res.add(path.toString());
            return;
        }
        char num = digits.charAt(cur);
        String string = map.get(num);
        for (int i = 0; i < string.length(); i++) {
            path.append(string.charAt(i));
            backTracking(digits, len, cur + 1, path);
            // 回溯 -- 删除拼接的元素
            path.deleteCharAt(cur);
        }
    }

}
