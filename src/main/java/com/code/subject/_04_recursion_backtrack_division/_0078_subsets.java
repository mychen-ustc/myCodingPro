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
 *
 * 思路：
 * 利用回溯方法生成子集，即对于每个元素，都有试探放入或不放入集合中的两个选择：
 * 选择放入该元素，队规进行后续元素的选择，完成放入该元素后续所有元素的试探。之后将其拿出，再进行一次选择不放入该元素，递归进行后续元素的选择。
 */

package com.code.subject._04_recursion_backtrack_division;

import java.util.ArrayList;
import java.util.List;

class Solution0078 {
    public void dfs(int[] nums, int start, List<List<Integer>> result, List<Integer> item) {
        if (start >= nums.length) return;   //递归终止条件
        item.add(nums[start]);  // 添加当前元素
        result.add(new ArrayList<>(item));  //新建一个list添加到结果集
        dfs(nums, start + 1, result, item); // 包含当前元素递归
        item.remove(item.size() - 1);   // 移除当前元素
        dfs(nums, start + 1, result, item); // 不包含当前元素递归
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> item = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(item);   // 将空集添加到结果中
        dfs(nums, 0, result, item); // 从第一个数字开始搜索

        return result;
    }
}

public class _0078_subsets {

    public static void main(String[] args) {
        Solution0078 solution = new Solution0078();
        int nums[] = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}
