package demo03_代码随想录.group06_栈和队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ajie
 * @date 2023/8/1
 * @description: https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 */
public class code04_删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当栈中为空时，直接将字符加入栈中
            if (deque.isEmpty()) {
                deque.addLast(c);
                continue;
            }
            // 当栈顶元素与入栈元素相同时，将栈顶元素弹出
            if (c == deque.getLast()) {
                deque.removeLast();
            } else {
                deque.addLast(c);
            }
        }
        // 拼接栈中的字符
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
