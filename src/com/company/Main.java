package com.company;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addValue(4);
        binaryTree.addValue(45);
        binaryTree.addValue(22);
        binaryTree.addValue(1);
        binaryTree.addValue(2);
        binaryTree.addValue(3);
        binaryTree.addValue(5);
        binaryTree.addValue(-1);


        System.out.println(binaryTree.printSortedListOfInts().toString());
        binaryTree.deleteValueFromTree(binaryTree.root, 5);
        System.out.println(binaryTree.printSortedListOfInts().toString());
    }
}
