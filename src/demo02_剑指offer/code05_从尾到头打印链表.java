package demo02_剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author ajie
 * @date 2023/7/4
 * @description:
 */
public class code05_从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        Collections.reverse(arrayList);
        return arrayList.stream().mapToInt(k -> k).toArray();
    }
}
