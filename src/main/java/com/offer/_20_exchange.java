/**
 * // 21. 调整数组顺序使奇数位于偶数前面
 * // 难度：简单
 * // 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * //
 * // 示例：
 * //
 * // 输入：nums = [1,2,3,4]
 * // 输出：[1,3,2,4]
 * // 注：[3,1,2,4] 也是正确的答案之一。
 * //
 * // 提示：
 * // 1 <= nums.length <= 50000
 * // 1 <= nums[i] <= 10000
 */

package com.offer;

class Solution_21 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) != 0) { // 左指针向右寻找偶数：用位运算判断
                left++;
            }
            while (left < right && (nums[right] & 1) == 0) { // 右指针向左寻找奇数：用位运算判断
                right--;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}

public class _20_exchange {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        Solution_21 solution = new Solution_21();
        int[] res = solution.exchange(nums);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
