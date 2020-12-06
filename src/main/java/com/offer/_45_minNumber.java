/**
 * // 45. 把数组排成最小的数
 * // 难度：中等
 * // 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * //
 * // 示例 1:
 * // 输入: [10,2]
 * // 输出: "102"
 * //
 * // 示例 2:
 * // 输入: [3,30,34,5,9]
 * // 输出: "3033459"
 * //  
 * //
 * // 提示:
 * // 0 < nums.length <= 100
 * //
 * // 说明:
 * // 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * // 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * //
 * // 解题思路：
 * // 此题求拼接起来的 “最小数字” ，本质上是一个排序问题。
 * // 排序判断规则： 设 numsnums 任意两数字的字符串格式 x 和 y ，则
 * // 若拼接字符串 x + y > y + x ，则 x > y
 * // 反之，若 x + y < y + x ，则 x < y
 * // 根据以上规则，套用任何排序方法对 nums 执行排序即可。
 */

package com.offer;

import java.util.Arrays;

class Solution_45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (str1, str2) -> (str1 + str2).compareTo(str2 + str1));   // 自定义排序，比较两种顺序拼接字符串的大小
        StringBuilder builder = new StringBuilder();
        for (String num : strs) {
            builder.append(num);
        }
        return builder.toString();
    }
}

public class _45_minNumber {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        Solution_45 solution = new Solution_45();
        String ans = solution.minNumber(nums);
        System.out.println(ans);
    }
}
