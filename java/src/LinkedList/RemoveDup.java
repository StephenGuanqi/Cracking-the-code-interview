package LinkedList;

import java.util.HashSet;

public class RemoveDup {

    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    // O(n) time, O(n) space
    public void removeDup(Node n) {
        HashSet<Integer> set = new HashSet<>();
        Node previous = null;
        while(n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
             n = n.next;
        }
    }

    // O(n^2) time, O(1) space
    public void deleteDups(Node n) {
        Node current = n;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

}
