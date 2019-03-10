package dsaa;

import java.util.ArrayDeque;

public class BinaryTreeOrder {
    /**
     * 二叉树结构：
     *              1
     *             / \
     *            2   3
     *           / \   \
     *          4  5    6
     * @param args
     */
    public static void main(String[] args) {
        BinaryTreeNode tn4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode tn5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode tn6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode tn2 = new BinaryTreeNode<Integer>(2, tn4, tn5);
        BinaryTreeNode tn3 = new BinaryTreeNode<Integer>(3, null, tn6);
        BinaryTreeNode tn1 = new BinaryTreeNode<Integer>(1, tn2, tn3);

        System.out.print("非递归前序：");
        preOrderNotRecusion(tn1);
        System.out.println();

        System.out.print("递归前序： ");
        preOrderRecusion(tn1);
        System.out.println();

        System.out.print("非递归中序：");
        inOrderNotRecsion(tn1);
        System.out.println();

        System.out.print("递归中序： ");
        inOrderRecusion(tn1);
        System.out.println();

        System.out.print("非递归后序：");
        postOrderNotRecusion(tn1);
        System.out.println();

        System.out.print("递归后序： ");
        postOrderRecusion(tn1);
        System.out.println();
    }

    /**
     * 非递归前序遍历二叉树
     * @param r 根结点
     */
    public static void preOrderNotRecusion(BinaryTreeNode r) {
        ArrayDeque adq = new ArrayDeque<BinaryTreeNode>();
        while (!adq.isEmpty() || r != null) {
            if (r != null) {
                System.out.print(r.val + " ");
                if (r.rightNode != null) adq.addLast(r.rightNode);
                r = r.leftNode;
            } else {
                r = (BinaryTreeNode) adq.peekLast();
                adq.removeLast();
            }
        }
    }

    public static void  preOrderRecusion(BinaryTreeNode r) {
        System.out.print(r.val + " ");
        if (r.leftNode != null) preOrderRecusion(r.leftNode);
        if (r.rightNode != null) preOrderRecusion(r.rightNode);
    }

    /**
     * 非中序递归中序遍历二叉树
     * @param r
     */
    public static void inOrderNotRecsion(BinaryTreeNode r) {

    }

    /**
     * 递归中序遍历二叉树
     * @param r 根结点
     */
    public static void inOrderRecusion(BinaryTreeNode r) {

        if (r.leftNode != null) inOrderRecusion(r.leftNode);
        System.out.print(r.val + " ");
        if (r.rightNode != null) inOrderRecusion(r.rightNode);
    }

    /**
     * 非递归后序遍历二叉树
     * @param r 根结点
     */
    public static void postOrderNotRecusion(BinaryTreeNode r) {

    }

    /**
     * 递归后序遍历二叉树
     * @param r 根结点
     */
    public static void postOrderRecusion(BinaryTreeNode r) {
        if (r.leftNode != null) postOrderRecusion(r.leftNode);
        if (r.rightNode != null) postOrderRecusion(r.rightNode);
        System.out.print(r.val + " ");
    }
}
