package LinkedList;

public class SumLists {

    class LinkedListNode {
        int data;
        LinkedListNode next;
        public LinkedListNode(int data) {
            this.data = data;
        }
    }


    // consider the linked list that are not the same length!!!!
    public LinkedListNode sumLists(LinkedListNode a, LinkedListNode b) {
        if (a == null || b == null) {
            return null;
        }
        int carry = 0;
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode prev = dummy;
        while (a != null || b!= null || carry != 0) {
            int data = carry;
            if (a != null) {
                data += a.data;
            }
            if (b != null) {
                data += b.data;
            }

            LinkedListNode result = new LinkedListNode(data % 10);
            prev.next = result;
            prev = result;

            carry = data / 10;
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }
        LinkedListNode head = dummy.next;
        dummy.next = null;
        return head;
    }

    // recursively
    public LinkedListNode sumLists(LinkedListNode a, LinkedListNode b, int carry) {
        if (a == null && b == null && carry == 0) {
            return null;
        }

        int value = carry;
        if (a != null) {
            value += a.data;
        }
        if (b != null) {
            value += b.data;
        }
        LinkedListNode result = new LinkedListNode(value % 10);

        if (a != null || b != null) {
            result.next = sumLists(a == null ? null : a.next,
                                    b == null ? null : b.next, carry / 10);
        }
        return result;
    }

    // follow  up:   5->1->4 is 514
    // carry transfer into the deepest recursive---> pass as argument
    // carry needs to be returned from the deepest recursive----> return as a wrapper
    class PartialSum {
        public LinkedListNode sum = null;
        public int carry = 0;
    }
    public LinkedListNode sumLists2(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        // padding the shorter linked list with zero
        if (len1 < len2) {
            padList(l1, len2 - len1);
        } else {
            padList(l2, len1 - len2);
        }

        // sum two list
        PartialSum partialSum = addListHelper(l1, l2);
        if (partialSum.carry != 0 ) {
            LinkedListNode result = insertNodeBefore(partialSum.sum, partialSum.carry);
            return result;
        } else {
            return partialSum.sum;
        }
    }

    private int length(LinkedListNode l) {
        return 0;
    }

    private void padList(LinkedListNode head, int padding) {
        for (int i = 0; i < padding; i++) {
            head = insertNodeBefore(head, 0);
        }
    }

    private PartialSum addListHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }

        // l1 and l2 are not null
        // add smaller digits recursively
        PartialSum partialSum = addListHelper(l1.next, l2.next);

        // add carry to current data
        int carry = partialSum.carry;
        int val = carry + l1.data + l2.data;

        // insert sum of current digits
        LinkedListNode currentNode = insertNodeBefore(partialSum.sum, val % 10);

        // return sum so far
        partialSum.sum = currentNode;
        partialSum.carry = val / 10;

        return partialSum;
    }

    private LinkedListNode insertNodeBefore(LinkedListNode l, int val) {
        LinkedListNode node = new LinkedListNode(val);
        node.next = l;
        return node;
    }


}
