package demo08_面试高频;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ajie
 * @date 2023/9/11
 * @description:
 */
public class code05_有效括号 {
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
