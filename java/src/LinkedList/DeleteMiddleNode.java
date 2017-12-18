package LinkedList;

public class DeleteMiddleNode {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // consider:
    // 1. How to deal with if the middle node is the last node?
    // 2. How to deal with if the linked list is only one or no node?
    public boolean deleteMiddleNode(Node middle) {
       if (middle == null || middle.next == null) {
           return false;
       }
       middle.data = middle.next.data;
       middle.next = middle.next.next;
       return true;
    }

}
