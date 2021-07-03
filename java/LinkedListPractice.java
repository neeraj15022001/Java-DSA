public class LinkedListPractice {
    public void printLinkedList(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.nextNode;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("hello");
//        Node<Integer> node1 = new Node<Integer>(10);
//        Node<Integer> node2 = new Node<Integer>(20);
//        Node<Integer> node3 = new Node<Integer>(30);
//        node1.nextNode = node2;
//        node2.nextNode = node3;
//        LinkedListPractice lp = new LinkedListPractice();
//        Node<Integer> head = node1;
//        lp.printLinkedList(node1);
    }
}
