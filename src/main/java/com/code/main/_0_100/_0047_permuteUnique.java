/**
 * // 47. 全排列 II
 * // 难度：中等
 * // 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * //
 * // 示例 1：
 * // 输入：nums = [1,1,2]
 * // 输出：
 * // [[1,1,2],
 * // [1,2,1],
 * // [2,1,1]]
 * //
 * // 示例 2：
 * // 输入：nums = [1,2,3]
 * // 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * //
 * // 提示：
 * // 1 <= nums.length <= 8
 * // -10 <= nums[i] <= 10
 */

package com.code.main._0_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();    // 结果集
        if (nums.length == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        List<Integer> path = new ArrayList<>();     // 当前组合
        boolean[] used = new boolean[nums.length];      // 状态数组
        Arrays.sort(nums);  // 将输入数组排序
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
        if (depth == len) {     // 找到一组解
            ans.add(new ArrayList<>(path));     // 添加到结果集中
            return;
        }
        for (int i = 0; i < nums.length; i++) {     // 每一轮递归，需要寻找一个可用的数字
            if (!used[i]) {     // 如果当前数字还没使用过
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {     // 重复的情况，剪枝
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, used, ans, path);
                // 回溯
                path.remove(path.size() - 1);   // 移除最后添加的元素
                used[i] = false;    // 重置状态
            }
        }
    }
}

public class _0047_permuteUnique {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution_0047 solution = new Solution_0047();
        List<List<Integer>> ans = solution.permuteUnique(nums);
        System.out.println(ans);
    }
}
