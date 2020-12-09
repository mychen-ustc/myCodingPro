/**
 * // 57. 和为s的两个数字
 * // 难度：简单
 * // 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * //
 * // 示例 1：
 * // 输入：nums = [2,7,11,15], target = 9
 * // 输出：[2,7] 或者 [7,2]
 * //
 * // 示例 2：
 * // 输入：nums = [10,26,30,31,47,60], target = 40
 * // 输出：[10,30] 或者 [30,10]
 * //  
 * //
 * // 限制：
 * // 1 <= nums.length <= 10^5
 * // 1 <= nums[i] <= 10^6
 * //
 * // 思路：
 * // 1.暴力求解，逐对数字求和，时间复杂度 O(n^2)，空间复杂度O(1)
 * // 2.二分法，对每个数字num，二分查找求sum-num
 * // 3.用HashMap存储已扫描数字，查找sum-num是否在hashmap中
 * // 4.双指针，分别指向首尾，如果sum>target，则右指针左移，否则左指针右移。2个指针相遇时跳出循环。时间复杂度O(n)，空间复杂度O(1)
 */

package com.offer;

class Solution_57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];     // 找到满足条件的一对数字
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (nums[left] + nums[right] < target) {     // 和比target小，左指针右移
                left++;
            } else {    // 和比target小，右指针左移
                right--;
            }
        }
        return new int[]{};
    }
}

public class _57_twoSum {
    public static void main(String[] args) {
        // [2,7,11,15]
        // 9
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution_57 solution = new Solution_57();
        int[] ans = solution.twoSum(nums, target);
        for (int num : ans) {
            System.out.println(num);
        }
    }
}
