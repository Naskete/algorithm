package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(){}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode point = head;
        while (point != null) {
            System.out.print(point.val + " -> ");
            point = point.next;
        }
        System.out.print("null");
    }
}
