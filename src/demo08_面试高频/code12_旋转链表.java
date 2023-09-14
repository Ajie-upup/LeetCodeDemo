package demo08_面试高频;

/**
 * @author ajie
 * @date 2023/9/13
 * @description:
 */
public class code12_旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        int len = 1;
        while (current.next != null) {
            len++;
            current = current.next;
        }
        int add = len - k % len;
        if (add == len) {
            return head;
        }
        current.next = head;
        while (add-- > 0) {
            current = current.next;
        }
        ListNode newHead = current.next;
        current.next = null;
        return newHead;
    }
}
