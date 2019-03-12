package leetcode;

import dsaa.linear_list.LinkList;
import dsaa.linear_list.ListNode;

import java.util.Arrays;
import java.util.List;

public class LeetCode_148 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 1, 4);
        LinkList<Integer> link = new LinkList<>(list);

        link.getHead().printLink();
        sortList(link.getHead()).printLink();
    }

    /**
     * 排序链表
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     */
    public static ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    public static ListNode mergeSort(ListNode head) {
        if (head.next == null) return head;
        ListNode p = head,q = head,pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        return merge(l, r);
    }

    public static ListNode merge(ListNode l, ListNode r) {
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        while (l != null && r != null) {
            if ((Integer) l.val <= (Integer) r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }
        if (r != null) cur.next = r;
        if (l != null) cur.next = l;
        return temp.next;
    }
}
