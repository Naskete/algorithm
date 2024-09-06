package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemovePresentNode {
    // 3217. delete nodes from linked list present in array
    // https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/?envType=daily-question&envId=2024-09-06
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }
        while (numbers.contains(head.val)) {
            head = head.next;
        }
        ListNode p = head, q = p.next;
        while (q != null) {
            if (numbers.contains(q.val)) {
                p.next = q.next;
            } else {
                p = p.next;
            }
            q = q.next;
        }
        return head;
    }
}
