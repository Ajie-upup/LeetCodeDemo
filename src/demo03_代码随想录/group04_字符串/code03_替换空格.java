package demo03_代码随想录.group04_字符串;

/**
 * @author ajie
 * @date 2023/8/1
 * @description: https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 */
public class code03_替换空格 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
