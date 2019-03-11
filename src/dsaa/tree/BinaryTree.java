package dsaa.tree;

import java.util.ArrayDeque;

public class BinaryTree<T> {
    protected BinaryTreeNode<T>  root;

    public BinaryTreeNode<T> findFatherNode(BinaryTreeNode<T> node) {
        ArrayDeque<BinaryTreeNode> adq = new ArrayDeque();
        BinaryTreeNode<T> temp = root;
        if (temp != null) adq.addLast(temp);
        while (!adq.isEmpty()) {
            temp =  adq.pop();
            if (temp.leftNode != null) {
                if (temp.leftNode == node) return temp;
                adq.addLast(temp.leftNode);
            }
            if (temp.rightNode != null) {
                if (temp.rightNode == node) return temp;
                adq.addLast(temp.rightNode);
            }
        }
        return null;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }
}
