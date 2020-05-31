package com.company.Tree;

public interface IBinaryTree<T> {
    // Binary tree methods to implement
    public void insert(T data); // insert data into the Tree
    public TreeNode find(T data); // find data in Tree
    public void delete(T data); // delete data from Tree
}
