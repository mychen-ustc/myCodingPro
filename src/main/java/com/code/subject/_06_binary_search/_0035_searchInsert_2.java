/**
 * // 35. 搜索插入位置
 * // 难度：简单
 * // 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * //
 * // 你可以假设数组中无重复元素。
 * //
 * // 示例 1:
 * //
 * // 输入: [1,3,5,6], 5
 * // 输出: 2
 * // 示例 2:
 * //
 * // 输入: [1,3,5,6], 2
 * // 输出: 1
 * // 示例 3:
 * //
 * // 输入: [1,3,5,6], 7
 * // 输出: 4
 * // 示例 4:
 * //
 * // 输入: [1,3,5,6], 0
 * // 输出: 0
 *
 * // 【备注】相对于
 */

package com.code.subject._06_binary_search;

class Solution_0035_2 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = nums.length;  // 将答案初始化为数组长度:寻找第一个大于等于target的数字，如果不存在，则刚好是要插入的位置
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

public class _0035_searchInsert_2 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        Solution_0035_2 solution = new Solution_0035_2();
        int res = solution.searchInsert(nums, target);
        System.out.println(res);
    }
}
