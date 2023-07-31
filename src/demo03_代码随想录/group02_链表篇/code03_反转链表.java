package demo03_代码随想录.group02_链表篇;

/**
 * @author ajie
 * @date 2023/7/31
 * @description: https://leetcode.cn/problems/reverse-linked-list/
 */
public class code03_反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            // 记录下一个头节点的位置
            ListNode nextHead = head.next;
            head.next = pre;
            pre = head;
            head = nextHead;
        }
        return pre;
    }
}
