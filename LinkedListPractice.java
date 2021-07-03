import java.io.IOException;
import java.util.Scanner;

public class LinkedListPractice {
    public int getLinkedListLength(Node<Integer> head) {
        int count = 0;
        Node<Integer> temp = head;
        while (temp != null) {
            temp = temp.nextNode;
            count++;
        }
        return count;
    }

    public Node<Integer> deleteNode(Node<Integer> head, int position) throws IOException {
        Node<Integer> temp = null;
        Node<Integer> temp2 = null;
        int i = 0;
        if (position <= 0)
            throw new IOException("Enter value of position greater than 0");
        if (position == 1) {
            head = head.nextNode;
            return head;
        }
        while (i < position) {
            if (temp == null) {
                temp = head;
                temp2 = head;
            } else {
                temp = temp.nextNode;
                if (i < position - 1)
                    temp2 = temp2.nextNode;
            }
            i++;
        }
        temp2.nextNode = temp.nextNode;
        return head;
    }

    public Node<Integer> insert(Node<Integer> head, int data, int position) throws IOException {
        Node<Integer> newNode = new Node<>(data);
        int i = 0;
        Node<Integer> temp = null;
        int length = getLinkedListLength(head);
        System.out.println(length);
        if (length < position)
            throw new IOException("position passed is greater than length of linked list");
        if (position <= 0)
            throw new ArithmeticException("Enter value greater than 0");
        if (position == 1) {
            newNode.nextNode = head;
            head = newNode;
            return head;
        }
        while (i < position - 1) {
            if (temp == null)
                temp = head;
            else
                temp = temp.nextNode;
            i++;
        }
        newNode.nextNode = temp.nextNode;
        temp.nextNode = newNode;
        return head;
    }

    public Node<Integer> takeInput() {
        Node<Integer> head = null;
        Node<Integer> tail = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        while (data != -1) {
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.nextNode = newNode;
                tail = tail.nextNode;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public void printLinkedList(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.nextNode;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Node<Integer> node1 = new Node<Integer>(10);
        Node<Integer> node2 = new Node<Integer>(20);
        Node<Integer> node3 = new Node<Integer>(30);
        node1.nextNode = node2;
        node2.nextNode = node3;
        LinkedListPractice lp = new LinkedListPractice();
        Node<Integer> head = lp.takeInput();
//        head = lp.insert(head, 80, 4);
//        lp.printLinkedList(head);
        head = lp.deleteNode(head,3);
        lp.printLinkedList(head);
    }
}
