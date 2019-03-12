package leetcode;

import dsaa.linear_list.LinkList;
import dsaa.linear_list.ListNode;

import java.util.Arrays;
import java.util.List;

public class LeetCode_237 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        LinkList<Integer> link = new LinkList<>(list);

        link.getHead().printLink();
        deleteNode(link.getHead().next);
        link.getHead().printLink();
    }

    /**
     * 删除链表中的节点
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     */

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode temp = node.next;
        node.next = temp.next;
        temp.next = null;
    }
}
