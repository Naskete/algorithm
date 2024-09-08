package LinkedList;

public class SplitLinkedList {
    // 725. Split Linked List in Parts
    // https://leetcode.com/problems/split-linked-list-in-parts/description/?envType=daily-question&envId=2024-09-08
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) {
            return new ListNode[0];
        }
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int avg = len / k;
        int mod = len % k;
        ListNode[] res = new ListNode[k];
        p = head;
        for (int turn = 0; turn < k; turn++) {
            ListNode damnHead = new ListNode();
            ListNode cur = damnHead;
            for (int n = 0; n < avg; n++) {
                cur.next = p;
                p = p.next;
                cur = cur.next;
            }
            if (mod > 0) {
                cur.next = p;
                p = p.next;
                cur = cur.next;
                cur.next = null;
                mod--;
            } else {
                cur.next = null;
            }
            res[turn] = damnHead.next;
        }
        return res;
    }
}