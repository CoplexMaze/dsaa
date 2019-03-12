package leetcode;
import dsaa.linear_list.LinkList;
import dsaa.linear_list.ListNode;

import java.util.Arrays;
import java.util.List;


public class LeetCode_160 {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
        LinkList<Integer> list1 = new LinkList(l1);
        List<Integer> l2 = Arrays.asList(1,3,5);
        LinkList<Integer> list2 = new LinkList(l2);

        List<Integer> t = Arrays.asList(6,1,7);
        LinkList<Integer> temp = new LinkList(t);
        list1.connect(temp);
        list2.connect(temp);

        list1.getHead().printLink();
        list2.getHead().printLink();
        getIntersectionNode(list1.getHead(), list2.getHead()).printLink();
    }

    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nA = headA, nB = headB;
        int count = 0;
        while (nA != nB) {
            if (nA.next == null) {
                if (count == 2) return null;
                nA = headB;
                count++;
            } else nA = nA.next;
            if (nB.next == null) {
                if (count == 2) return null;
                nB = headA;
                count++;
            } else nB = nB.next;
        }
        return nA;
    }
}
