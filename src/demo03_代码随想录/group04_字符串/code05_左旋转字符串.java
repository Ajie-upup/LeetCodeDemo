package demo03_代码随想录.group04_字符串;

/**
 * @author ajie
 * @date 2023/8/1
 * @description: https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class code05_左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
