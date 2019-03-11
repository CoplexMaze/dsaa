package dsaa.linear_list;

import java.util.List;

public class LinkList<T> {
    private LinkNode<T> head;

    public LinkList() {
        head = null;
    }

    public LinkList(List<T> arr) {
        int len = arr.size();
        for (int i = len - 1; i >= 0; i--) {
            head = new LinkNode<T>(arr.get(i), head);
        }
    }

    public LinkList(T[] arr) {
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            head = new LinkNode<T>(arr[i], head);
        }
    }

    public void connect(LinkList<T> t) {
        LinkNode<T> h = head;
        for (; h.next != null; h = h.next);
        h.next = t.getHead();
    }

    public LinkNode<T> getHead() {
        return head;
    }

    public void setHead(LinkNode<T> head) {
        this.head = head;
    }
}
