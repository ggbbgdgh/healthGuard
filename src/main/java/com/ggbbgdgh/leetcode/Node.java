package com.ggbbgdgh.leetcode;

public class Node<T> {

    private Node<T> parent;
    private T data;
    private Node<T> left;
    private Node<T> right;


    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public String print() {
        System.out.print(data);
        return data != null ? data.toString() : "null";
    }
}
