/**
 * // 15. 三数之和
 * // 难度：中等
 * // 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * //
 * // 注意：答案中不可以包含重复的三元组。
 * //
 * // 示例：
 * // 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * //
 * // 满足要求的三元组集合为：
 * // [
 * // [-1, 0, 1],
 * // [-1, -1, 2]
 * // ]
 */

package com.code.main._0_100;

import java.util.*;

class Solution_0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 分析：暴力求解，时间O(n^3)，将三数问题转化为二数问题，将时间优化为O(n^2) 只击败10%
        // 将数组排序，用HashMap统计数字频率，用于判定 0-num1-num2是否存在
        Arrays.sort(nums);  // 对数组排序
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);     // 统计频率
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // 剪枝：保证第一个数字不重复
            int oldNum3 = Integer.MIN_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[i], num2 = nums[j];
                int num3 = 0 - num1 - num2;  // 第三个数可转化为0-num1-num2
                if (num3 == oldNum3) continue;  // 剪枝: 保证第三个数字不重复
                if (!(num1 <= num2 && num2 <= num3))    // 剪枝: 保证三个数非严格升序
                    continue;
                int cnt = map.getOrDefault(num3, 0);
                // 需要特别注意 remainder的频率，因为这个数字是推测出来的
                if (num3 != 0 && (num3 == num1 || num3 == num2)) {     // 如果数字与num1/num2重合，而数字的频率小于2，不满足
                    if (cnt < 2) continue;
                }
                if (num1 == 0 && num1 == 0 && num2 == 0) {
                    if (cnt < 3) continue;
                }
                if (cnt > 0) {  // 找到一组解
                    List<Integer> list = new ArrayList<>();
                    list.add(num1);
                    list.add(num2);
                    list.add(num3);
                    ans.add(list);  // 添加到结果集
                }
                oldNum3 = num3;
            }
        }
        return ans;
    }
}

public class _0015_threeSum {
    public static void main(String[] args) {
        // [-1,0,1,2,-1,-4]
        int[] nums = {-1, 0, 1, 2, -1, -1, 0, 0};
        Solution_0015 solution = new Solution_0015();
        List<List<Integer>> ans = solution.threeSum(nums);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
