package demo02_剑指offer;

/**
 * @author ajie
 * @date 2023/7/4
 * @description:
 */
public class code06_反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode nextHead = head.next;
            head.next = pre;
            pre = head;
            head = nextHead;
        }
        return pre;
    }
}
