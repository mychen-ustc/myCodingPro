/**
 * // 120. 三角形最小路径和
 * // 难度：中等
 * // 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * //
 * // 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * // 例如，给定三角形：
 * //
 * // [
 * //    [2],
 * //   [3,4],
 * //  [6,5,7],
 * // [4,1,8,3]
 * // ]
 * // 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * //
 * // 说明：
 * // 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * //
 * // 思路：
 * // 1.设置一个二维数组 最优值三角形dp[][]，初始化所有元素为0，dp[i][j]代表从底向上递推时，走到三角形第i行第j列的最优解。
 * // 2.从三角形的底部向上方进行动态规划：
 * // a.动态规划的边界条件：底部的最优值即为数字三角形最后一层的数值
 * // b.利用i循环，从倒数第二层递推至第一层，对于每层的各列，进行动态规划递推：
 * //   第i行j列的最优值为dp[i][j],可达到(i,j)的两个位置的最优解dp[i+1][j]、dp[i+1][j+1]
 * //   dp[i][j] = min(dp[i+1][j], dp[i+1][j+1])+triangle[i][j]
 * // 3.返回dp[0][0]
 * //
 * // 如果在面试中遇到类似的题目，需要和面试官进行沟通，可以询问「是否有空间复杂度限制」「是否可以修改原数组」等问题，给出符合条件的算法。
 */
package com.code.subject._09_dynamic_program;

import java.util.ArrayList;
import java.util.List;

class Solution_0120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;

        // 定义和初始化动态规划数组dp：最优解三角形数组
        // 动态规划数组可以优化空间消耗，即只用2行来记住当前行和下一行的数值。或者直接原地修改，不使用额外空间
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(0);
            }
            dp.add(list);
        }

        // 初始化最优解底部的一排:数值跟三角形数组的最底部一排相同
        for (int i = 0; i < triangle.size(); i++) {
            dp.get(triangle.size() - 1).set(i, triangle.get(triangle.size() - 1).get(i));
        }

        // 从倒数第2排开始递推
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int val = Math.min(dp.get(i + 1).get(j), dp.get(i + 1).get(j + 1)) + triangle.get(i).get(j);
                dp.get(i).set(j, val);
            }
        }

        return dp.get(0).get(0);
    }
}

public class _0120_triangle {
    public static void main(String[] args) {
        int[][] nums = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(nums[i][j]);
            }
            triangle.add(list);
        }
        System.out.println(triangle);

        Solution_0120 solution = new Solution_0120();
        int min = solution.minimumTotal(triangle);
        System.out.println(min);
    }
}
