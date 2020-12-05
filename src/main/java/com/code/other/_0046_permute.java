/**
 * // 46. 全排列
 * // 难度：中等
 * // 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * //
 * // 示例:
 * //
 * // 输入: [1,2,3]
 * // 输出:
 * // [
 * // [1,2,3],
 * // [1,3,2],
 * // [2,1,3],
 * // [2,3,1],
 * // [3,1,2],
 * // [3,2,1]
 * // ]
 */

package com.code.other;

import java.util.ArrayList;
import java.util.List;

class Solution_0046 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
//        Arrays.sort(nums);  // 将数组排序，不必要，因为没有重复，这里只是为了让结果集的排列有序
        List<List<Integer>> ans = new ArrayList<>();    // 结果集
        List<Integer> path = new ArrayList<>();     // 当前得到的组合
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, used, ans, path);
        return ans;
    }

    /**
     * 递归求解不重复的数字组合
     *
     * @param nums  输入的数字数组
     * @param depth 递归深度
     * @param used  状态数组
     * @param ans   结果集
     * @param path  当前组合
     */
    void dfs(int[] nums, int depth, boolean[] used, List<List<Integer>> ans, List<Integer> path) {
        int len = nums.length;
        if (depth == len) {     // 搜索到一组解
            ans.add(new ArrayList<>(path));     // 添加到结果集
            return;
        }
        for (int i = 0; i < len; i++) {     // 每一轮递归，需要寻找一个可用的数字
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, used, ans, path);
                // 回退，进行回溯
                path.remove(path.size() - 1);   // 移除最后一个元素
                used[i] = false;
            }
        }
    }
}

public class _0046_permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution_0046 solution = new Solution_0046();
        List<List<Integer>> ans = solution.permute(nums);
        System.out.println(ans.size());
    }
}
