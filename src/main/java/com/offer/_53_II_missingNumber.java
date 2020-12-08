/**
 * // 53 - II. 0～n-1中缺失的数字
 * // 难度：简单
 * // 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * //
 * // 示例 1:
 * // 输入: [0,1,3]
 * // 输出: 2
 * //
 * // 示例 2:
 * // 输入: [0,1,2,3,4,5,6,7,9]
 * // 输出: 8
 * //
 * // 限制：
 * // 1 <= 数组长度 <= 10000
 */

package com.offer;

class Solution_53_II {
    public int missingNumber(int[] nums) {
        // 缺失数字的左边数值严格等于序号，右边的数值不等于序号
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int k = left + (right - left) / 2;
            if (nums[k] == k) {
                left = k + 1;
            } else {
                right = k - 1;
            }
        }
        return left;
    }
}

public class _53_II_missingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        Solution_53_II solution = new Solution_53_II();
        int ans = solution.missingNumber(nums);
        System.out.println(ans);
    }
}
