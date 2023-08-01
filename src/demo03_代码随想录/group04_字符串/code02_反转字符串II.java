package demo03_代码随想录.group04_字符串;

import java.util.Arrays;

/**
 * @author ajie
 * @date 2023/8/1
 * @description: https://leetcode.cn/problems/reverse-string-ii/
 */
public class code02_反转字符串II {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int len = s.length() - 1;
        int start = 0;
        while (start < len) {
            // 反转前 k 个字符，不足 k 个也反转
            int end = Math.min(len, start + k - 1);
            swap(charArray, start, end);
            start += 2 * k;
        }
        return new String(charArray);
    }

    private void swap(char[] charArray, int start, int end) {
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
}
