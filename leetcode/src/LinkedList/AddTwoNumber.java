package LinkedList;

public class AddTwoNumber {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode head = new ListNode(0);
        ListNode l = head;
        int carry = 0;
        while(p != null || q != null) {
            int n1 = p != null ? p.val : 0;
            int n2 = q != null ? q.val : 0;
            int sum = n1 + n2 + carry;
            l.next = new ListNode(sum % 10);
            l = l.next;
            carry = sum / 10;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            l.next = new ListNode(1);
        }
        return head.next;
    }

}
