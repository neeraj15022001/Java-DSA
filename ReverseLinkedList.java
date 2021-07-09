import java.util.Scanner;

public class ReverseLinkedList {

    public static DoubleNode reverseLLBetter(Node<Integer> head) {
        if (head == null || head.nextNode == null) {
            DoubleNode result = new DoubleNode();
            result.head = head;
            result.tail = head;
            return result;
        }
        DoubleNode smallAns = reverseLLBetter(head.nextNode);
        smallAns.tail.nextNode = head;
        head.nextNode = null;

        DoubleNode ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
    }

    public static Node<Integer> reverseL(Node<Integer> head) {
        if (head == null || head.nextNode == null) {
            return head;
        }
        Node<Integer> newHead = reverseL(head.nextNode);
        Node<Integer> temp = newHead;
        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        temp.nextNode = head;
        head.nextNode = null;
        return newHead;
    }

    public static Node<Integer> takeInput() {
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

    public static void printLinkedList(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.nextNode;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        printLinkedList(head);
//        Node<Integer> newHead = reverseL(head);
        DoubleNode ans = reverseLLBetter(head);
        printLinkedList(ans.head);
    }
}
