/**
 * LeetCode：203.移除链表元素
 *
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2025/3/2 18:48
 */
public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        // 设置虚拟头节点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode current = dummyHead;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next  = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}