package bst;

import java.util.LinkedList;
import java.util.List;

/**
 * A binary search tree (BST) is a sorted ADT that uses a binary
 * tree to keep all elements in sorted order.  If the tree is
 * balanced, performance is very good: O(n lg n) for most operations.
 * If unbalanced, it performs more like a linked list: O(n).
 *
 * @author Zach Tomaszewski, Anthony Christe
 */
public class BinarySearchTree<E extends Comparable<E>> {

  private BinaryTreeNode<E> root = null;
  private int size = 0;

  /** Creates an empty tree. */
  public BinarySearchTree() {
  }

  /** Adds the given item to this BST. */
  public void add(E item) {
    this.root = add(item, root);
    this.size++;
  }

  private BinaryTreeNode<E> add(E item, BinaryTreeNode<E> subtree) {
    if (subtree == null) {
      return new BinaryTreeNode<E>(item);
    }else {
      if (item.compareTo(subtree.getData()) <= 0) {
        subtree.setLeft(add(item, subtree.getLeft()));
      }else {
        subtree.setRight(add(item, subtree.getRight()));
      }
      return subtree;
    }
  }

  /** Returns the greatest value (in right-most node) of the given tree. */
  private E findMax(BinaryTreeNode<E> n) {
    if (n == null) {
      return null;
    }else if (n.getRight() == null) {
      //can't go right any more, so this is max value
      return n.getData();
    }else {
      return findMax(n.getRight());
    }
  }

  /**
   * Returns item from tree that is equivalent (according to compareTo)
   * to the given item.  If item is not in tree, returns null.
   */
  public E get(E item) {
    return get(item, this.root);
  }

  /** Finds it in the subtree rooted at the given node. */
  private E get(E item, BinaryTreeNode<E> node) {
    if (node == null) {
      return null;
    }else if (item.compareTo(node.getData()) < 0) {
      return get(item, node.getLeft());
    }else if (item.compareTo(node.getData()) > 0) {
      return get(item, node.getRight());
    }else {
      //found it!
      return node.getData();
    }
  }


  /**
   * Removes the first equivalent item found in the tree.
   * If item does not exist to be removed, throws IllegalArgumentException().
   */
  public void remove(E item) {
    this.root = remove(item, this.root);
  }

  private BinaryTreeNode<E> remove(E item, BinaryTreeNode<E> node) {
    if (node == null) {
      //didn't find item
      throw new IllegalArgumentException(item + " not found in tree.");
    }else if (item.compareTo(node.getData()) < 0) {
      //go to left, saving resulting changes made to left tree
      node.setLeft(remove(item, node.getLeft()));
      return node;
    }else if (item.compareTo(node.getData()) > 0) {
      //go to right, saving any resulting changes
      node.setRight(remove(item, node.getRight()));
      return node;
    }else {
      //found node to be removed!
      if (node.getLeft() == null && node.getRight() == null) {
        //leaf node
        return null;
      }else if (node.getRight() == null) {
        //has only a left child
        return node.getLeft();
      }else if (node.getLeft() == null) {
        //has only a right child
        return node.getRight();
      }else {
        //two children, so replace the contents of this node with max of left tree
        E max = findMax(node.getLeft());  //get max value
        node.setLeft(remove(max, node.getLeft())); //and remove its node from tree
        node.setData(max);
        return node;
      }
    }
  }


  /** Returns the number of elements currently in this BST. */
  public int size() {
    return this.size;
  }

  /** @return The list of elements in BST given a pre-order traversal */
  public List<E> getPreOrderList() {
    return getPreOrderList(this.root, new LinkedList<E>());
  }

  /** @return The list of elements in BST given an in-order traversal */
  public List<E> getInOrderList() {
    return getInOrderList(this.root, new LinkedList<E>());
  }

  /** @return The list of elements in BST given a post-order traversal */
  public List<E> getPostOrderList() {
    return getPostOrderList(this.root, new LinkedList<E>());
  }

  private List<E> getPreOrderList(BinaryTreeNode<E> node, List<E> list) {
    if(node == null) {
      return list;
    }

    list.add(node.getData());
    getPreOrderList(node.getLeft(), list);
    getPreOrderList(node.getRight(), list);

    return list;
  }

  private List<E> getInOrderList(BinaryTreeNode<E> node, List<E> list) {
    if(node == null) {
      return list;
    }


    getInOrderList(node.getLeft(), list);
    list.add(node.getData());
    getInOrderList(node.getRight(), list);

    return list;
  }

  private List<E> getPostOrderList(BinaryTreeNode<E> node, List<E> list) {
    if(node == null) {
      return list;
    }


    getPostOrderList(node.getLeft(), list);
    getPostOrderList(node.getRight(), list);
    list.add(node.getData());

    return list;
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
    bst.add(5);
    bst.add(2);
    bst.add(1);
    bst.add(3);
    bst.add(8);
    bst.add(15);
    bst.add(13);
    bst.add(12);
    bst.add(22);

    System.out.println(bst.getPreOrderList());
    System.out.println(bst.getInOrderList());
    System.out.println(bst.getPostOrderList());



  }
}