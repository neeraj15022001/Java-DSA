package Trees;
import com.sun.source.tree.Tree;

import java.util.Scanner;

import static Trees.Tree.*;

public class TreeUse {
    public static void main(String[] args) {
//        TreeNode<Integer> root = new TreeNode<Integer>(4);
//        TreeNode<Integer> node1 = new TreeNode<Integer>(2);
//        TreeNode<Integer> node2 = new TreeNode<Integer>(3);
//        TreeNode<Integer> node3 = new TreeNode<Integer>(5);
//        TreeNode<Integer> node4 = new TreeNode<Integer>(6);
//
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//        node2.children.add(node4);
        Scanner sc = new Scanner(System.in);
        TreeNode<Integer> root = takeInput(sc);
        printTree(root);
//        TreeNode<Integer> root = takeInputLevelWise();
//        printLevelWise(root);
    }
}
