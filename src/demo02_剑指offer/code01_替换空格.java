package demo02_剑指offer;

/**
 * @author ajie
 * @date 2023/6/15
 * @description:
 */
public class code01_替换空格 {

    public String replaceSpace(String s) {

        return s.replace(" ", "%20");
    }

    public String replaceSpace2(String s) {
        StringBuilder sBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sBuilder.append("%20");
            } else {
                sBuilder.append(c);
            }
        }
        return sBuilder.toString();
    }
}
