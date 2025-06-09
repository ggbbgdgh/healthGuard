package com.ggbbgdgh.leetcode;

public class Tree<T> {

    private Node<T> root;


    public Node<T> getRoot() {
        return root;
    }
    public Tree<T> buildFullTree(int n, T data) {
        if (n <= 0) {
            return null;
        }
        root = new Node<>(data);
        buildTree(root, n - 1);
        return this;
    }

    public T generateLeftData(T data) {
        if (data instanceof Integer) {
            return (T) Integer.valueOf((Integer) data * 2);
        }
        return null;
    }

    public T generateRightData(T data) {
        if (data instanceof Integer) {
            return (T) Integer.valueOf((Integer) data * 2 + 1);
        }
        return null;
    }

    public Node<T> buildTree(Node<T> parent, int n) {
        if (n <= 0) {
            return null;
        }

        Node<T> node = new Node<>();
        node.setParent(parent);
        node.setData(generateLeftData(parent.getData()));
        parent.setLeft(node);
        node = new Node<>();
        node.setParent(parent);
        node.setData(generateRightData(parent.getData()));
        parent.setRight(node);

        buildTree(parent.getLeft(), n - 1);
        buildTree(parent.getRight(), n - 1);
        return parent;
    }

    public void printTree(Node<T> node) {
        String hasVistit = "";
        Node<T> root = node;
        while (root.getParent() != null) {
            System.out.print(" " + root.getData());
            hasVistit += "_" + root.getData();
            root = root.getParent();
        }
        //到根结点
        printTree(root, hasVistit);
    }

    public void printTree(Node<T> node, String hasVistit) {
        if(node == null) {
            return;
        }
        if(!hasVistit.contains("_" + node.getData())) {
            System.out.print(" " + node.getData());
        }
        printTree(node.getLeft(), hasVistit);
        printTree(node.getRight(), hasVistit);
    }
}
