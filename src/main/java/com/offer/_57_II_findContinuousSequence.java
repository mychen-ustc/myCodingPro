/**
 * // 57 - II. 和为s的连续正数序列
 * // 难度：简单
 * // 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * //
 * // 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * //
 * // 示例 1：
 * // 输入：target = 9
 * // 输出：[[2,3,4],[4,5]]
 * //
 * // 示例 2：
 * // 输入：target = 15
 * // 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * //
 * // 限制：
 * // 1 <= target <= 10^5
 */

package com.offer;

import java.util.ArrayList;
import java.util.List;

class Solution_57_II {
    public int[][] findContinuousSequence(int target) {
        // 简单但低效的解法：逐个数字作为起点向后延伸
//        List<int[]> ans = new ArrayList<>();
//        for (int begin = 1; begin <= target / 2; begin++) {     // 依次遍历小于 target/2 的自然数，作为起始数字
//            int sum = 0;
//            for (int j = begin; j < target; j++) {
//                sum += j;
//                if (sum == target) {    // 找到一组解
//                    int[] arr = new int[j - begin + 1];
//                    ans.add(arr);
//                    for (int i = 0; i < j - begin + 1; i++) {
//                        arr[i] = begin + i;
//                    }
//
//                } else if (sum > target) {
//                    break;  // 退出当前循环
//                }
//            }
//        }
//        return ans.toArray(new int[0][]);

        // 滑动窗口：
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}

public class _57_II_findContinuousSequence {
    public static void main(String[] args) {
        Solution_57_II solution = new Solution_57_II();
        int[][] ans = solution.findContinuousSequence(15);
        for (int i = 0; i < ans.length; i++) {
            StringBuilder sbuild = new StringBuilder();
            for (int j = 0; j < ans[i].length; j++) {
                sbuild.append(ans[i][j]).append(" ");
            }
            System.out.println(sbuild.toString());
        }
    }
}
