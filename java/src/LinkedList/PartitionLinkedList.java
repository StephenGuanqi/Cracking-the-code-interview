package LinkedList;

public class PartitionLinkedList {

    class LinkedListNode {
        int data;
        LinkedListNode next;
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

    // partition around the value and make the node's data less than value to the left of the nodes' data greater or equal
    // than the value
    // sequence doesn't matter
    public LinkedListNode partition(LinkedListNode node, int value) {
        if (node == null) return null;
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            if (node.data < value) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        // very important, test cases!!!!!!
        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    // method 2, operate on the original list
    // return new head
    public LinkedListNode partition2(LinkedListNode node, int pivot) {
        if (node == null) return null;
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < pivot) {
                // insert node at head
                node.next = head;
                head = node;
            } else {
                // insert node at tail
                tail.next = node;
                tail = node;
            }
            node = next;
        }

        tail.next = null;

        return head;
    }

}
