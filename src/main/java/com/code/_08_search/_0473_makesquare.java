/**
 * // 473. 火柴拼正方形
 * // 难度：中等
 * //
 * // 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 * //
 * // 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 * //
 * // 示例 1:
 * //
 * // 输入: [1,1,2,2,2]
 * // 输出: true
 * //
 * // 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * // 示例 2:
 * //
 * // 输入: [3,3,3,3,4]
 * // 输出: false
 * //
 * // 解释: 不能用所有火柴拼成一个正方形。
 * // 注意:
 * //
 * // 给定的火柴长度和在 0 到 10^9之间。
 * // 火柴数组的长度不超过15。
 */

package com.code._08_search;

import java.util.*;

class Solution_0473 {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4)
            return false;
        int sum = 0;    // 总和
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0)
            return false;
        // 将数组排序：逆序
        Arrays.sort(nums);
        int[] numsTmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsTmp[nums.length - i - 1] = nums[i];
        }

        int[] sums = new int[4];    // 4个桶
        // 进行搜索
        return search(numsTmp, sums, 0, sum / 4);
    }

    public boolean search(int[] nums, int[] sums, int pos, int target) {
        if (pos >= nums.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target;
        }
        for (int i = 0; i < 4; i++) {   // 依次对4个桶进行尝试
            if (sums[i] + nums[pos] > target)   // 将当前木柴加入后超过target，不继续循环
                continue;
            sums[i] += nums[pos];   // 加入当前木柴
            if (search(nums, sums, pos + 1, target))
                return true;
            sums[i] -= nums[pos];
        }
        return false;
    }
}

public class _0473_makesquare {
    public static void main(String[] args) {
        //[1,1,2,2,2]
        int[] nums = {4, 3, 2, 1, 1, 2, 3, 4};
        Solution_0473 solution = new Solution_0473();
        boolean flag = solution.makesquare(nums);
        System.out.println(flag);
    }
}
