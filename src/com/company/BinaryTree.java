package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTree {
    Node root;

    public Node addChild(Node addValToNode, int value) {
        if (addValToNode == null) {
            return new Node(value);
        }

        if (addValToNode.getValue() > value) {
            addValToNode.lChild = addChild(addValToNode.lChild, value);
        } else {
            addValToNode.rChild = addChild(addValToNode.rChild, value);
        }

        return addValToNode;
    }

    /*
        Recursively search and shift left or right depending on value
     */
    public Node hasValue(Node selectedNode, int value) {
        // If there are no more children then the val doesn't exist in the three
        if (selectedNode == null) {
            return null;
        }

        if (selectedNode.getValue() == value) {
            return selectedNode;
        }

        if (value < selectedNode.getValue()) {
            return hasValue(selectedNode.lChild, value);
        } else {
            return hasValue(selectedNode.rChild, value);
        }
    }

    /*
        Recursively check and shift left or right depending on what has another child until null is reached

        https://stackoverflow.com/questions/41629247/maximum-height-of-a-binary-tree
     */
    public int getTreeHeight(Node selectedNode) {
        if (selectedNode == null) {
            return 0;
        }

        return 1 + Math.max(getTreeHeight(selectedNode.lChild), getTreeHeight(selectedNode.rChild));
    }

    /*
        Keep shifting left until null child
     */
    public int getSmallestInt(Node selectedNode) {
        if (selectedNode.lChild == null) {
            return selectedNode.getValue();
        }

        return getSmallestInt(selectedNode.lChild);
    }

    /*
        Keep shifting left until null child
     */
    public Node getLargestInt(Node selectedNode) {
        if (selectedNode.rChild == null) {
            return selectedNode;
        }

        return getLargestInt(selectedNode.rChild);
    }

    public void traverseInOrder(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        traverseInOrder(currentNode.lChild);

        System.out.println(currentNode.getValue());

        traverseInOrder(currentNode.rChild);
    }

    public void traversePreOrder(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        System.out.println(currentNode.getValue());

        traversePreOrder(currentNode.lChild);
        traversePreOrder(currentNode.rChild);
    }

    public void traversePostOrder(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        traversePostOrder(currentNode.lChild);
        traversePostOrder(currentNode.rChild);

        System.out.println(currentNode.getValue());
    }

    public boolean searchDepth(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }

        if (currentNode.getValue() == value) {
            return true;
        }

        traverseInOrder(currentNode.lChild);

        System.out.println(currentNode.getValue());

        traverseInOrder(currentNode.rChild);

        return false;
    }

    /*
        Recursively searches through binary tree, puts all values into an arraylist, then sorts from least to greatest
     */
    public ArrayList<Integer> getSortedListOfInts(Node selectedNode, ArrayList<Integer> currentList) {
        if (selectedNode.lChild != null) {
            currentList.add(selectedNode.lChild.getValue());
            currentList = getSortedListOfInts(selectedNode.lChild, currentList);
        }

        if (selectedNode.rChild != null) {
            currentList.add(selectedNode.rChild.getValue());
            currentList = getSortedListOfInts(selectedNode.rChild, currentList);
        }

        // Now sort from least to greatest
        Collections.sort(currentList);

        return currentList;
    }

    public Node getSmallestIntFromTree() {
        ArrayList<Integer> startingList = new ArrayList<>();
        ArrayList<Integer> sortedInts = getSortedListOfInts(root, startingList);

        return hasValue(root, sortedInts.get(0));
    }

    public Node getLargestIntFromTree() {
        ArrayList<Integer> startingList = new ArrayList<>();
        ArrayList<Integer> sortedInts = getSortedListOfInts(root, startingList);

        return hasValue(root, sortedInts.get(sortedInts.size() - 1));
    }

    /*
        Recursively go down tree until value is found and delete node from tree and reorganize if needed
     */
    public void deleteValueFromTree(Node selectedNode, int valToDelete) {
        // First check to see if left or right child contain val, if so we can delete and ignore rest of recursive code
        if (selectedNode.lChild != null && selectedNode.lChild.getValue() == valToDelete) {
            selectedNode.lChild = null;
            return;
        }

        if (selectedNode.rChild != null && selectedNode.rChild.getValue() == valToDelete) {
            selectedNode.rChild = null;
            return;
        }

        // If the currently selected node has no children which match the value, recursively go farther down the tree
        if (valToDelete < selectedNode.getValue()) {
            deleteValueFromTree(selectedNode.lChild, valToDelete);
        } else {
            deleteValueFromTree(selectedNode.rChild, valToDelete);
        }
    }

    /*
        Gets getSortedListOfints, and given an int to find, does getSortedListOfints.length - nthPosition
     */
    public Node getNthLargestInt(int nthPosition) {
        ArrayList<Integer> startingList = new ArrayList<>(); // Used since a blank array is needed for method cal.l.
        ArrayList<Integer> sortedInts = getSortedListOfInts(root, startingList);

        return hasValue(root, sortedInts.get(sortedInts.size() - nthPosition));
    }

    public ArrayList<Integer> printSortedListOfInts() {
        ArrayList<Integer> startingList = new ArrayList<>(); // Used since a blank array is needed for method cal.l.

        return getSortedListOfInts(root, startingList);
    }

    public void addValue(int value) {
        root = addChild(root, value);
    }
}
