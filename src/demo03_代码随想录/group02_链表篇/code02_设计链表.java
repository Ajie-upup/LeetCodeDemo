package demo03_代码随想录.group02_链表篇;

/**
 * @author ajie
 * @date 2023/7/31
 * @description:
 */
public class code02_设计链表 {
    public class MyLinkedList {
        //链表中的元素个数
        int size;
        //虚拟头节点
        ListNode head;

        public MyLinkedList() {
            size = 0;
            head = new ListNode();
        }

        /**
         * 获取指定位置的链表中的元素
         */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode currentNode = head;
            for (int i = 0; i <= index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.val;
        }

        /**
         * 在头部添加元素
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * 在尾部添加元素
         */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /**
         * 在指定位置添加元素
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size++;
            ListNode pre = head;
            //遍历找到需要插入节点的前一个节点
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            //构造需要添加的节点
            ListNode newNode = new ListNode(val);
            newNode.next = pre.next;
            pre.next = newNode;
        }

        /**
         * 删除指定位置的元素
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            if (index == 0) {
                head = head.next;
                return;
            }
            ListNode pre = head;
            //遍历找到需要删除节点的前一个节点
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
        }
    }
}
