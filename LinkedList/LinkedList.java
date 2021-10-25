package LinkedList;

import java.util.Scanner;

public class LinkedList {
    public LinkedListNode<Integer> head;
    public LinkedListNode<Integer> tail;
    int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void takeInput() {
        int data;
        Scanner sc = new Scanner(System.in);
        data = sc.nextInt();
        while (data != -1) {
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
            data = sc.nextInt();
        }
        sc.close();
    }

    public void printLL(LinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void addLast(int element) {
        LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(element);
        if (!isEmpty()) {
            tail.next = newNode;
            tail = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
    }

    public void addFirst(int element) {
        LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(element);
        if (!isEmpty()) {
            newNode.next = head;
            head = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtIndex(int element, int index) {
        if (!isEmpty()) {
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(element);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else if (index == size) {
                tail.next = newNode;
                tail = newNode;
            } else if (index > (size - 1)) {
                System.out.println("Index out of range");
                return ;
            } else {
                int currentIndex = 0;
                LinkedListNode<Integer> temp = head;
                while (currentIndex != (index - 1)) {
                    temp = temp.next;
                    currentIndex++;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
            size++;
        } else {
            System.out.println("Linked List is empty()");
            return ;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.takeInput();
        ll.insertAtIndex(5, 0);
        ll.printLL(ll.head);
    }
}
