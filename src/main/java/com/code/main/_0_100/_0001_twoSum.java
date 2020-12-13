/**
 * // 1. 两数之和
 * // 难度：简单
 * // 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * //
 * // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * //
 * // 示例:
 * // 给定 nums = [2, 7, 11, 15], target = 9
 * //
 * // 因为 nums[0] + nums[1] = 2 + 7 = 9
 * // 所以返回 [0, 1]
 */

package com.code.main._0_100;

import java.util.HashMap;
import java.util.Map;

class Solution_0001 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();    // 记录每个数字的索引
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                ans[0] = map.get(target - num);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}

public class _0001_twoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution_0001 solution = new Solution_0001();
        int[] ans = solution.twoSum(nums, target);
        for (int num : ans) {
            System.out.println(num);
        }
    }
}
