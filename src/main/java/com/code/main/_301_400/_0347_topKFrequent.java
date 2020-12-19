/**
 * // 347. 前 K 个高频元素
 * // 难度：中等
 * // 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * //
 * // 示例 1:
 * // 输入: nums = [1,1,1,2,2,3], k = 2
 * // 输出: [1,2]
 * //
 * // 示例 2:
 * // 输入: nums = [1], k = 1
 * // 输出: [1]
 * //
 * // 提示：
 * // 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * // 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * // 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * // 你可以按任意顺序返回答案。
 */

package com.code.main._301_400;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution_0347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 解法1: 朴素解法，用hashmap统计个数，然后转换为List排序后取Top k
//        Map<Integer, Integer> map = new HashMap<>();
//        // 统计数字个数
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());   // 将map的元素存入list
//        list.sort((o1, o2) -> o2.getValue().intValue() - o1.getValue().intValue());     // list排序
//        int[] ans = new int[k];
//        for (int i = 0; i < k; i++)
//            ans[i] = list.get(i).getKey();
//        return ans;

        // 解法2: 统计出现次数，用堆收集Top K，时间性能跟解法1相仿
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}

public class _0347_topKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Solution_0347 solution = new Solution_0347();
        int[] ans = solution.topKFrequent(nums, k);
        for (int num : ans)
            System.out.println(num);
    }
}
