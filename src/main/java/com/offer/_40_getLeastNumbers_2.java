/**
 * // 40. 最小的k个数
 * // 难度：简单
 * // 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * //
 * // 示例 1：
 * // 输入：arr = [3,2,1], k = 2
 * // 输出：[1,2] 或者 [2,1]
 * //
 * // 示例 2：
 * // 输入：arr = [0,1,2,1], k = 1
 * // 输出：[0]
 * //  
 * // 限制：
 * // 0 <= k <= arr.length <= 10000
 * // 0 <= arr[i] <= 10000
 * //
 * // 用堆，数据量小的时候没有排序效率高
 */

package com.offer;

import java.util.PriorityQueue;

class Solution_40_2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) { // 排除 0 的情况PriorityQueue
            return ans;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> x - y);
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}

public class _40_getLeastNumbers_2 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        Solution_40 solution = new Solution_40();
        int[] ans = solution.getLeastNumbers(nums, 4);
        System.out.println(ans);
    }
}