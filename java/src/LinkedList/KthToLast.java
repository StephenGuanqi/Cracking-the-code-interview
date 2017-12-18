package LinkedList;

public class KthToLast {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static int counter = 0;
    // or wrap a result type here
    Node kthToLast(Node node, int k) {
        if (node == null) {
            return null;
        }
        Node n = kthToLast(node, k);
        counter += 1;
        if (counter == k) {
            return node;
        }
        return n;
    }

    // p2 is length-k from the head, p1 is k from the head
    Node KthToLast(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < k; i++) {
           if (p1 == null) {
               return null; // input is null or k is too large
           }
           p1 = p1.next;
        }

        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

}
