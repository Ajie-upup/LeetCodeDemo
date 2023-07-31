package demo03_代码随想录.group03_哈希表;

/**
 * @author ajie
 * @date 2023/7/31
 * @description: https://leetcode.cn/problems/ransom-note/
 */
public class code06_赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] charArray = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            charArray[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if ((--charArray[ransomNote.charAt(i) - 'a']) < 0) {
                return false;
            }
        }
        return true;
    }
}
