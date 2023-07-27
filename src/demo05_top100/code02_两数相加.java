package demo05_top100;

/**
 * @author ajie
 * @date 2023/7/24
 * @description:
 */
public class code02_两数相加 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode resultList = new ListNode();
        ListNode tempNode = resultList;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            sum += carry;
            carry = sum / 10;
            sum = sum % 10;
            tempNode.next = new ListNode(sum);
            tempNode = tempNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val;
            sum += carry;
            carry = sum / 10;
            sum = sum % 10;
            tempNode.next = new ListNode(sum);
            tempNode = tempNode.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val;
            sum += carry;
            carry = sum / 10;
            sum = sum % 10;
            tempNode.next = new ListNode(sum);
            tempNode = tempNode.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            tempNode.next = new ListNode(carry);
        }
        return resultList.next;
    }
}
