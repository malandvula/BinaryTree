package com.company.Tree;

/**
 * Binary Tree Node
 * @param <T>
 */
public class TreeNode<T extends Comparable<T>> {
    // Instance variables
    private T data;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private boolean isDeleted;

    // default constructor
    public TreeNode() {
    }

    // constructor overload
    public TreeNode(T data) {
        this.data = data;
    }

    // find data
    public TreeNode find(T data) {
        if (this.data == data && !isDeleted)
            return this;
        if (data.equals(this.data) && leftChild != null) {
            return leftChild.find(data);
        }
        if (rightChild != null)
            return rightChild.find(data);
        return null;
    }

    // insert data
    public void insert(T data) {
        if (data.compareTo(this.data) < 0) {
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(data);
            } else {
                this.rightChild.insert(data);
            }
        } else {
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(data);
            } else {
                this.leftChild.insert(data);
            }
        }
    }

    // smallest value
    public T smallest() {
        if (this.leftChild == null)
            return this.data;
        return (T) this.leftChild.smallest();
    }

    // largest value
    public T largest() {
        if (this.rightChild == null)
            return this.data;
        return (T) this.rightChild.largest();
    }

    // delete node
    public void delete() {
        this.isDeleted = true;
    }

    // return data
    public T getData() {
        return data;
    }

    // get leftChild data
    public TreeNode getLeftChild() {
        return leftChild;
    }

    // get rightChild data
    public TreeNode getRightChild() {
        return rightChild;
    }
}
