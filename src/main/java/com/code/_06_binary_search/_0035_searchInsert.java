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
 */

package com.code._06_binary_search;

class Solution_0035 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;  // 左右指针
        int index = -1;
        while (index == -1) {
            int mid = (left + right) / 2;   // 中间指针
            if (nums[mid] == target) {
                index = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
                if (mid == 0 || nums[mid - 1] < target)
                    index = mid;
            } else {
                left = mid + 1;
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    index = mid + 1;
                }
            }
        }
        return index;
    }
}

public class _0035_searchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 1;
        Solution_0035 solution = new Solution_0035();
        int res = solution.searchInsert(nums, target);
        System.out.println(res);
    }
}
