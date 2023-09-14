package demo08_面试高频;

/**
 * @author ajie
 * @date 2023/9/11
 * @description:
 */
public class code09_最长公共前缀 {


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        int len = str.length();
        int count = strs.length;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            for (int j = 1; j < count; j++) {
                // 1. 长度到头结束  2. 找到第一个不匹配的字符
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return str.substring(0, i);
                }
            }
        }
        return str;
    }
}
