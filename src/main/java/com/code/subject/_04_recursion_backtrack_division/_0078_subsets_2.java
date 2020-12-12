/**
 * 78. 子集
 * 难度：中等
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 思路：
 * 位运算: A元素为100=4, B元素为010=2,C元素为001=1
 * 如构造某一结合，即使用ABC对应的三个整数与该集合对应的整数做&运算，如果是真，则将该元素push到集合中。
 */

package com.code.subject._04_recursion_backtrack_division;

import java.util.ArrayList;
import java.util.List;

class Solution0078_2 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int max = 1 << nums.length;  // 最大值

        for (int i = 0; i < max; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) { // 遍历每个数字，如果该位是1，就放入结果中
                if ((i & (1 << j)) > 0) {
                    item.add(nums[j]);
                }
            }
            result.add(item);
        }

        return result;
    }
}

public class _0078_subsets_2 {

    public static void main(String[] args) {
        Solution0078_2 solution = new Solution0078_2();
        int nums[] = {1, 2, 3, -1, 9};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}
