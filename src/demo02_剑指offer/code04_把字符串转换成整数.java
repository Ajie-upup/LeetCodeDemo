package demo02_剑指offer;

/**
 * @author ajie
 * @date 2023/7/4
 * @description:
 */
public class code04_把字符串转换成整数 {

    public static void main(String[] args) {
        System.out.println(strToInt("words and 987"));
    }

    public static int strToInt(String str) {
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        str = str.trim();
        for (int i = 0; i < str.length(); i++) {
            if (i==0 && str.charAt(i) == '-') {
                flag = false;
                continue;
            }
            if (isInt(str.charAt(i))) {
                sb.append(str.charAt(i));
            } else {
                break;
            }
        }
        if (Long.parseLong(sb.toString()) > Integer.MAX_VALUE) {
            return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (!flag && Long.parseLong(sb.toString()) == Integer.MAX_VALUE) {
            return Integer.MIN_VALUE;
        }
        int res = Integer.parseInt(sb.toString());
        return flag ? res : res * -1;
    }

    public static boolean isInt(char c) {
        int res = Integer.parseInt(c + "");
        return res >= 0 && res <= 9;
    }
}
