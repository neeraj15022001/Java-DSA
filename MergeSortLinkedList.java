import java.util.Scanner;

class MergeSortLinkedList {

    public static Node<Integer> getTail(Node<Integer> head) {
        Node<Integer> tail = head;
        while (tail.nextNode != null) {
            tail = tail.nextNode;
        }
        return tail;
    }

    public static Node<Integer> merge(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> result = null;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.data <= list2.data) {
            result = list1;
            result.nextNode = merge(list1.nextNode, list2);
        } else {
            result = list2;
            result.nextNode = merge(list1, list2.nextNode);
        }
        return result;
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        if (head == null || head.nextNode == null)
            return head;
        Node<Integer> mid = findMid(head);
        Node<Integer> nextMid = mid.nextNode;
        mid.nextNode = null;
        Node<Integer> list1 = mergeSort(head);
        Node<Integer> list2 = mergeSort(nextMid);
        Node<Integer> sortedList = merge(list1, list2);
        return sortedList;
    }

    public static Node<Integer> findMid(Node<Integer> head) {
        if (head == null)
            return head;

        Node<Integer> slow = head, fast = head;

        while (fast.nextNode != null && fast.nextNode.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        return slow;
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
        Node<Integer> tail = getTail(head);
        Node<Integer> mid = findMid(head);
        Node<Integer> newHead = mergeSort(head);
        printLinkedList(newHead);
    }
}