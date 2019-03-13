package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组
 */
public class LeetCode_15 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int left, right;
        int temp;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            left = i + 1;
            right = len - 1;
            while (left < right) {
                temp = nums[i] + nums[left] + nums[right];
                if (temp > 0) {
                    right--;
                } else if (temp < 0){
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[++left] == nums[left-1]);
                    while (left < right && nums[--right] == nums[right+1]);
                }
            }
        }
        return res;
    }
}
