/**
 * // 15. 三数之和
 * // 难度：中等
 * // 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * //
 * // 注意：答案中不可以包含重复的三元组。
 * //
 * // 示例：
 * // 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * //
 * // 满足要求的三元组集合为：
 * // [
 * // [-1, 0, 1],
 * // [-1, -1, 2]
 * // ]
 */

package com.code.main._0_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_0015_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {  // 剪枝: 跳过重复的a
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];  // num2+num3=-num1
            // 枚举 b
            for (int second = first + 1; second < n; second++) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {   // 剪枝: 跳过重复的b
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

public class _0015_threeSum_2 {
    public static void main(String[] args) {
        // [-1,0,1,2,-1,-4]
        int[] nums = {-1, 0, 1, 2, -1, -1, 0, 0};
        Solution_0015_2 solution = new Solution_0015_2();
        List<List<Integer>> ans = solution.threeSum(nums);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
