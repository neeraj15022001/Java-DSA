package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair<T, V> {
    public T height;
    public V diameter;
}

public class BinaryTreeUse {
    public static Pair<Integer, Integer> diameterBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Pair<Integer, Integer> output = new Pair<>();
            output.height = 0;
            output.diameter = 0;
            return output;
        }
        Pair<Integer, Integer> leftOutput = diameterBetter(root.left);
        Pair<Integer, Integer> rightOutput = diameterBetter(root.right);
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);
        int option1 = leftOutput.height + rightOutput.height;
        int option2 = leftOutput.height;
        int option3 = rightOutput.height;
        int diameter = Math.max(option1, Math.max(option2, option3));
        Pair<Integer, Integer> ans = new Pair<>();
        ans.height = height;
        ans.diameter = diameter;
        return ans;
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int ans = 1;
        int leftVal = height(root.left);
        int rightVal = height(root.right);
        ans += Math.max(leftVal, rightVal);
        return ans;
    }

    public static int diameter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int option1 = height(root.left) + height(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);
        return Math.max(option1, Math.max(option2, option3));
    }

    public static int countNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int ans = 1;
        ans += countNodes(root.left);
        ans += countNodes(root.right);
        return ans;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        String s = "";
        while (!pendingNodes.isEmpty()) {
            s = "";
            BinaryTreeNode<Integer> front = pendingNodes.remove();
            if (front == null) {
                return;
            }
            s = front.data + ":";
            if (front.left != null) {
                s += "L:" + front.left.data;
                pendingNodes.add(front.left);
            } else {
                s += "L:-1";
            }
            if (front.right != null) {
                s += "R:" + front.right.data;
                pendingNodes.add(front.right);
            } else {
                s += "R:-1";
            }
            System.out.println(s);
        }
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> pendingNode = new LinkedList<>();
        System.out.println("Enter root data");
        int rootData = sc.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNode.add(root);
        while (!pendingNode.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingNode.remove();
            System.out.println("Enter left child of " + front.data + " Node");
            int leftChild = sc.nextInt();
            if (leftChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
                pendingNode.add(child);
                front.left = child;
            }
            System.out.println("Enter right child of " + front.data + " Node");
            int rightChild = sc.nextInt();
            if (rightChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
                pendingNode.add(child);
                front.right = child;
            }
        }
        return root;
    }

    public static void printBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        String s = root.data + " : ";
        if (root.left != null) {
            s += "L: " + root.left.data + ", ";
        }
        if (root.right != null) {
            s += "L: " + root.right.data + ", ";
        }
        System.out.println(s);
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    public static BinaryTreeNode<Integer> takeInput(Scanner sc) {
        System.out.println("Enter Node Data: ");
        int value = sc.nextInt();
        if (value == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(value);
        BinaryTreeNode<Integer> left = takeInput(sc);
        BinaryTreeNode<Integer> right = takeInput(sc);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        sc.close();
//        System.out.println(countNodes(root));
        Pair<Integer, Integer> ans = diameterBetter(root);
        System.out.println("Height: " + ans.height + " Diameter: " + ans.diameter);
    }
}
