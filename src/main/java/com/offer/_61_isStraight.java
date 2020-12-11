/**
 * // 61. 扑克牌中的顺子
 * // 难度：简单
 * // 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * // 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * //
 * // 示例 1:
 * // 输入: [1,2,3,4,5]
 * // 输出: True
 * //  
 * //
 * // 示例 2:
 * // 输入: [0,0,1,2,5]
 * // 输出: True
 * //
 * // 限制：
 * // 数组长度为 5 
 * // 数组的数取值为 [0, 13] .
 */

package com.offer;

import java.util.HashSet;
import java.util.Set;

class Solution_61 {
    public boolean isStraight(int[] nums) {
        // 顺子的要求：1.非0数字不能重复;2.max-min<5（否则，必然不能构成顺子）。条件2页暗含了0的数量足够组成顺子
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0) continue;
            if (set.contains(num)) return false;    // 不构成顺子的情况1:数字重复，直接返回false
            if (num > max) max = num;
            if (num < min) min = num;
            set.add(num);   // 非0元素添加到集合中
        }
        if (max - min >= 5) return false;   // 不构成顺子的情况2:首尾相差太大，0不足以填充
        return true;
    }
}

public class _61_isStraight {
    public static void main(String[] args) {
        // [1,2,3,4,5]
//        int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {0, 0, 1, 2, 5};
        Solution_61 solution = new Solution_61();
        boolean ans = solution.isStraight(nums);
        System.out.println(ans);
    }
}
