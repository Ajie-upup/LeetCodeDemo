package demo03_代码随想录.group04_字符串;

/**
 * @author ajie
 * @date 2023/8/1
 * @description: https://leetcode.cn/problems/reverse-words-in-a-string/description/
 */
public class code04_反转字符串中的单词 {
    /**
     * 先翻转整个字符串，再挨个翻转每个单词
     */
    public String reverseWords(String s) {
        // 去除首尾空格后翻转后的字符串
        StringBuilder sb = trimSpace(s);
        // 翻转整个字符串
        reverseStringBuilder(sb, 0, sb.length() - 1);
        // 翻转单个字符串
        int start = 0, end = 0;
        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            reverseStringBuilder(sb, start, end - 1);
            start = end + 1;
            end++;
        }
        return sb.toString();
    }

    /**
     * 获取去除首尾空格，以及字符串中间空格的字符串
     */
    private StringBuilder trimSpace(String s) {
        int left = 0, right = s.length() - 1;
        // 去除首尾空格
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (right >= left && s.charAt(right) == ' ') {
            right--;
        }
        // 去除字符串中间的空格
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                // 只拼接第一个字符空格
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    /**
     * 翻转 StringBuilder
     */
    private void reverseStringBuilder(StringBuilder sb, int start, int end) {
        while (start < end) {
            char c = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, c);
        }
    }
}
