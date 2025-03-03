/**
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2025/3/3 17:39
 */
public class LeetCode206 {
    // 双指针写法
    public ListNode reverseListByPoint(ListNode head) {
        ListNode preNode = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode tempNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = tempNode;
        }
        return preNode;
    }

    // 递归写法
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode current, ListNode pre) {
        if (current == null) {
            return pre;
        }
        ListNode temp = current.next;
        current.next = pre;
        return reverse(temp, current);
    }


}
