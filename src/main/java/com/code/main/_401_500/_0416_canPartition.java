/**
 * // 416. 分割等和子集
 * // 难度：中等
 * // 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * //
 * // 注意:
 * // 每个数组中的元素不会超过 100
 * // 数组的大小不会超过 200
 * //
 * // 示例 1:
 * // 输入: [1, 5, 11, 5]
 * // 输出: true
 * // 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * //
 * // 示例 2:
 * // 输入: [1, 2, 3, 5]
 * // 输出: false
 * // 解释: 数组不能分割成两个元素和相等的子集.
 */

package com.code.main._401_500;

import java.util.ArrayList;
import java.util.List;

class Solution_0416 {
    public boolean canPartition(int[] nums) {
        // 分析: 先求数组的总和sum，然后寻找能组成sum/2的子数组
        // 本解法超出时间限制
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 != 0 || nums.length % 2 != 0 || max > sum % 2)  // 如果个数不是偶数，或者总和不是偶数，或者最大值超过总和一半
            return false;
        return dfs(nums, sum / 2, 0);
    }

    // 递归回溯查找子数组: 参数只需额外传入要查找的目标，当前查找的索引
    // 如果要给出找到的子数组组合，就再传入一个列表
    public boolean dfs(int[] nums, int target, int i) {
        if (i == nums.length - 1)   // 已经查找到最后一个数字
            return nums[i] == target;
        if (nums[i] == target)  // 已经找到满足条件的组合
            return true;
        target -= nums[i];
        boolean flag = dfs(nums, target, i + 1);
        if (flag)
            return true;
        // 回溯
        target += nums[i];
        return dfs(nums, target, i + 1);
    }
}

public class _0416_canPartition {
    public static void main(String[] args) {
        // [1,5,11,5]
        Solution_0416 solution = new Solution_0416();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{1, 3, 3, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3}));
        System.out.println(solution.canPartition(new int[]{1, 3}));
        System.out.println(solution.canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));

    }
}
