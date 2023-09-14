package demo08_面试高频;

/**
 * @author ajie
 * @date 2023/9/11
 * @description:
 */
public class code04_最长回文子串 {

    /**
     * 中心值扩散法
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int start = 0, end = 0;
        for (int center = 0; center < s.length(); center++) {
            int len1 = arroundWithCenter(s, center, center);
            int len2 = arroundWithCenter(s, center, center + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = center - (maxLen - 1) / 2;
                end = center + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int arroundWithCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - 1) - (left + 1) + 1;
    }


    /**
     * 二维 DP
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 1;

        boolean[][] dp = new boolean[len][len];
        for (int right = 1; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if (right - left + 1 > maxLen) {
                        maxLen = right - left + 1;
                        maxStart = left;
                        maxEnd = right;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

}
