package demo03_代码随想录.group02_链表篇;

/**
 * @author ajie
 * @date 2023/7/31
 * @description: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class code05_删除链表的倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        // 定义方法返回链表的长度
        int len = getListLen(head);
        // 获取需要删除节点的前一个节点
        ListNode pre = dummy;
        for (int i = 0; i < len - n; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    /**
     * 获取传入链表的长度
     */
    private int getListLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
