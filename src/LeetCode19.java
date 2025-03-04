/**
 * LeetCode：19.删除链表倒数第N个节点
 *
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2025/3/4 19:49
 */
public class LeetCode19 {

    // 使用快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
