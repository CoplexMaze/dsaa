package leetcode;
/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode_78 {
    public static void main(String[] args) {
        List<List<Integer>> list = subsets1(new int[] {1, 2, 3});
        System.out.println(list.toString());
    }

    /**
     * 位操作
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets1(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>(1<<len);
        for (int i = 0; i < 1<<len; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if((i & 1<<j) != 0) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }
        return result;
    }
}
