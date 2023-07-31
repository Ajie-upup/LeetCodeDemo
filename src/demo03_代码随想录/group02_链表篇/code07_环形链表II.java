package demo03_代码随想录.group02_链表篇;

/**
 * @author ajie
 * @date 2023/7/31
 * @description: https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class code07_环形链表II {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                // 第一次相遇之后，证明有环
                slow = head;
                // 将其中一个节点置于首节点，同步遍历，再一次相遇即为第一个入环节点
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}
