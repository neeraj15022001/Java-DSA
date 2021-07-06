public class MergeSortLinkedList {
    public static LinkedListPractice llp = new LinkedListPractice();

    public Node<Integer> getMid(Node<Integer> head) {
        int length = llp.getLinkedListLength(head);
        int mid = (length - 1)/2;
        int i = 0;
        while (i != mid) {
            head = head.nextNode;
            i++;
        }
        return head;
    }

    public void mergeSort(Node<Integer> head, Node<Integer> tail) {
        int length = llp.getLinkedListLength(head);
        MergingLL mll = new MergingLL();
        if (length <= 1) {
            return;
        }
        Node<Integer> mid = getMid(head);
        mergeSort(head, mid);
        mergeSort(mid.nextNode, tail);
        mll.merge(head, tail);
    }

    public static void main(String[] args) {
        System.out.println(llp);
        Node<Integer> head = llp.takeInput();
        Node<Integer> tail = llp.getTail(head);
        MergeSortLinkedList msll = new MergeSortLinkedList();
        msll.mergeSort(head, tail);
        llp.printLinkedList(head);
    }
}
