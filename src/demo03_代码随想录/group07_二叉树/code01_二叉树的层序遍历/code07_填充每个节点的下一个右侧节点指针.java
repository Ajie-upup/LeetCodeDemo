package demo03_代码随想录.group07_二叉树.code01_二叉树的层序遍历;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ajie
 * @date 2023/8/8
 * @description: https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 */
public class code07_填充每个节点的下一个右侧节点指针 {

    /**
     * 层序遍历（通用方法）
     */
    public Node2 connect(Node2 root) {
        Deque<Node2> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node2 node = queue.poll();
                if (size == 0) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }


    public Node2 connect2(Node2 root) {
        if (root == null) {
            return root;
        }
        // 定义每一层的最左侧节点
        Node2 leftmost = root;
        // 更新下一层的节点 next 指针
        while (leftmost.left != null) {
            Node2 head = leftmost;

            while (head != null) {
                // 更新下一层 next 指针左子树指向右子树
                head.left.next = head.right;

                if (head.next != null) {
                    // 更新不同子树的 next
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
