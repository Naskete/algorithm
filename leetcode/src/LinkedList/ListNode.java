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
        System.out.println();
    }

    /**
     *
     * @param num 数字
     * @param reverse 顺序
     * @return
     * true 321 ===> 3 -> 2 -> 1 -> null
     * false 321 ===> 1 -> 2 -> 3 -> null
     */
    public static ListNode generateListNode(String num, boolean reverse) {
        if (num == null) {
            return null;
        }
        String s = num;
        if (reverse) {
            StringBuilder builder = new StringBuilder(s);
            s = builder.reverse().toString();
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - '0';
            p.next = new ListNode(val);
            p = p.next;
        }
        return head.next;
    }
}
