package demo05_top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ajie
 * @date 2023/7/25
 * @description:
 */
public class code03_无重复字符的最长子串 {

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // 遇到重复字符
            if (window.containsKey(s.charAt(i))) {
                // 删除首节点，加入末尾节点
                left = Math.max(window.get(s.charAt(i)) + 1, left);
            }
            window.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


    public int lengthOfLongestSubstring2(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;

        // 用来保存每一个字符上一次出现的位置
        int[] prevIdxes = new int[128];
        Arrays.fill(prevIdxes, -1);
        prevIdxes[chars[0]] = 0;
        // 以i - 1位置字符结尾的最长不重复字符串的开始索引（最左索引）
        int li = 0;
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            // i位置字符上一次出现的位置
            int pi = prevIdxes[chars[i]];
            if (li <= pi) {
                li = pi + 1;
            }
            // 存储这个字符出现的位置
            prevIdxes[chars[i]] = i;
            // 求出最长不重复子串的长度
            max = Math.max(max, i - li + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring3(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;

        // 用来保存每一个字符上一次出现的位置
        Map<Character, Integer> prevIdxes = new HashMap<>();
        prevIdxes.put(chars[0], 0);
        // 以i - 1位置字符结尾的最长不重复字符串的开始索引（最左索引）
        int li = 0;
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            // i位置字符上一次出现的位置
            Integer pi = prevIdxes.get(chars[i]);
            if (pi != null && li <= pi) {
                li = pi + 1;
            }
            // 存储这个字符出现的位置
            prevIdxes.put(chars[i], i);
            // 求出最长不重复子串的长度
            max = Math.max(max, i - li + 1);
        }
        return max;
    }
}
