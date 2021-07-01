public class LinkedList {
    public static void printLinkedList(LinkedListNode<Integer> head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(10);
        LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(20);
        LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(30);
        node1.next = node2;
        node2.next = node3;
        LinkedListNode<Integer> head = node1;
        printLinkedList(head);
//        System.out.println(node1.data);
//        System.out.println(node1.next);
//        node1.next = node2;
//        System.out.println(node2);
//        System.out.println(node1.next);

    }
}
