public class MergingLL {
    public Node<Integer> merge(Node<Integer> t1, Node<Integer> t2) {
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
        return h3;
    }

    public static void main(String[] args) {
        LinkedListPractice lp = new LinkedListPractice();
        Node<Integer> t1 = lp.takeInput();
        Node<Integer> t2 = lp.takeInput();
        MergingLL mll = new MergingLL();
        Node<Integer> head = mll.merge(t1, t2);
        lp.printLinkedList(t1);
    }
}
