package dsaa.tree;

public class BinaryTreeNode<T>{
    T val;
    BinaryTreeNode<T> leftNode;
    BinaryTreeNode<T> rightNode;

    BinaryTreeNode() {
        val = null;
        leftNode = rightNode = null;
    }

    BinaryTreeNode(T v) {
        val = v;
        leftNode = rightNode = null;
    }

    BinaryTreeNode(T v, BinaryTreeNode<T> l, BinaryTreeNode<T> r) {
        val = v;
        leftNode = l;
        rightNode = r;
    }
}
