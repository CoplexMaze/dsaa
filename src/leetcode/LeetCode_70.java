package leetcode;

public class LeetCode_70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(7));
        System.out.println(climbStairsRecusion(7));
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * @param n
     * @return
     */
    public static int climbStairsRecusion(int n) {
        if (n == 1) {
            return 1;
        } else if (n==2) {
            return 2;
        } else {
            return climbStairsRecusion(n - 1) + climbStairsRecusion(n - 2);
        }
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int a = 1, b = 2;
            for (int i = 0; i < n - 2; i++) {
                b += a;
                a = b - a;
            }
            return b;
        }
    }
}
