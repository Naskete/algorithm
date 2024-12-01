package LinkedList;

public class InsertGreatestCommonDivisor {

    // 2807. Insert Greatest Common Divisors in Linked List
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p.next != null) {
            int x = p.val;
            int y = p.next.val;
            int val = gcd(x, y);
            ListNode divisor = new ListNode(val);
            divisor.next = p.next;
            p.next = divisor;
            p = p.next.next;
        }
        return head;
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }

    public int gcdII(int x, int y) {
        while (x != y) {
            if (x > y) {
                x -= y;
            } else {
                y -= x;
            }
        }
        return x;
    }
}
