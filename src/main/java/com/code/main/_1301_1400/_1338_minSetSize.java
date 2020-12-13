/**
 * // 1338. 数组大小减半
 * // 难度：中等
 * // 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * //
 * // 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 * //
 * // 示例 1：
 * // 输入：arr = [3,3,3,3,5,5,5,2,2,7]
 * // 输出：2
 * // 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * // 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * // 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 * //
 * // 示例 2：
 * // 输入：arr = [7,7,7,7,7,7]
 * // 输出：1
 * // 解释：我们只能选择集合 {7}，结果数组为空。
 * //
 * // 示例 3：
 * // 输入：arr = [1,9]
 * // 输出：1
 * //
 * // 示例 4：
 * // 输入：arr = [1000,1000,3,7]
 * // 输出：1
 * //
 * // 示例 5：
 * // 输入：arr = [1,2,3,4,5,6,7,8,9,10]
 * // 输出：5
 * //
 * // 提示：
 * // 1 <= arr.length <= 10^5
 * // arr.length 为偶数
 * // 1 <= arr[i] <= 10^5
 */

package com.code.main._1301_1400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_1338 {
    public int minSetSize(int[] arr) {
        if (arr.length == 0) return -1;
        // 贪心：统计频率，按频率从大到小依次选取
        // 统计每个数字出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 按频率排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((item1, item2) -> (item2.getValue().intValue() - item1.getValue().intValue()));    // 将数组按频率排序

        // 计算结果
        int ans = 0;
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            if (cnt >= arr.length / 2) {
                return ans;
            }
            cnt += entry.getValue();
            ans++;
        }
        return ans;
    }
}

public class _1338_minSetSize {
    public static void main(String[] args) {
        // [3,3,3,3,5,5,5,2,2,7]
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        Solution_1338 solution = new Solution_1338();
        int ans = solution.minSetSize(arr);
        System.out.println(ans);
    }
}
