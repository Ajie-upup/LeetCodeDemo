package demo04_test;

/**
 * @author ajie
 * @date 2023/7/17
 * @description: https://leetcode.cn/problems/add-strings/solutions/357938/zi-fu-chuan-xiang-jia-by-leetcode-solution/
 */
public class code01_字符串相加 {

    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int add = 0;
        StringBuilder res = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || add != 0) {
            int x = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int y = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int temp = x + y + add;
            res.append(temp % 10);
            add = temp / 10;
            len1--;
            len2--;
        }
        return res.reverse().toString();
    }
}
