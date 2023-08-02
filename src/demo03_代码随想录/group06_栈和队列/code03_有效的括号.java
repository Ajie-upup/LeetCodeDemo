package demo03_代码随想录.group06_栈和队列;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ajie
 * @date 2023/8/1
 * @description: https://leetcode.cn/problems/valid-parentheses/
 */
public class code03_有效的括号 {
    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                deque.addLast(c);
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                if (c != map.get(deque.removeLast())) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
