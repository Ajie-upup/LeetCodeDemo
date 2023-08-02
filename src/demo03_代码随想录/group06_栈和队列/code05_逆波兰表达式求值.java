package demo03_代码随想录.group06_栈和队列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ajie
 * @date 2023/8/1
 * @description: https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */
public class code05_逆波兰表达式求值 {

    public int evalRPN(String[] tokens) {
        ArrayList<String> list = new ArrayList<>();
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (list.contains(token)) {
                // 传入的字符串为符号时，计算栈顶两个数字的运算结果，加入栈中
                int value = calculateValue(stack.pop(), stack.pop(), token);
                stack.push(value);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }


    private int calculateValue(int num1, int num2, String token) {
        if (token.equals("+")) {
            return num1 + num2;
        }
        if (token.equals("-")) {
            return num2 - num1;
        }
        if (token.equals("*")) {
            return num2 * num1;
        }
        if (token.equals("/")) {
            return num2 / num1;
        }
        return 0;
    }
}
