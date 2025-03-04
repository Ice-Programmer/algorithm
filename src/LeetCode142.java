/**
 * LeetCode：142.环形链表II
 *
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2025/3/4 19:57
 */
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
