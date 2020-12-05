/**
 * // 39. 数组中出现次数超过一半的数字
 * // 难度：简单
 * // 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * //
 * // 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * //
 * // 示例 1:
 * // 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * // 输出: 2
 * //
 * // 限制：
 * // 1 <= 数组长度 <= 50000
 * //
 * // 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
 * //
 * // 解题思路：
 * // 本文将 “数组中出现次数超过一半的数字” 简称为 “众数” 。
 * // 需要注意的是，数学中众数的定义为 “数组中出现次数最多的数字” ，与本文定义不同。
 * //
 * // 本题常见的三种解法：
 * // 哈希表统计法： 遍历数组 nums ，用 HashMap 统计各数字的数量，即可找出 众数 。此方法时间和空间复杂度均为 O(N)O(N) 。
 * // 数组排序法： 将数组 nums 排序，数组中点的元素 一定为众数。
 * // 摩尔投票法： 核心理念为 票数正负抵消 。此方法时间和空间复杂度分别为 O(N) 和 O(1) ，为本题的最佳解法。
 */

package com.offer;

import java.util.HashMap;
import java.util.Map;

class Solution_39 {
    public int majorityElement(int[] nums) {
        // 做法一：用hashmap记录数字出现的次数
//        Map<Integer, Integer> map = new HashMap<>();    // 记录数字出现的次数(如果数字为自然数且数量较少，可以用一个数组数字出现的次数)
//        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
//            int cnt = map.containsKey(num) ? map.get(num) + 1 : 1;
//            if (cnt >= (nums.length + 1) / 2) { // 当前数字出现的次数超过一半
//                return num;
//            }
//            map.put(num, cnt);
//        }
//        return 0;

        // 做法二：摩尔投票法
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}

public class _39_majorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Solution_39 solution = new Solution_39();
        int ans = solution.majorityElement(nums);
        System.out.println(ans);
    }
}
