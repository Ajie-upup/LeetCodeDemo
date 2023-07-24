package demo02_剑指offer;

/**
 * @author ajie
 * @date 2023/6/19
 * @description:
 */
public class code02_左旋转字符串 {

    /**
     * 方法一：string 类的 subString 方法
     * 方法二：通过索引进行字符串的拼接
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
