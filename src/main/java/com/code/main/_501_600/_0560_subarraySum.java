/**
 * // 560. 和为K的子数组
 * // 难度：中等
 * // 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * //
 * // 示例 1 :
 * // 输入:nums = [1,1,1], k = 2
 * // 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * // 说明 :
 * //
 * // 数组的长度为 [1, 20,000]。
 * // 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */

package com.code.main._501_600;

import java.util.HashMap;
import java.util.Map;

class Solution_0560 {
    public int subarraySum(int[] nums, int k) {
        // 分析: 暴力求解,O(n^2) 15%
        // 利用前缀和数组+哈希表降低时间复杂度 O(n) 61%
        // 前缀和数组可以退化成一个整型变量
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);  // 累加满足条件的组合个数
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);     // 更新前缀和映射
        }
        return count;
    }
}

public class _0560_subarraySum {
    public static void main(String[] args) {
        // [1,1,1] 2
        Solution_0560 solution = new Solution_0560();
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));
    }
}
