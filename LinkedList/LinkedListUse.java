import java.util.Scanner;

public class LinkedListUse {
    public static Node<Integer> deleteNodeRecursively(Node<Integer> head, int pos) {
        if(pos == 0) {
            return head.next;
        }
        if(head == null) {
            return head;
        }
        Node<Integer> newHead = deleteNodeRecursively(head.next, pos-1);
        head.next = newHead;
        return head;

    }
    public static Node<Integer> insertRecursively(Node<Integer> head, int pos, int element) {
        if(pos == 0) {
            Node<Integer> newNode = new Node<Integer>(element);
            newNode.next = head;
            return newNode;
        }
        if(head == null) {
            return head;
        }
        Node<Integer> newHead = insertRecursively(head.next, pos-1, element);
        head.next = newHead;
        return head;

    }
    public static Node<Integer> reverseLinkedListIteratively(Node<Integer> head) {
        Node<Integer> curr = head, prev = null;
        while(curr != null) {
            Node<Integer> temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static Node<Integer> reverseLinkedListBest(Node<Integer> head) {
        if(head == null || head.next == null)
            return head;
        Node<Integer> reversedTail = head.next;
        Node<Integer> finalHead = reverseLinkedListBest(head.next);
        reversedTail.next = head;
        head.next = null;
        return finalHead;
    }
    public static DoubleNode reverseLinkedListBetter(Node<Integer> head) {
        if(head == null || head.next == null) {
            DoubleNode ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }
        DoubleNode smallAns = reverseLinkedListBetter(head.next);
        smallAns.tail.next = head;
        head.next = null;
        DoubleNode ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
    }
    public static Node<Integer> reverseLinkedList(Node<Integer> head) {
        if(head == null || head.next == null)
            return head;
        Node<Integer> finalHead = reverseLinkedList(head.next);
        Node<Integer> temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;
        return finalHead;
    }
    public static Node<Integer> mergeSort(Node<Integer> head) {
        if(head.next == null)
            return head;
        Node<Integer> mid = midpointOfLinkedList(head);
        Node<Integer> head1 = mergeSort(mid.next);
        mid.next = null;
        Node<Integer> head2 = mergeSort(head);
        Node<Integer> newHead = mergeTwoSortedLinkedList(head1, head2);
        return newHead;

    }
    public static Node<Integer> mergeTwoSortedLinkedList(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> t1 = head1;
        Node<Integer> t2 = head2;
        Node<Integer> head = null, tail = null;
        while(t1 != null && t2 != null) {
            if(head == null) {
                if(t1.value < t2.value) {
                    head = t1;
                    tail = t1;
                    t1 = t1.next;
                }
                else {
                    head = t2;
                    tail = t2;
                    t2 = t2.next;
                }
            } else {
                if(t1.value < t2.value) {
                    tail.next = t1;
                    t1 = t1.next;
                }
                else {
                    tail.next = t2;
                    t2 = t2.next;
                }
                tail = tail.next;
            }
        }
        if(t1 != null) {
            tail.next = t1;
        } else if(t2 != null) {
            tail.next = t2;
        }
        return head;
    }
    public static Node<Integer> midpointOfLinkedList(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
        if(pos == 0) {
            head = head.next;
            return head;
        }
        int i = 0;
        Node<Integer> temp = head;
        while(i < pos-1) {
            temp = temp.next;
            i++;
        }
        if(temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }
    public static Node<Integer> insert(Node<Integer> head, int pos, int data) {
        Node<Integer> newNode = new Node<>(data);
        if(pos == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        int i  = 0;
        Node<Integer> temp = head;
        while(i < pos - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
    public static Node<Integer> takeInpuNodes() {
        Node<Integer> head = null;
        Node<Integer> tail = null;
        int data = 0;
        Scanner sc = new Scanner(System.in);
        data = sc.nextInt();
        while(data != -1) {
            Node<Integer> newNode = new Node<>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            data = sc.nextInt();
        }
        // sc.close();
        return head;
    }
    public static void printLinkedList(Node<Integer> head) {
        Node<Integer> temp = head;
        while(temp != null) {
            System.out.print(temp.value);
            System.out.print("\t");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node<Integer> head = takeInpuNodes();
        // head = mergeSort(head);
        // DoubleNode ans = reverseLinkedListBetter(head);
        // head = reverseLinkedList(head);
        // head = reverseLinkedListBest(head);
        // head = reverseLinkedListIteratively(head);
        // head = insertRecursively(head, 1, 10);
        head = deleteNodeRecursively(head, 10);
        printLinkedList(head);
        // head = insert(head, 0, 80);
        // head = deleteNode(head, 1);
        // Node<Integer> midNode = midpointOfLinkedList(head);
        // System.out.println(midNode.value);
        // Node<Integer> head1 = takeInpuNodes();
        // Node<Integer> head2 = takeInpuNodes();
        // Node<Integer> newHead = mergeTwoSortedLinkedList(head1, head2);
        // printLinkedList(newHead);
        // Node<Integer> node1 = new Node<>(10);
        // System.out.println(node1.value);
        // System.out.println(node1.next);
        // Node<Integer> node2 = new Node<>(20);
        // System.out.println(node2.value);
        // System.out.println(node2.next);
        // System.out.println(node2);
        // node1.next = node2;
        // System.out.println(node1.next);
        // System.out.println(node1.next.value);
    }
}
