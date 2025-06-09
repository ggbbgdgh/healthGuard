package com.ggbbgdgh.leetcode;

public class TestMain<T> {


    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.buildFullTree(3, 1);
        System.out.println("从root结点开始访问：");
        tree.printTree(tree.getRoot());
        System.out.println();
        System.out.println("从第一个右结点开始访问：");
        tree.printTree(tree.getRoot().getRight());
        System.out.println();
        System.out.println("从第一个右结点的左结点开始访问：");
        tree.printTree(tree.getRoot().getRight().getLeft());
        System.out.println();

    }
}
