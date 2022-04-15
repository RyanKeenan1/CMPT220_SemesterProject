package com.company;

public class Node {
    private int value = 0;

    Node lChild;
    Node rChild;

    /*
        Class init with value for which node will hold value of
     */
    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
