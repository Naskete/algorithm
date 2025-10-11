package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomNode {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            node = node.next;
        }
        Node copy = new Node(0);
        Node p = head;
        Node q = copy;
        while (p != null) {
            q.next = map.get(p);
            q.next.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return copy.next;
    }
}
