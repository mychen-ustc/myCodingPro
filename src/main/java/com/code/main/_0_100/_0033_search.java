/**
 * // 33. 搜索旋转排序数组
 * // 难度：中等
 * // 给你一个整数数组 nums ，和一个整数 target 。
 * //
 * // 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 * //
 * // 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * //  
 * // 示例 1：
 * // 输入：nums = [4,5,6,7,0,1,2], target = 0
 * // 输出：4
 * //
 * // 示例 2：
 * // 输入：nums = [4,5,6,7,0,1,2], target = 3
 * // 输出：-1
 * //
 * // 示例 3：
 * // 输入：nums = [1], target = 0
 * // 输出：-1
 * //
 * // 提示：
 * // 1 <= nums.length <= 5000
 * // -10^4 <= nums[i] <= 10^4
 * // nums 中的每个值都 独一无二
 * // nums 肯定会在某个点上旋转
 * // -10^4 <= target <= 10^4
 */

package com.code.main._0_100;

class Solution_0033 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;    // 边界条件
        if (len == 1) return nums[0] == target ? 0 : -1;    // 边界条件
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[0] <= nums[mid]) {     // mid左侧有序
                if (nums[0] <= target && target <= nums[mid]) { // 检查target是否在左侧有序区间内
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {    // mid右侧有序
                if (nums[mid] < target && target <= nums[right]) {  // 检查target是否在右侧有序区间内
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

public class _0033_search {
    public static void main(String[] args) {
        // [4,5,6,7,0,1,2] 0
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        Solution_0033 solution = new Solution_0033();
        int ans = solution.search(nums, target);
        System.out.println(ans);
    }
}
