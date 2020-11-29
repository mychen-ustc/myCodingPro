/**
 * // 56. 合并区间
 * // 难度：中等
 * // 给出一个区间的集合，请合并所有重叠的区间。
 * //
 * // 示例 1:
 * //
 * // 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * // 输出: [[1,6],[8,10],[15,18]]
 * // 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * // 示例 2:
 * //
 * // 输入: intervals = [[1,4],[4,5]]
 * // 输出: [[1,5]]
 * // 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * // 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * //
 * // 提示：
 * //
 * // intervals[i][0] <= intervals[i][1]
 * //
 * // 思路：
 * // 对起点和终点分别进行排序，将起点和终点一一对应形成一个数组。
 * // 如果没有overlap,返回当前起点和终点
 * // 如果有overlap,判断以下条件
 * // 找出最小的起点
 * // 如果当前终点大于下一个数组的起点的时候，比较当前终点和下一个终点的大小，取为right
 * // 返回满足要求的区间[[left,right]]
 */

package com.code.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_0056 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0 || intervals == null)
            return res.toArray(new int[0][]);
        // 按起点排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果区间右重叠，一直向右探测到第一个不能合并的区间（即找到可合并区间的最右端）
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});    // 将合并后的区间加入结果集
            i++;
        }

        return res.toArray(new int[res.size()][]);  // toArray一定要带参数(指定第一维)，可以用new int[0][]或new int[size][]
    }
}

public class _0056_merge_intervals {
    public static void main(String[] args) {
        int[][] intervals = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        Solution_0056 solution = new Solution_0056();
        int[][] ans = solution.merge(intervals);
        System.out.println(ans);
    }

}
