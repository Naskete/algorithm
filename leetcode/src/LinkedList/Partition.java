package LinkedList;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode p = less, q = more;
        ListNode idx = head;
        while (idx != null) {
            if (idx.val < x) {
                p.next = new ListNode(idx.val);
                p = p.next;
            } else {
                q.next = new ListNode(idx.val);;
                q = q.next;
            }
            idx = idx.next;
        }
        if (less.next !=null) {
            p.next = more.next;
            return less.next;
        }
        return more.next;
    }
}
