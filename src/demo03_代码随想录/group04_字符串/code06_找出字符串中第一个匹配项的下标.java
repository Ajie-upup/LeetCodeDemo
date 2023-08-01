package demo03_代码随想录.group04_字符串;

/**
 * @author ajie
 * @date 2023/8/1
 * @description: https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class code06_找出字符串中第一个匹配项的下标 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int n = haystack.length();
        int m = needle.length();
        int[] next = new int[m + 1];

        char[] chars1 = (" " + haystack).toCharArray();
        char[] chars2 = (" " + needle).toCharArray();

        // 获取 next 数组
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && chars2[i] != chars2[j + 1]) j = next[j];
            if (chars2[i] == chars2[j + 1]) j++;
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && chars1[i] != chars2[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (chars1[i] == chars2[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }
        return -1;
    }
}
