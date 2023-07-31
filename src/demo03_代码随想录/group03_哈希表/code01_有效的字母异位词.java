package demo03_代码随想录.group03_哈希表;

/**
 * @author ajie
 * @date 2023/7/31
 * @description: https://leetcode.cn/problems/valid-anagram/
 */
public class code01_有效的字母异位词 {
    public boolean isAnagram(String str1, String str2) {
        // 长度判断
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] charArray = new char[26];
        for (int i = 0; i < str1.length(); i++) {
            // 统计两个字符串中的字符出现的次数
            charArray[str1.charAt(i) - 'a']++;
            charArray[str2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
