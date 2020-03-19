package leetcode;
import java.util.Arrays;

public class LeetCode_1046 {
    public static void main(String args[]) {
        int[] stones = {3,7,8};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones.length < 1) return 0;
        if (1 == stones.length) return stones[0];
        int len = stones.length;
        Arrays.sort(stones);
        for (len--; len > 0; len--) {
            int diff = stones[len] - stones[len-1];
            if (1 == len) return diff;
            if (diff > 0) {
                int i = len - 1;
                for (; i > 0; i--) {
                    if (diff > stones[i-1]) {
                        stones[i] = diff;
                        break;
                    } else {
                        stones[i] = stones[i-1];
                    }
                }
                if (0 == i) stones[0] = diff;
            } else len--;
        }
        return stones[0];
    }
}