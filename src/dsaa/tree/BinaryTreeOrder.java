package dsaa.tree;

import dsaa.tree.BinaryTreeNode;

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

        BinaryTreeOrder bto = new BinaryTreeOrder();

        System.out.print("非递归前序：");
        bto.preOrderNotRecusion(tn1);
        System.out.println();

        System.out.print("递归前序： ");
        bto.preOrderRecusion(tn1);
        System.out.println();

        System.out.print("非递归中序：");
        bto.inOrderNotRecsion(tn1);
        System.out.println();

        System.out.print("递归中序： ");
        bto.inOrderRecusion(tn1);
        System.out.println();

        System.out.print("非递归后序：");
        bto.postOrderNotRecusion(tn1);
        System.out.println();

        System.out.print("递归后序： ");
        bto.postOrderRecusion(tn1);
        System.out.println();

        System.out.print("广度优先遍历： ");
        bto.levelOrder(tn1);
        System.out.println();
    }

    /**
     * 广度优先遍历二叉树
     * @param r
     */
    public void levelOrder(BinaryTreeNode r) {
        ArrayDeque<BinaryTreeNode> adq = new ArrayDeque();
        if (r != null) adq.addLast(r);
        while (!adq.isEmpty()) {
            r =  adq.pop();
            System.out.print(r.val + " ");
            if (r.leftNode != null) adq.addLast(r.leftNode);
            if (r.rightNode != null) adq.addLast(r.rightNode);
        }
        System.out.println();
    }

    /**
     * 非递归前序遍历二叉树
     * @param r 根结点
     */
    public void preOrderNotRecusion(BinaryTreeNode r) {
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
        System.out.println();
    }

    private void preRecusion(BinaryTreeNode r) {
        System.out.print(r.val + " ");
        if (r.leftNode != null) preRecusion(r.leftNode);
        if (r.rightNode != null) preRecusion(r.rightNode);
    }

    public void  preOrderRecusion(BinaryTreeNode r) {
        this.preRecusion(r);
        System.out.println();
    }

    /**
     * 非递归中序遍历二叉树
     * @param r
     */
    public void inOrderNotRecsion(BinaryTreeNode r) {
        ArrayDeque adq = new ArrayDeque<BinaryTreeNode>();
        while (!adq.isEmpty() || r != null) {
            if (r != null) {
                adq.addLast(r);
                r = r.leftNode;
            } else {
                r = (BinaryTreeNode) adq.peekLast();
                adq.removeLast();
                System.out.print(r.val + " ");
                r = r.rightNode;
            }
        }
        System.out.println();
    }

    /**
     * 递归中序遍历二叉树
     * @param r 根结点
     */
    private void inRecusion(BinaryTreeNode r) {
        if (r.leftNode != null) inRecusion(r.leftNode);
        System.out.print(r.val + " ");
        if (r.rightNode != null) inRecusion(r.rightNode);
    }
    public void inOrderRecusion(BinaryTreeNode r) {
        inRecusion(r);
        System.out.println();
    }

    /**
     * 非递归后序遍历二叉树
     * @param r 根结点
     */
    public void postOrderNotRecusion(BinaryTreeNode r) {
        ArrayDeque<BinaryTreeNode> adq = new ArrayDeque<>();
        BinaryTreeNode pre = null;
        while (r != null) {
            for (; r.leftNode != null; r = r.leftNode)
                adq.addLast(r);
            while (r != null && (r.rightNode == null || r.rightNode == pre)) {
                System.out.print(r.val + " ");
                pre = r;
                if (adq.isEmpty()) return;
                r = adq.peekLast();
                adq.removeLast();
            }
            adq.addLast(r);
            r = r.rightNode;
        }
        System.out.println();
    }

    /**
     * 递归后序遍历二叉树
     * @param r 根结点
     */
    private void postRecusion(BinaryTreeNode r) {
        if (r.leftNode != null) postRecusion(r.leftNode);
        if (r.rightNode != null) postRecusion(r.rightNode);
        System.out.print(r.val + " ");
    }
    public void postOrderRecusion(BinaryTreeNode r) {
        postRecusion(r);
        System.out.println();
    }
}
