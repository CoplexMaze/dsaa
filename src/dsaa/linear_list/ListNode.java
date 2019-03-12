package dsaa.linear_list;

public class ListNode<T> {
    public T val;
    public ListNode<T> next;

    public ListNode() {
        val = null;
        next = null;
    }

    public ListNode(T t) {
        val = t;
        next = null;
    }

    public ListNode(T t, ListNode listNode) {
        val = t;
        next = listNode;
    }

    public void printLink() {
        ListNode node = this;
        while(node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print(node.val + "\n");
    }
}
