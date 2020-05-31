package com.company.HWBinaryTree;

import java.util.Iterator;

public class BinarySearchTree<E extends Comparable> implements SuperTree<E>{
    private TreeNode root;

    @Override
    public Position<E> rootElement() {
        return root;
    }

    @Override
    public Position<E> parentElement(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Iterable<Position<E>> childrenElements(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public int numChildrenElements(Position<E> p) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public boolean isRootEelement(Position<E> p) throws IllegalArgumentException {
        return false;
    }

    @Override
    public int sizeOfTree() {
        return 0;
    }

    @Override
    public boolean isInternalNode(Position<E> p) throws IllegalArgumentException {
        return false;
    }

    @Override
    public boolean isExternalNode(Position<E> p) throws IllegalArgumentException {
        return false;
    }

    @Override
    public boolean insertElement(E element) {
        if (root == null){
            root = new TreeNode( element);
        }else{
            return root.insert((Comparable) element);
        }
        return false;
    }

    public TreeNode find(E element){
        if (root != null)
            return root.find2(element);
        return null;
    }

    @Override
    public boolean deleteElement(E element) {
        TreeNode toDel = find(element);
        toDel.delete();
        return toDel.isDeleted();
    }

    @Override
    public boolean searchElement(E element) {
        if (root != null)
            return root.find(element);
        return false;
    }

    @Override
    public void clearElements() {

    }

    @Override
    public void positionsPreorderElements() {
        preOrder((TreeNode) rootElement());
    }
    private void preOrder(TreeNode node){
        if(node == null)
            return;

        // print node data
        if (node.isDeleted() == false)
            System.out.println(node.getElement() + " ");

        // first recur on left child
        preOrder(node.getPreviousNode());

        // now recur on the right child
        inOrder(node.getNextNode());
    }

    @Override
    public void positionsPostorderElements() {
        postOrder((TreeNode) rootElement());
    }
    private void postOrder(TreeNode node){
        if(node == null)
            return;

        // first recur on left child
        postOrder(node.getPreviousNode());

        // now recur on the right child
        postOrder(node.getNextNode());

        // print node data
        if (node.isDeleted() == false)
            System.out.println(node.getElement() + " ");
    }

    @Override
    public void positionInorderElements() {
        inOrder((TreeNode) rootElement());
    }
    private void inOrder(TreeNode node){
        if(node == null)
            return;

        // first recur on left child
        inOrder(node.getPreviousNode());

        // print node data
        if (node.isDeleted() == false)
            System.out.println(node.getElement() + " ");

        // now recur on the right child
        inOrder(node.getNextNode());
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
