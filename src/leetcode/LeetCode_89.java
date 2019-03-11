package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_89 {
    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }

    /**
     * 格雷编码
     * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
     * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
     * 对于给定的 n，其格雷编码序列并不唯一。2:[0,1,3,2] || [0,2,3,1]
     * 我们定义格雷编码序列必须以 0 开头。
     *      给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
     *      因此，当 n = 0 时，其格雷编码序列为 [0]。
     *      关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i/2);
     * @param n
     * @return
     */
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        long len = 1 << n;
        for (int i = 0; i < len; i++) {
            res.add(i ^ (i/2));
        }
        return res;
    }
}
