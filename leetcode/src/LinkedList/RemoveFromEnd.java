package LinkedList;

public class RemoveFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        while (p != null && n > 0) {
            n--;
            p = p.next;
        }
        if (p == null) {
            return head.next;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        while (p != null) {
            p = p.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
