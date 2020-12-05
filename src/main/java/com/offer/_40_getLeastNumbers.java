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
 */

package com.offer;

import java.util.Arrays;

class Solution_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        int len = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}

public class _40_getLeastNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        Solution_40 solution = new Solution_40();
        int[] ans = solution.getLeastNumbers(nums, 4);
        System.out.println(ans);
    }
}
