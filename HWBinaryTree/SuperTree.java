package com.company.HWBinaryTree;

public interface SuperTree<E> extends Iterable<E> {
    Position<E> rootElement();
    Position<E> parentElement(Position<E> p) throws IllegalArgumentException;
    Iterable<Position<E>> childrenElements(Position<E> p) throws IllegalArgumentException;
    int numChildrenElements(Position<E> p) throws IllegalArgumentException;
    boolean isRootEelement(Position<E> p) throws IllegalArgumentException;
    int sizeOfTree();
    boolean isInternalNode(Position<E> p) throws IllegalArgumentException;
    boolean isExternalNode(Position<E> p) throws IllegalArgumentException;
    boolean insertElement(E element); //return true if insert is successful
    boolean deleteElement(E element); //returns true if delete is successful
    boolean searchElement(E element); //return true if element is found in the tree
    void clearElements(); //Will remove all elements from the tree
    void positionsPreorderElements(); //Print the tree elements
    void positionsPostorderElements(); //Print the tree elements
    void positionInorderElements(); //Print the tree elements
}
