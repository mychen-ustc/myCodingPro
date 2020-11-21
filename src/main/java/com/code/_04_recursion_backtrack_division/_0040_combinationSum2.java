/**
 * 40. 组合总和 II
 * 难度：中等
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * 通过次数116,507提交次数180,828
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package com.code._04_recursion_backtrack_division;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution0040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        // 将数组排序，这一步很关键
        Arrays.sort(candidates);

        List<Integer> path = new ArrayList<>(len);
        backtrack(candidates, 0, target, path, res);

        return res;
    }

    private void backtrack(int[] candidates, int begin, int residule, List<Integer> path, List<List<Integer>> res) {
        if (residule == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // 大剪枝
            if (residule - candidates[i] < 0) break;    // 元素之和已经超过targer

            // 小剪枝
            if (i > begin && candidates[i] == candidates[i - 1]) continue;    // 元素重复
            path.add(candidates[i]);
            backtrack(candidates, i + 1, residule - candidates[i], path, res);
            path.remove(path.size() - 1);

        }
    }
}

public class _0040_combinationSum2 {
    public static void main(String[] args) {
        Solution0040 solution = new Solution0040();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
//        int[] candidates = {2, 5, 2, 1, 2};
//        int target = 5;
        System.out.println(solution.combinationSum2(candidates, target));
    }
}
