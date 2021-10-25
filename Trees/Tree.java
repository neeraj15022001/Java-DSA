package Trees;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public static TreeNode<Integer> takeInput(Scanner sc) {
        int n;
        System.out.println("Enter next Node");
        n = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(n);
        System.out.println("Enter count of Child Nodes");
        int childCount = sc.nextInt();
        for (int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInput(sc);
            root.children.add(child);
        }
        return root;
    }

    public static void printTree(TreeNode<Integer> root) {
        String s = root.data + ":";
        for (int i = 0; i < root.children.size(); i++) {
            s += root.children.get(i).data + ",";
        }
        System.out.println(s);
        for (int i = 0; i < root.children.size(); i++) {
            printTree(root.children.get(i));
        }
    }

    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root Element");
        int rootData = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        Queue<TreeNode<Integer>> pendingNode = new LinkedList<TreeNode<Integer>>();
        pendingNode.add(root);
        while (!pendingNode.isEmpty()) {
            TreeNode<Integer> front = pendingNode.remove();
            System.out.println("Enter number of child elements for " + front.data);
            int childCount = sc.nextInt();
            for (int i = 0; i < childCount; i++) {
                System.out.println("Enter value for " + (i + 1) + "th child for root = " + front.data);
                int childValue = sc.nextInt();
                TreeNode<Integer> child = new TreeNode<>(childValue);
                front.children.add(child);
                pendingNode.add(child);
            }
        }
        return root;
    }

    public static void printLevelWise(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> pendingNode = new LinkedList<TreeNode<Integer>>();
        pendingNode.add(root);
        while (!pendingNode.isEmpty()) {
            TreeNode<Integer> front = pendingNode.remove();
            String s = front.data + ": ";
            for (int i = 0; i < front.children.size(); i++) {
                s += front.children.get(i).data + ",";
                pendingNode.add(front.children.get(i));
            }
            System.out.println(s);
        }
    }

    public static int numNode(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            count += numNode(root.children.get(i));
        }
        return count;
    }

    public static int findLargest(TreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int ans = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            int childLargest = findLargest(root.children.get(i));
            if (ans < childLargest) {
                ans = childLargest;
            }
        }
        return ans;
    }

    public static void printAtK(TreeNode<Integer> root, int k) {
        if(k < 0) {
            return;
        }
        if( k == 0) {
            System.out.println(root.data);
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            printAtK(root.children.get(i), k-1);
        }
    }
}
