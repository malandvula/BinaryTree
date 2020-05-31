package com.company.HWBinaryTree;

/**
 * TreeNode representing what is hel
 * @param <E>
 */
public class TreeNode<E extends Comparable<E>> implements Position{
    // Instance variables
    private E element;
    private TreeNode<E> previousNode;
    private TreeNode<E> nextNode;
    private boolean isDeleted;

    // default constructor
    public TreeNode(){}

    // constructor overload
    public TreeNode(E element){
        this.element = element;
    }

    public TreeNode<E> getPreviousNode(){
        return previousNode;
    }

    public TreeNode<E> getNextNode(){
        return nextNode;
    }

    @Override
    public Object getElement() {
        return element;
    }

    // insert data
    public boolean insert(E element){
        if (element.compareTo(this.element) < 0){
            if (this.previousNode == null) {
                this.previousNode = new TreeNode(element);
                return true;
            }else{
                this.previousNode.insert(element);
            }
        }else{
            if (this.nextNode == null) {
                this.nextNode = new TreeNode(element);
                return true;
            }else{
                this.nextNode.insert(element);
            }
        }
        return false;
    }

    public boolean find(E element){
        if(this.element == element && !isDeleted)
            return true;
        if (element.equals(this.element) && this.getPreviousNode() != null){
            return previousNode.find(element);
        }
        if (getNextNode() != null)
            return nextNode.find(element);
        return false;
    }

    // find data return node
    public TreeNode find2(E element){
        if (this.element == element && !isDeleted)
            return this;
        if (element.equals(this.element) && getPreviousNode() != null){
            return getNextNode().find2(element);
        }
        if (getNextNode() != null)
            return getPreviousNode().find2(element);
        return null;
    }

    // delete node
    public void delete(){
        this.isDeleted = true;
    }

    // get deleted
    public boolean isDeleted(){
        return isDeleted;
    }

}
