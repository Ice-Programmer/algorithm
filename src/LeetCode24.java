/**
 * LeetCode：24. 两两交换链表中的节点
 *
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2025/3/3 18:16
 */
public class LeetCode24 {

    // 设置虚拟头节点
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode current = dummyHead;
        while (current.next != null && current.next.next != null) {
            ListNode temp = current.next;
            ListNode temp1 = current.next.next.next;
            current.next = current.next.next;
            current.next.next = temp;
            current.next.next.next = temp1;
            current = current.next.next;
        }
        return dummyHead.next;
    }
}
