package com.company;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of test you would like to do. Available options are:");
        System.out.println("findelement");
        System.out.println("findheight");
        System.out.println("findsmallest");
        System.out.println("findlargest");
        System.out.println("findnthlargest");
        System.out.println("removeelement");
        System.out.println("listinorder");
        System.out.println("listpreorder");

        String input = scanner.nextLine();

        while (!input.equals("exit")) {
            if (input.equals("findelement")) {
                System.out.println("Finding element 5");
                findElement(5);
            } else if (input.equals("findheight")) {
                System.out.println("Finding height for binary tree");
                findHeight();
            } else if (input.equals("findsmallest")) {
                System.out.println("Finding smallest element in binary tree");
                findSmallest();
            } else if (input.equals("findlargest")) {
                System.out.println("Finding largest element in binary tree");
                findLargest();
            } else if (input.equals("findnthlargest")) {
                System.out.println("Finding 5th largest value in binary tree");
                findNthLargest(5);
            } else if (input.equals("removeelement")) {
                removeElement(5);
            } else if (input.equals("listinorder")) {
                listInOrder();
            } else if (input.equals("listpreorder")) {
                listPreOrder();
            } else {
                System.out.println("Invalid input! Please enter one of the available tests.");
            }

            input = scanner.nextLine();
        }

        System.out.println("Programming exiting");
    }

    public static void findElement(int valToFind) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addValue(4);
        binaryTree.addValue(45);
        binaryTree.addValue(22);
        binaryTree.addValue(1);
        binaryTree.addValue(2);
        binaryTree.addValue(3);
        binaryTree.addValue(5);
        binaryTree.addValue(-1);

        Node result = binaryTree.hasValue(binaryTree.root, valToFind);
        System.out.println("Results of findelement:");

        if (result instanceof Node && result != null) {
            System.out.println("Found node " + result + " with value of " + result.getValue());
        }
    }

    public static void findHeight() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addValue(4);
        binaryTree.addValue(45);
        binaryTree.addValue(22);
        binaryTree.addValue(1);
        binaryTree.addValue(2);
        binaryTree.addValue(3);
        binaryTree.addValue(5);
        binaryTree.addValue(-1);

        System.out.println("Height is 4. Now running test to check result");

        int bTreeHeight = binaryTree.getTreeHeight(binaryTree.root);

        if (bTreeHeight == 4) {
            System.out.println("Test is successful! Height of binary tree is 4 and returned " + bTreeHeight);
        } else {
            System.out.println("Test failed. Height of binary tree is 4 but returned " + bTreeHeight);
        }
    }

    public static void findSmallest() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addValue(4);
        binaryTree.addValue(45);
        binaryTree.addValue(22);
        binaryTree.addValue(1);
        binaryTree.addValue(2);
        binaryTree.addValue(3);
        binaryTree.addValue(5);
        binaryTree.addValue(-1);

        System.out.println("Smallest element in tree is -1. Now running test to check result");

        int bTreeSmallestElement = binaryTree.getSmallestInt(binaryTree.root);

        if (bTreeSmallestElement == -1) {
            System.out.println("Test is successful! Smallest element is -1 and returned " + bTreeSmallestElement);
        } else {
            System.out.println("Test failed! Smallest element is -1 and returned " + bTreeSmallestElement);
        }
    }

    public static void findLargest() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addValue(4);
        binaryTree.addValue(45);
        binaryTree.addValue(22);
        binaryTree.addValue(1);
        binaryTree.addValue(2);
        binaryTree.addValue(3);
        binaryTree.addValue(5);
        binaryTree.addValue(-1);

        System.out.println("Smallest element in tree is 45. Now running test to check result");

        Node bTreeSmallestElement = binaryTree.getLargestInt(binaryTree.root);

        if (bTreeSmallestElement.getValue() == 45) {
            System.out.println("Test is successful! Smallest element is 45 and returned " + bTreeSmallestElement.getValue());
        } else {
            System.out.println("Test failed! Smallest element is 45 and returned " + bTreeSmallestElement.getValue());
        }
    }

    public static void findNthLargest(int nthToFind) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addValue(4);
        binaryTree.addValue(45);
        binaryTree.addValue(22);
        binaryTree.addValue(1);
        binaryTree.addValue(2);
        binaryTree.addValue(3);
        binaryTree.addValue(5);
        binaryTree.addValue(-1);

        System.out.println("5th largest element in tree is 2. Now running test to check result");

        Node nthLargestNode = binaryTree.getNthLargestInt(nthToFind);

        if (nthLargestNode.getValue() == 2) {
            System.out.println("Test is successful! Smallest element is 2 and returned " + nthLargestNode.getValue());
        } else {
            System.out.println("Test failed! Smallest element is 2 and returned " + nthLargestNode.getValue());
        }
    }

    public static void removeElement(int valToRemove) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addValue(4);
        binaryTree.addValue(45);
        binaryTree.addValue(22);
        binaryTree.addValue(1);
        binaryTree.addValue(2);
        binaryTree.addValue(3);
        binaryTree.addValue(5);
        binaryTree.addValue(-1);

        System.out.println("Now attempting to remove element " + valToRemove + " from binary tree. Tree before removall");
        System.out.println(binaryTree.printSortedListOfInts().toString());

        binaryTree.deleteValueFromTree(binaryTree.root, valToRemove);

        System.out.println("After removal");
        System.out.println(binaryTree.printSortedListOfInts().toString());
    }

    public static void listInOrder() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addValue(4);
        binaryTree.addValue(45);
        binaryTree.addValue(22);
        binaryTree.addValue(1);
        binaryTree.addValue(2);
        binaryTree.addValue(3);
        binaryTree.addValue(5);
        binaryTree.addValue(-1);

        System.out.println("Now listing elements in order");
        binaryTree.traverseInOrder(binaryTree.root);
    }

    public static void listPreOrder() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addValue(4);
        binaryTree.addValue(45);
        binaryTree.addValue(22);
        binaryTree.addValue(1);
        binaryTree.addValue(2);
        binaryTree.addValue(3);
        binaryTree.addValue(5);
        binaryTree.addValue(-1);

        System.out.println("Now listing elements in preorder");
        binaryTree.traversePreOrder(binaryTree.root);
    }

    public static void listPostOrder() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addValue(4);
        binaryTree.addValue(45);
        binaryTree.addValue(22);
        binaryTree.addValue(1);
        binaryTree.addValue(2);
        binaryTree.addValue(3);
        binaryTree.addValue(5);
        binaryTree.addValue(-1);

        System.out.println("Now listing elements in preorder");
        binaryTree.traversePostOrder(binaryTree.root);
    }
}
