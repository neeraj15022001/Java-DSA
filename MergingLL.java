public class MergingLL {
    public static void main(String[] args) {
        LinkedListPractice lp = new LinkedListPractice();
        Node<Integer> t1 = lp.takeInput();
        Node<Integer> t2 = lp.takeInput();
        lp.printLinkedList(t1);
        lp.printLinkedList(t2);
        Node<Integer> h3 = t1;
        Node<Integer> t3 = t1;
        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                t1 = t1.nextNode;
                t3.nextNode = t2;
                t3 = t3.nextNode;
            } else {
                t2 = t2.nextNode;
                t3.nextNode = t1;
                t3 = t3.nextNode;
            }
        }
        while (t1 != null) {
            t1 = t1.nextNode;
            t3.nextNode = t1;
            t3 = t3.nextNode;
        }
        while (t2 != null) {
            t2 = t2.nextNode;
            t3.nextNode = t2;
            t3 = t3.nextNode;
        }

        lp.printLinkedList(h3);
    }
}
