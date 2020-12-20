/**
 * // 416. 分割等和子集
 * // 难度：中等
 * // 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * //
 * // 注意:
 * // 每个数组中的元素不会超过 100
 * // 数组的大小不会超过 200
 * //
 * // 示例 1:
 * // 输入: [1, 5, 11, 5]
 * // 输出: true
 * // 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * //
 * // 示例 2:
 * // 输入: [1, 2, 3, 5]
 * // 输出: false
 * // 解释: 数组不能分割成两个元素和相等的子集.
 */

package com.code.main._401_500;

class Solution_0416 {
    public boolean canPartition(int[] nums) {
        // NP问题，转化0-1背包问题，用动态规划求解. 见_0416.png
        // 解法1：动态规划
//        int n = nums.length;
//        int sum = 0, max = 0;
//        for (int num : nums) {
//            sum += num;
//            max = Math.max(max, num);
//        }
//        int target = sum / 2;
//        if (n < 2 || sum % 2 != 0 || max > target) return false;    // 三种情况不可能有可行解
//        boolean[][] dp = new boolean[n][target + 1];    // dp[i][j]表示从数组的[0,j]范围内选取若干个数，是否存在和为j的组合
//        for (int i = 0; i < n; i++) {   // 初始情况1: 目标和为0, 所有数字不取即可
//            dp[i][0] = true;
//        }
//        dp[0][nums[0]] = true;  // 初始情况2: [0,0]范围内只有nums[0]，可以组合成target=num[0]
//        for (int i = 1; i < n; i++) {   // 递推遍历所有[0,i]的范围
//            int num = nums[i];
//            for (int j = 1; j <= target; j++) { // 递推目标和
//                if (j >= num) {     // num比target小，有2种情况转移： 1.[0,i-1]范围内的解, 2.将num加入组合，看j-num在[0,i-1]是否有解
//                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
//                } else {    // num比target，不能加入组合，只有1种情况转移 [0,i-1]范围内的解
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
//        return dp[n - 1][target];

        // 解法1：由于只从上一行转移而来，可简化空间为一维数组,时间性能也有所改善
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (max > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {   // 不处理j<num的情况，因为dp[i][j] = dp[i - 1][j] 是共用的，只考虑dp[i - 1][j - num]的转移
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}

public class _0416_canPartition {
    public static void main(String[] args) {
        // [1,5,11,5]
        Solution_0416 solution = new Solution_0416();
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution.canPartition(new int[]{1, 3, 3, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3}));
        System.out.println(solution.canPartition(new int[]{1, 3}));
        System.out.println(solution.canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));

    }
}
