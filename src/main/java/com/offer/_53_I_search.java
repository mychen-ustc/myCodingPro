/**
 * // 53 - I. 在排序数组中查找数字 I
 * // 难度：简单
 * // 统计一个数字在排序数组中出现的次数。
 * //
 * // 示例 1:
 * // 输入: nums = [5,7,7,8,8,10], target = 8
 * // 输出: 2
 * //
 * // 示例 2:
 * // 输入: nums = [5,7,7,8,8,10], target = 6
 * // 输出: 0
 * //
 * // 限制：
 * // 0 <= 数组长度 <= 50000
 * //
 * // 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-
 */

package com.offer;

class Solution_53_I {
    public int search(int[] nums, int target) {
        // 用2个指针，分别找到目标数字第一个和最后一个出现的位置
        int left = findLeftBound(nums, target);
        int right = findRightBound(nums, target);

        return (left == -1 && right == -1) ? 0 : (right - left + 1);
    }

    // 找到第一个等于目标数字的位置
    int findLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target)
                    return mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 找到最后一个等于目标数字的位置
    int findRightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target)
                    return mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

public class _53_I_search {
    public static void main(String[] args) {
        int[] nums = {5, 7, 8, 8, 10};
        int target = 9;
        Solution_53_I solution = new Solution_53_I();
        int ans = solution.search(nums, target);
        System.out.println(ans);
    }
}
