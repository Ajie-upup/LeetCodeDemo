package demo03_代码随想录.group02_链表篇;

/**
 * @author ajie
 * @date 2023/7/31
 * @description: https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/submissions/
 */
public class code06_链表相交 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLen(headA);
        int lenB = getListLen(headB);

        ListNode curA = headA;
        ListNode curB = headB;
        // 确认 lenA 始终为两个链表中长度最长的链表
        if (lenB > lenA) {
            // 长度交换
            int temp = lenA;
            lenA = lenB;
            lenB = temp;

            // 节点交换
            curA = headB;
            curB = headA;
        }

        // 将较长的节点遍历两个链表长度的差值
        for (int i = 0; i < lenA - lenB; i++) {
            curA = curA.next;
        }
        // 同步遍历两个节点，相遇就返回，没有相遇返回 null
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
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
