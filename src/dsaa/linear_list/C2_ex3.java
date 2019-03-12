/**
 * 给定一个不带头结点的单链表，写出将链表倒置的算法。
 */
package dsaa.linear_list;

public class C2_ex3 {
    public static void main(String[] args) {
        ListNode n4 = new ListNode<String>("n4");
        ListNode n3 = new ListNode<String>("n3", n4);
        ListNode n2 = new ListNode<String>("n2", n3);
        ListNode n1 = new ListNode<String>("n1", n2);
        ListNode n0 = new ListNode<String>("n0", n1);

        n0.printLink();

        inversion(n0);

        n0.printLink();
        n0.printLink();

    }

    public static ListNode inversion(ListNode s) {
        if (s == null) return null;
        if (s.next == null) return s;
        ListNode n1 = s, n2 = s.next, n3 = s.next.next;
        while (n3 != null) {
            n2.next = n1;
            n1 = n2;
            n2 = n3;
            n3 = n3.next;
        }
        s.next = null;
        n2.next = n1;
        return n2;
    }
}
