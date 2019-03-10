import java.util.ArrayDeque;

public class Test {
    public static void main(String[] args) {
        ArrayDeque a = new ArrayDeque<Integer>();
        a.addLast(1);
        a.addLast(2);

        System.out.println(a.peekLast());
        a.removeLast();
        System.out.println(a.peekLast());
    }
}
