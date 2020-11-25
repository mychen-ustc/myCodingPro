/**
 * 90. 子集 II
 * 难度：中等
 * <p>
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * <p>
 * 方法：回溯搜索算法 + 数组排序 + 同层剪枝
 * 思路：使用回溯算法遍历决策树，穷举所有解，决策树的每个节点维护当前已选路径track/path和选择列表等信息
 * 相比t078-子集（不包含重复元素），本题可能包含重复元素，若不进行剪枝处理，子集可能出现重复。
 * （1）数组排序：对原始数组进行排序，保证重复元素必相邻，方便后续剪枝
 * （2）同层剪枝：当决策树由【当前层】向【下一层】递归时，依次向路径中添加1个数组元素；
 * 同一层中，若向不同路径添加重复元素（排序后重复元素相邻），该枝干出现重复，需进行剪枝 → 跳过当次循环。
 * 时间复杂度：
 * 空间复杂度：
 * 类似题目：t046-全排列、t077-组合、t078-子集（不包含重复元素）
 * 【t040-组合总和II】（数组元素可能有重复，每个元素仅能选一次）
 * 优化点：路径track/path可使用栈Stack，可方便使用压栈push()和出栈操作pop()。
 */

package com.code._04_recursion_backtrack_division;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution0090 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) return res;
        //对数组元素进行排序，保证重复元素必相邻，方便后续剪枝
        Arrays.sort(nums);
        // 记录选择
        List<Integer> track = new ArrayList<>();
        backtrack(nums, 0, track);

        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> track) {
        //结果集中包含已选路径（部分子集），需对引用track进行拷贝
        res.add(new ArrayList<>(track));

        //遍历数组
        //结束条件：i == nums.length时终止，遍历完全部数组元素
        for (int i = start; i < nums.length; i++) {
            //同层剪枝：同一层的两条不同路径中加入的元素出现重复时（数组已排序） → 跳过当次循环
            if (i > start && nums[i] == nums[i - 1]) {   // 从start之后的位置开始判断是否重复
                continue;
            }
            // 做出选择并回溯搜索
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            // 移除当前元素，继续探索
            track.remove(track.size() - 1);
        }
    }
}

public class _0090_subsetsWithDup {
    public static void main(String[] args) {
        Solution0090 solution = new Solution0090();
        int nums[] = {2, 1, 2, 3};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        System.out.println(result);
    }

}
