
import Trees.Tree;

import java.util.ArrayList;
import java.util.Scanner;

class QueueEmptyException extends Exception {
}

class QueueUsingLL<T> {

    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public T front() throws QueueEmptyException {
        if (size == 0) {
            QueueEmptyException e = new QueueEmptyException();
            throw e;
        }

        return head.data;
    }


    public void enqueue(T element) {
        Node<T> newNode = new Node<T>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public T dequeue() throws QueueEmptyException {
        if (head == null) {
            QueueEmptyException e = new QueueEmptyException();
            throw e;
        }
        if (head == tail) {
            tail = null;
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }
}

class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    TreeNode(T data) {
        this.data = data;
        children = new ArrayList<TreeNode<T>>();
    }
}


class Solution {
    public static void helper(TreeNode<Integer> root, Pair sm) {
        if (root == null) {
            return;
        }
        if(sm.max == null) {
            sm.max = root;
        }
        if (root.data > sm.max.data) {
            sm.secondMax = sm.max;
            sm.max = root;
        } else if (root.data < sm.max.data && ((sm.secondMax == null) || (sm.secondMax != null && root.data > sm.secondMax.data))) {
            sm.secondMax = root;
        }
        for (int i = 0; i < root.children.size(); i++) {
            helper(root.children.get(i), sm);
        }
    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        Pair sm = new Pair();
        helper(root, sm);
        System.out.println(sm.max.data + " " + sm.secondMax.data);
        return sm.secondMax;
    }
}

class Pair {
    TreeNode<Integer> max;
    TreeNode<Integer> secondMax;
}


public class Main {


    static Scanner s = new Scanner(System.in);

    public static TreeNode<Integer> takeInputLevelWise() {
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
        int rootData = s.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
                int numChild = s.nextInt();
                for (int i = 0; i < numChild; i++) {
                    int currentChild = s.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
                    pendingNodes.enqueue(childNode);
                    currentNode.children.add(childNode);
                }
            } catch (QueueEmptyException e) {
            }
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise();
        TreeNode<Integer> ans = Solution.findSecondLargest(root);
        if (ans == null) {
            System.out.println(Integer.MIN_VALUE);
        } else {
            System.out.println(ans.data);
        }
    }

}
