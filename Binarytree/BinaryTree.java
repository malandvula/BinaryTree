package com.company.Tree;

/**
 * Generic binary tree implementation
 * @param <T>
 */
public class BinaryTree<T extends Comparable<T>> implements IBinaryTree<T> {
    // Instance variables
    private TreeNode root;

    // smallest node
    public T smallest(){
        if (root != null)
            return (T) root.smallest();
        return null;
    }

    // largest node
    public T largest(){
        if (root != null)
            return (T) root.largest();
        return null;
    }

    // Inorder traversal
    public void inOrder(){
       inOrder(root);
    }
    private void inOrder(TreeNode node){
        if(node == null)
            return;

        // first recur on left child
        inOrder(node.getLeftChild());

        // print node data
        System.out.println(node.getData() + " ");

        // now recur on the right child
        inOrder(node.getRightChild());
    }

    // PreOrder traversal
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(TreeNode node){
        if(node == null)
            return;

        // print node data
        System.out.println(node.getData() + " ");

        // first recur on left child
        preOrder(node.getLeftChild());

        // now recur on the right child
        inOrder(node.getRightChild());

    }

    // PostOrder traversal
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(TreeNode node){
        if(node == null)
            return;

        // first recur on left child
        postOrder(node.getLeftChild());

        // now recur on the right child
        postOrder(node.getRightChild());

        // print node data
        System.out.println(node.getData() + " ");
    }

    @Override
    public void insert(T data) {
        if (root == null){
            root = new TreeNode(data);
        }else{
            root.insert(data);
        }
    }

    @Override
    public TreeNode find(T data) {
        if (root != null)
            return root.find(data);
        return null;
    }

    @Override
    public void delete(T data){
        TreeNode toDel = find(data);
        toDel.delete();
    }
    /*
    Below is code to actually delete the node
     */
//    public void delete(T data) {
//        TreeNode current = this.root;
//        TreeNode parent = this.root;
//        boolean isLeftChild = false;
//
//        // is there a value at current
//        if (current == null)
//            return;
//
//        // if there is data at current
//        while(current != null && current.getData() != data){
//            parent = current;
//
//            if(current.getData() == data){
//                current.getLeftChild();
//                isLeftChild = true;
//            }else{
//                current = current.getRightChild();
//                isLeftChild = false;
//            }
//        }
//
//        if (current == null)
//            return;
//
//        if (current.getLeftChild() == null && current.getRightChild() == null){
//            if(current == root){
//                root = null;
//            }else{
//                if(isLeftChild)
//                    parent.setLeftChild(null);
//                else
//                    parent.setRightChild(null);
//            }
//        }
//
//        else if (current.getRightChild() == null){
//            if (current == root){
//                root = current.getLeftChild();
//            }else if (isLeftChild) {
//                parent.setLeftChild(current.getLeftChild());
//            }else {
//                parent.setRightChild(current.getRightChild());
//            }
//        }
//
//        else if (current.getLeftChild() == null){
//            if (current == root){
//                root = current.getRightChild();
//            }else if (isLeftChild) {
//                parent.setLeftChild(current.getRightChild());
//            }else {
//                parent.setRightChild(current.getRightChild());
//            }
//        }
//    }
}
