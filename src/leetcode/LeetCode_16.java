package leetcode;

import java.util.Arrays;

public class LeetCode_16 {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4, 1};
        System.out.println(threeSumClosest(nums, 1));
    }

    /**
     * 最接近的三数之和
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
     * 返回这三个数的和。假定每组输入只存在唯一答案。
     */

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 2) return -1;
        int res = nums[0] + nums[1] + nums[len-1];
        int temp;
        int l, r;
        for(int i = 0;i < len - 2;i++) {
            l = i + 1;
            r = len - 1;;
            while (l < r) {
                temp = nums[i] + nums[l] + nums[r];
                if (Math.abs(temp - target) < Math.abs(res - target))
                    res = temp;
                if (temp > target) r--;
                else if (temp < target) l++;
                else return temp;
            }
        }
        return res;
    }
}
