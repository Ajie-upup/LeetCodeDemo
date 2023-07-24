package demo02_剑指offer;

/**
 * @author ajie
 * @date 2023/7/4
 * @description:
 */
public class code07_复杂链表的复制 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node pre = new Node(0);
        Node copyNode = pre;
        while (head != null) {
            Node cursor = new Node(head.val);
            cursor.next = head.next;
            cursor.random = head.random;
            copyNode.next = cursor;
            copyNode = copyNode.next;
            head = head.next;
        }
        return pre.next;
    }
}
