/**
 * 给定一个不带头结点的单链表，写出将链表倒置的算法。
 */
package dsaa.linear_list;

public class C2_ex3 {
    public static void main(String[] args) {
        LinkNode n4 = new LinkNode<String>("n4");
        LinkNode n3 = new LinkNode<String>("n3", n4);
        LinkNode n2 = new LinkNode<String>("n2", n3);
        LinkNode n1 = new LinkNode<String>("n1", n2);
        LinkNode n0 = new LinkNode<String>("n0", n1);

        n0.printLink();

        inversion(n0);

        n0.printLink();
        n0.printLink();

    }

    public static LinkNode inversion(LinkNode s) {
        if (s == null) return null;
        if (s.next == null) return s;
        LinkNode n1 = s, n2 = s.next, n3 = s.next.next;
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
