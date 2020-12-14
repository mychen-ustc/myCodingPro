/**
 * // 31. 下一个排列
 * // 难度：中等
 * // 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * //
 * // 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * //
 * // 必须 原地 修改，只允许使用额外常数空间。
 * //
 * // 示例 1：
 * // 输入：nums = [1,2,3]
 * // 输出：[1,3,2]
 * //
 * // 示例 2：
 * // 输入：nums = [3,2,1]
 * // 输出：[1,2,3]
 * //
 * // 示例 3：
 * // 输入：nums = [1,1,5]
 * // 输出：[1,5,1]
 * //
 * // 示例 4：
 * // 输入：nums = [1]
 * // 输出：[1]
 * //  
 * // 提示：
 * // 1 <= nums.length <= 100
 * // 0 <= nums[i] <= 100
 */

package com.code.main._0_100;

class Solution_0031 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        // 第一次遍历: 从后往前，找到第一个非降序的位置
        int i = len - 1;
        while (i >= 0) {
            if (i < len - 1) {  // 非最后一个数字
                if (nums[i] < nums[i + 1])  // 找到第一个非降序的i
                    break;
            }
            i--;
        }
        if (i < 0) {   // nums已经是降序排列，输出逆序后的数组
            reverse(nums, 0, len - 1);
            return;
        }
        // 第二次遍历: 从后往前，找到第一个大于nums[i]的数字
        int j = len - 1;
        while (nums[j] <= nums[i] && j > i) {    // 从第一次遍历来看，这里必定能找到满足条件的j
            j--;
        }
        // 交换nums[i]和num[j]
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        // 颠倒 j+1~len-1的顺序
        reverse(nums, i + 1, len - 1);
    }

    // 将数组元素颠倒顺序
    public void reverse(int[] nums, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            // 交换i,j的数字
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}

public class _0031_nextPermutation {
    public static void main(String[] args) {
        // [1,2,3]
//        int[] nums = {6, 5, 4, 3, 2, 1};
        int[] nums = {6, 5, 2, 3, 4, 1};
//        int[] nums = {1, 3, 2};
        for (int num : nums)
            System.out.print(num + " ");
        Solution_0031 solution = new Solution_0031();
//        solution.reverse(nums);   // 测试颠倒顺序
        solution.nextPermutation(nums);
        System.out.println();
        for (int num : nums)
            System.out.print(num + " ");
    }
}
