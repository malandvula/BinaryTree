package com.company.Tree;

public class BinaryTree<T extends Comparable<T>> implements IBinaryTree<T> { // https://github.com/jnethery/CS2/blob/master/Generic%20Binary%20Search%20Tree/GenericBST.java
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
            this.root = insert(this.root, data);
        }

    }

    // overload
    public void insert(T data, String key){
        if (root == null){
            root = new TreeNode(data, key);
        }else{
            root = insert(this.root, data, key);
        }
    }

    // override
    private TreeNode insert(TreeNode root, T data){
        // If root null add data
        if (root == null){
            return new TreeNode(data);
        }

        // If data searched  < current root node then traverse to left child
        else if (root.getData().compareTo(data) < 0){
            root.setLeftChild(insert(root.getLeftChild(), data));
        }

        // If data searched  < current root node then traverse to left child
        else if (root.getData().compareTo(data) > 0){
            root.setRightChild(insert(root.getRightChild(), data));
        }

        else{
            System.out.println("Duplicates not allowed");
        }

        return root;
    }

    // override
    private TreeNode insert(TreeNode root, T data, String key){
        // If root null add data
        if (root == null){
            return new TreeNode(data, key);
        }

        // If data searched  < current root node then traverse to left child
        else if (key.compareTo(root.getKey()) < 0){
            root.setLeftChild(insert(root.getLeftChild(), data, key));
        }

        // If data searched  < current root node then traverse to left child
        else if (key.compareTo(root.getKey()) > 0){
            root.setRightChild(insert(root.getRightChild(), data, key));
        }

        else{
            System.out.println("Duplicates not allowed");
        }

        return root;
    }

    // isEmpty
    public boolean isEmpty(){
        if(root == null)
            return true;
        return false;
    }

    @Override // find data
    public TreeNode find(T data) {
        if (root != null)
            return find(root, data);
        else
        return null;
//        return find(root, data)
    }

    //Overload find recursive helper
    private TreeNode find(TreeNode root, T data){
        // If root null add data
        if (root == null){
            return null;
        }

        // If data searched  < current root node then traverse to left child
        else if (data.compareTo((T) root.getData()) < 0){
            return find(root.getLeftChild(), data);
        }

        // If data searched  < current root node then traverse to left child
        else if (data.compareTo((T) root.getData()) > 0){
            return find(root.getRightChild(), data);
        }
        return root;
    }

   // find key - overload
    public TreeNode find(String key) {
        if (root != null)
            return find(root, key);
        else
            return null;
    }

    //Overload find recursive helper
    private TreeNode find(TreeNode root, String key){
        // If root null add data
        if (root == null){
            return null;
        }

        // If data searched  < current root node then traverse to left child
        else if (key.compareTo(root.getKey()) < 0){
            return find(root.getLeftChild(), key);
        }

        // If data searched  < current root node then traverse to left child
        else if (key.compareTo(root.getKey()) > 0){
            return find(root.getRightChild(), key);
        }
        return root;
    }

    // return node data
    public T getTreeNodeData(){
        return (T) root.getData();
    }

    @Override // delete node from tree
    public void delete(T data){
        TreeNode toDel = find(data);
        toDel.delete();

//        if (!find(data))
//            root.delete();
    }

    // overload
    public void delete(String key){
        TreeNode toDel = find(key);
        toDel.delete();
    }
    /*
    Below is code to actually delete the node from BST
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

    // String override
    public String toString(){
        return root.getData().toString();
    }
}
