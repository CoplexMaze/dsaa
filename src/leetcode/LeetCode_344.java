package leetcode;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 */
public class LeetCode_344 {
    public static void main(String[] args) {
        char[] arr = new char[] {'h', 'e', 'l', 'l', 'o'};
        System.out.println(arr);
        reverseString(arr);
        System.out.println(arr);
    }

    public static void reverseString(char[] s) {
        int head = 0, tail = s.length - 1;
        char temp;
        while (tail > head) {
            temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;
            tail--;
            head++;
        }
    }
}
