package dsaa;

public class BinaryTreeNode<T> {
    T val;
    BinaryTreeNode leftNode;
    BinaryTreeNode rightNode;

    BinaryTreeNode() {
        val = null;
        leftNode = rightNode = null;
    }

    BinaryTreeNode(T v) {
        val = v;
        leftNode = rightNode = null;
    }

    BinaryTreeNode(T v, BinaryTreeNode l, BinaryTreeNode r) {
        val = v;
        leftNode = l;
        rightNode = r;
    }
}
