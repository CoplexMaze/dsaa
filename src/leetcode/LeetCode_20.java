package leetcode;

import java.util.ArrayDeque;

public class LeetCode_20 {
    public static void main(String[] args) {
        System.out.println(isValid("({[]}[])")); //true
    }

    /**
     * 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     *     左括号必须用相同类型的右括号闭合。
     *     左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */
    public static boolean isValid(String s) {
        if (s.equals("")) return true;
        ArrayDeque<Character> adq = new ArrayDeque<>();
        int len = s.length();
        char c, top;
        for (int i = 0;i < len;i++) {
            c = s.charAt(i);
            if (adq.isEmpty()) adq.addLast(c);
            else {
                top = adq.peekLast();
                int abs =  Math.abs(Integer.valueOf(c) - Integer.valueOf(top));
                if (abs <= 2 && abs > 0)
                    adq.removeLast();
                else adq.addLast(c);
            }
        }
        if (adq.isEmpty()) return true;
        else return false;
    }
}
