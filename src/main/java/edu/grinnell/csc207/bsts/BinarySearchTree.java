package edu.grinnell.csc207.bsts;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary tree that satisifies the binary search tree invariant.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    ///// From the reading

    /**
     * A node of the binary search tree.
     */
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        /**
         * @param value the value of the node
         * @param left the left child of the node
         * @param right the right child of the node
         */
        Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        /**
         * @param value the value of the node
         */
        Node(T value) {
            this(value, null, null);
        }
    }

    private Node<T> root;

    /**
     * Constructs a new empty binary search tree.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * @param node the root of the tree
     * @return the number of elements in the specified tree
     */
    private int sizeH(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeH(node.left) + sizeH(node.right);
        }
    }

    /**
     * @return the number of elements in this tree
     */
    public int size() {
        return sizeH(root);
    }

    /**
     * @param <T> the carrier type
     * @param v the value to add to the tree
     * @param cur the node within a tree that we eventually add v to
     * @return the node/tree now with v attached
     */
    private Node<T> insertH(T v, Node<T> cur) {
        if (cur == null) {
            return new Node<>(v);
        } else {
            if (v.compareTo(cur.value) < 0) {
                cur.left = insertH(v, cur.left);
            } else {
                cur.right = insertH(v, cur.right);
            }
            return cur;
        }
    }

    /**
     * @param value the value to add to the tree
     */
    public void insert(T value) {
        root = insertH(value, root);
    }

    ///// Part 1: Contains
   
    // Description: Contains should start at the top value to see if it equals the goal value.
    // If not, it makes a recursive call to the left side, then to the right side,
    // to see if the value exists in any of those locations.

    /**
     * @param <T> the carrier type
     * @param v the value to find
     * @param cur the node within a tree that may or may not contain v
     * @return true iff this tree contains <code>v</code>
     */
    public boolean containsH(T v, Node<T> cur) {
        if (cur == null) {
            return false;
        } else if (cur.value == v) {
            return true; 
        } else {
            return (containsH(v, cur.left) || containsH(v, cur.right));
        }
    }

    /**
     * @param v the value to find
     * @return true iff this tree contains <code>v</code>
     */
    public boolean contains(T v) {
        return containsH(v, root);
    }

    ///// Part 2: Ordered Traversals
    /// 
    /// The in-order traversal would produce an in-order result.
    /// 
    

    /**
     * @param <T> the carrier type
     * @param buf the buffer we use to append values in the tree
     * @param node the node/tree that contains the values
     */
    public void stringHelper(StringBuffer buf, Node<T> node) {
        if (node == null) {
            return;
        }
        stringHelper(buf, node.left);
        buf.append(node.value);
        buf.append(", ");
        stringHelper(buf, node.right);
    }


    /**
     * @return the (linearized) string representation of this BST
     */
    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer("[");
        stringHelper(buf, root);
        buf.append("]");
        return buf.toString();
    }

    /**
     * @param <T> the carrier type
     * @param buf the list we use to store values in the tree linearly
     * @param node the node/tree that contains the values
     */    
    public void listHelper(List<T> lst, Node<T> node) {
        if (node == null) {
            return;
        }
        listHelper(lst, node.left);
        lst.add(node.value);
        listHelper(lst, node.right);
    }


    /**
     * @return a list contains the elements of this BST in-order.
     */
    public List<T> toList() {
        List<T> lst = new ArrayList<>(this.size());
        listHelper(lst, root);
        return lst;
    }

    ///// Part 3: BST Sorting

    /**
     * @param <T> the carrier type of the lists
     * @param lst the list to sort
     * @return a copy of <code>lst</code> but sorted
     * @implSpec <code>sort</code> runs in ___ time if the tree remains balanced. 
     */
    public static <T extends Comparable<? super T>> List<T> sort(List<T> lst) {
        BinarySearchTree<T> tree = new BinarySearchTree<T>();
        for (int i = 0; i < lst.size(); i++) {
            tree.insert(lst.get(i));
        }
        return tree.toList();
    }

    ///// Part 4: Deletion
  
    /*
     * The three cases of deletion are:
     * 1. (TODO: fill me in!)
     * 2. (TODO: fill me in!)
     * 3. (TOOD: fill me in!)
     */

    /**
     * Modifies the tree by deleting the first occurrence of <code>value</code> found
     * in the tree.
     *
     * @param value the value to delete
     */
    public void delete(T value) {
        throw new UnsupportedOperationException();
    }
}
