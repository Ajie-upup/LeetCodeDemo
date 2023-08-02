package demo03_代码随想录.group06_栈和队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ajie
 * @date 2023/8/1
 * @description: https://leetcode.cn/problems/implement-queue-using-stacks/
 */
public class code01_用栈实现队列 {
    class MyQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;
        public MyQueue() {
            inStack = new LinkedList<>();
            outStack = new LinkedList<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            // 当出栈中有值时，直接弹出
            if (!outStack.isEmpty()) {
                return outStack.pop();
            }
            // 当出栈为空时，将入栈的数全部添加到出栈中
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }

        public int peek() {
            if (!outStack.isEmpty()) {
                return outStack.peek();
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }
}
