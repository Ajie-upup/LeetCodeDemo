package demo03_代码随想录.group04_字符串;

/**
 * @author ajie
 * @date 2023/8/1
 * @description: https://leetcode.cn/problems/repeated-substring-pattern/
 */
public class code07_重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        return kmp(s);
    }

    private boolean kmp(String s) {
        if (s.equals("")) {
            return false;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] next = new int[len];
        // next[0] = 0;
        for (int i = 1, j = 0; i < len; i++) {
            while (j > 0 && chars[i] != chars[j]) {
                j = next[j - 1];
            }
            if (chars[i] == chars[j]) {
                j++;
            }
            next[i] = j;
        }
        return next[len - 1] > 0 && len % (len - next[len - 1]) == 0;
    }
}
