package leetcode;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 *     初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class LeetCode_88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        System.out.println(Arrays.toString(nums1));
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        while (p2 < n) {
            while (p1 < (m + p2) && nums1[p1] < nums2[p2])
                p1++;
            for (int i = m + p2; i > p1; i--) {
                nums1[i] = nums1[i-1];
            }
            nums1[p1] = nums2[p2];
            p2++;
        }
    }
}
