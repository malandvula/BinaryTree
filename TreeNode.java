package com.company.Tree;

import com.company.employee.Employee;

public class TreeNode<T extends Comparable<T>> { // https://github.com/dashsaurabh/data-structures/tree/master/src/tree
    // Instance variables
    private T data;
    private String key;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private boolean isDeleted;

    // default constructor
    public TreeNode(){}

    // constructor overload
    public TreeNode(T data){
        this.data = data;
    }

    public TreeNode(T data, String key){
        this.data = data;
        this.key = key;
    }

    // find data
    public TreeNode find(T data){
        if (this.data == data && !isDeleted)
            return this;
        if (data.equals(this.data) && leftChild != null){
            return leftChild.find(data);
        }
        if (rightChild != null)
            return rightChild.find(data);
        return null;
    }

    // find key
    public TreeNode find(String key){
        if (this.key == key && !isDeleted)
            return this;
        if (key.equals(this.key) && leftChild != null){
            return leftChild.find(key);
        }
        if (rightChild != null)
            return rightChild.find(key);
        return null;
    }

    // insert data
    public void insert(T data){
        if (data.compareTo(this.data) < 0){
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(data);
            }else{
                this.rightChild.insert(data);
            }
        }else{
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(data);
            }else{
                this.leftChild.insert(data);
            }
        }
    }

    // insert data overload
    public void insert(T data, String key){
        if (data.compareTo(this.data) < 0 || key.compareTo(this.key) < 0){
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(data);
            }else{
                this.rightChild.insert(data);
            }
        }else{
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(data);
            }else{
                this.leftChild.insert(data);
            }
        }
    }

    // smallest value
    public T smallest(){
        if (this.leftChild == null)
            return this.data;
        return (T) this.leftChild.smallest();
    }

    // largest value
    public T largest(){
        if (this.rightChild == null)
            return this.data;
        return (T) this.rightChild.largest();
    }

    // get key
    public String getKey(){
        return key;
    }

    // delete node
    public void delete(){
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

    // set leftChild data
    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    // get rightChild data
    public TreeNode getRightChild() {
        return rightChild;
    }

    // set rightChild data
    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    // Override toString
    public String toString(){
        return "Data {" + getData() + "}";
    }
}
