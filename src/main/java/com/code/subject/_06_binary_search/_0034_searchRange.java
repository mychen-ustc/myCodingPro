/**
 * // 34. 在排序数组中查找元素的第一个和最后一个位置
 * // 难度：中等
 * //
 * // 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * //
 * // 如果数组中不存在目标值 target，返回 [-1, -1]。
 * //
 * // 进阶：
 * //
 * // 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * //
 * // 示例 1：
 * //
 * // 输入：nums = [5,7,7,8,8,10], target = 8
 * // 输出：[3,4]
 * // 示例 2：
 * //
 * // 输入：nums = [5,7,7,8,8,10], target = 6
 * // 输出：[-1,-1]
 * // 示例 3：
 * //
 * // 输入：nums = [], target = 0
 * // 输出：[-1,-1]
 * //
 * // 提示：
 * //
 * // 0 <= nums.length <= 105
 * // -109 <= nums[i] <= 109
 * // nums 是一个非递减数组
 * // -109 <= target <= 109
 */

package com.code.subject._06_binary_search;

class Solution_0034 {
    public int[] searchRange(int[] nums, int target) {
        int leftBound = left_bound(nums, target);
        int rightBound = right_bound(nums, target);

        return new int[]{leftBound, rightBound};
    }

    // 寻找区间左端点
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;     // 已找到第一个数字，或者左侧数字小于target
                }
                right = mid - 1;    // 即使找到target，也要继续往左侧搜索
            } else if (nums[mid] > target) {  // 一直找到第一个大于等于target的数，即使相等，还会一直往左侧搜索
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 寻找区间右端点
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid;     // 已找到数组尾部，或者右侧数字大于target
                }
                left = mid + 1;    // 即使找到target，也要继续往右侧搜索
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

public class _0034_searchRange {
    public static void main(String[] args) {
        int[] nums = {1, 5, 7, 7, 7, 8, 8, 8, 8, 8, 9, 10};
        int target = 11;
        Solution_0034 solution = new Solution_0034();
        int[] range = solution.searchRange(nums, target);
        System.out.printf("[%d, %d]", range[0], range[1]);
    }
}
