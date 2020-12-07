/**
 * // 51. 数组中的逆序对
 * // 难度：困难
 * // 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * //
 * // 示例 1:
 * // 输入: [7,5,6,4]
 * // 输出: 5
 * //
 * // 限制：
 * // 0 <= 数组长度 <= 50000
 * //
 * // 思路：借鉴归并排序的思想，用分治解决
 * // 可以用这个case分析一下合并和统计的过程 L = [8, 12, 16, 22, 100]   R = [9, 26, 55, 64, 91]  M = []
 */

package com.offer;

class Solution_51 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] copy = new int[len];  // 定义拷贝数组
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];  // 拷贝数组初始化
        }
        int[] tmp = new int[len];
        return reversePairs(nums, 0, len - 1, tmp);
    }

    //对nums[left..right] 计算逆序对的个数并且排序
    int reversePairs(int[] nums, int left, int right, int[] tmp) {
        if (left == right) return 0;    // 只剩一个数，已经有序，且逆序对为0
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, tmp);
        int rightPairs = reversePairs(nums, mid + 1, right, tmp);
        if (nums[mid] == nums[mid + 1]) {   // 如果半边数组全部小于右半边，则不存在逆序
            return leftPairs + rightPairs;
        }
        int residualPairs = mergeAndCount(nums, left, mid, right, tmp);  // 计算2段有序数组有多少逆序对，并合并2段数组
        return leftPairs + rightPairs + residualPairs;
    }

    // 左右数组已经分别有序，合并和统计逆序对
    int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <= right; i++)
            tmp[i] = nums[i];   // 将数组拷贝到tmp
        int i = left, j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {     // i超出范围，左半段处理完，将j归并回去
                nums[k] = tmp[j];
                j++;
            } else if (j == right + 1) {    // j超出范围，右半段处理完，将i归并回去
                nums[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {  // 将j归并回去：左半段数字归并回去的时候，不需要统计（因为没有逆序或者已经被统计过）
                nums[k] = tmp[i];
                i++;
            } else {    // 将i归并回去
                nums[k] = tmp[j];
                j++;
                count += (mid - i + 1);     // 只需要在将右半段数组元素归并回去的时候，计算左半段数组中还没有被归并回去的个数
            }
        }
        return count;
    }
}

public class _51_reversePairs {
    public static void main(String[] args) {
        // [7,5,6,4]
        int[] nums = {7, 5, 6, 4};
        Solution_51 solution = new Solution_51();
        int ans = solution.reversePairs(nums);
        System.out.println(ans);
    }
}
