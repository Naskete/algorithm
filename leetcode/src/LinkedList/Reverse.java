package LinkedList;

public class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }

    // 92
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = null, cur = head;
        int len = right - left + 1;
        if (len <= 1) {
            return head;
        }
        while (left > 1) {
            left--;
            pre = cur;
            cur = cur.next;
        }
        ListNode pre1 = null, cur1 = cur;
        while (len > 0) {
            len--;
            ListNode tmp = cur1;
            cur1 = cur1.next;
            tmp.next = pre1;
            pre1 = tmp;
        }
        cur.next = cur1;
        if (pre != null) {
            pre.next = pre1;
            return head;
        }
        return pre1;
    }

    // https://leetcode.cn/problems/reverse-linked-list-ii/solutions/634701/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/
    public ListNode reverseBetweenI(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
