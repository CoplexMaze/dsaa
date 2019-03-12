package leetcode;

public class LeetCode_14 {

    public static void main(String[] args) {
        String[] strs = {"acc", "aaa", "aaba"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 1) return strs[0];
        String res = "";
        for (int i = 0; i < len - 1; i++) {
            if (i == 0) res = commonStr(strs[i], strs[i+1]);
            else res = commonStr(res, strs[i+1]);
            if (res.equals("")) return "";
        }

        return res;
    }

    public static String commonStr(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int count = 0;
        for (int i = 0;i < len; i++) {
            if (a.charAt(i) == b.charAt(i)) count++;
            else break;
        }
        return a.substring(0, count);
    }
}
