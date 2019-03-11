package dsaa.tree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *二叉搜索树
 */
public class BinarySearchTree extends BinaryTree<Integer> {

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(List<Integer> list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.add(new BinaryTreeNode<Integer>((Integer) it.next()));
        }
    }

    public void add(BinaryTreeNode<Integer> tn) {
        if (root == null) root = tn;
        else {
            BinaryTreeNode<Integer> tmp = root;
            while (tmp != null) {
                if (tn.val < tmp.val) {
                    if (tmp.leftNode == null) {
                        tmp.leftNode = tn;
                        return;
                    } else tmp = tmp.leftNode;
                } else {
                    if (tmp.rightNode == null) {
                        tmp.rightNode = tn;
                        return;
                    } else tmp = tmp.rightNode;
                }
            }
        }
    }

    public boolean contain (BinaryTreeNode<Integer> tn) {
        if (root == null) return false;
        else {
            BinaryTreeNode<Integer> tmp = root;
            while (tmp != null) {
                if (tn == tmp) return true;
                if (tn.val < tmp.val) {
                    if (tmp.leftNode == null) return false;
                    else tmp = tmp.leftNode;
                } else {
                    if (tmp.rightNode == null) return false;
                    else tmp = tmp.rightNode;
                }
            }
            return false;
        }
    }

    /**
     * 合并删除二叉搜索树中的结点
     * @param tn
     */
    public void deleteByMerging(BinaryTreeNode<Integer> tn) {
        if (tn == null) return;
        BinaryTreeNode<Integer> fatherNode = findFatherNode(tn);
        if (tn.leftNode != null) {
            BinaryTreeNode<Integer> ln = tn.leftNode;
            for (; ln.rightNode != null; ln = ln.rightNode);
            ln.rightNode = tn.rightNode;
            if (fatherNode != null) {
                if (fatherNode.val <= tn.val) fatherNode.rightNode = tn.leftNode;
                else fatherNode.leftNode = tn.leftNode;
            } else {
                root = tn.leftNode;
            }
        } else {
            if (fatherNode != null) {
                if (fatherNode.val <= tn.val) fatherNode.rightNode = tn.rightNode;
                else fatherNode.leftNode = tn.rightNode;
            } else {
                root = tn.rightNode;
            }
        }
        tn.leftNode = tn.rightNode = null;
    }

    /**
     * 复制删除二叉搜索树中的结点
     * @param tn
     */
    public void deleteByCopying(BinaryTreeNode<Integer> tn) {

    }

    public BinaryTreeNode<Integer> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<Integer> root) {
        this.root = root;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 4);
        BinarySearchTree bst = new BinarySearchTree(list);
        BinaryTreeOrder bto = new BinaryTreeOrder();

        BinaryTreeNode<Integer> temp = new BinaryTreeNode<Integer>(3);
        System.out.println(bst.contain(temp));
        bto.inOrderRecusion(bst.root);
        bst.add(temp);
        System.out.println(bst.contain(temp));
        bto.inOrderRecusion(bst.root);
        System.out.println("-------------------");

        bst.deleteByMerging(bst.root);
        bto.inOrderRecusion(bst.root);
    }
}
