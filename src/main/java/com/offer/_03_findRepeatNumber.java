/**
 * // 03. 数组中重复的数字
 * // 难度：简单
 * // 找出数组中重复的数字。
 * //
 * //
 * // 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * //
 * // 示例 1：
 * //
 * // 输入：
 * // [2, 3, 1, 0, 2, 5, 3]
 * // 输出：2 或 3
 * //  
 * // 限制：
 * // 2 <= n <= 100000
 */

package com.offer;

import java.util.HashSet;
import java.util.Set;

class Solution_03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }
}

public class _03_findRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        Solution_03 solution = new Solution_03();
        int num = solution.findRepeatNumber(nums);
        System.out.println(num);
    }
}