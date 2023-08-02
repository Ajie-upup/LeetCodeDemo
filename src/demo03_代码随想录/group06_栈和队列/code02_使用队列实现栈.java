package demo03_代码随想录.group06_栈和队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ajie
 * @date 2023/8/1
 * @description: https://leetcode.cn/problems/implement-stack-using-queues/
 */
public class code02_使用队列实现栈 {
    class MyStack {
        Deque<Integer> deque;

        public MyStack() {
            deque = new LinkedList<>();
        }

        public void push(int x) {
            deque.addLast(x);
        }

        public int pop() {
            return deque.removeLast();
        }

        public int top() {
            return deque.getLast();
        }

        public boolean empty() {
            return deque.isEmpty();
        }
    }
}
