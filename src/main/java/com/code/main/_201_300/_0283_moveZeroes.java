/**
 * // 283. 移动零
 * // 难度：中等
 * // 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * //
 * // 示例:
 * // 输入: [0,1,0,3,12]
 * // 输出: [1,3,12,0,0]
 * //
 * // 说明:
 * //
 * // 必须在原数组上操作，不能拷贝额外的数组。
 * // 尽量减少操作次数。
 */

package com.code.main._201_300;

class Solution_0283 {
    public void moveZeroes(int[] nums) {
        // 最简单的解法：用一个新数组拷贝非0元素，效率高，但是不满足要求
//        int[] arr = new int[nums.length];
//        int cnt = 0;    // 统计非0的个数
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                arr[cnt] = nums[i];
//                cnt++;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = arr[i];
//        }

        // 双指针：左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
        // 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
        //注意到以下性质：
        //左指针左边均为非零数；
        //右指针左边直到左指针处均为零。
        //因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
        int left = 0, right = 0;
        while (right < nums.length) {   // 右指针遍历数组
            if (nums[right] != 0) {
                // 交换left和right
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;     // 将一个非0数调整到左侧，left右移一位
            }
            right++;    // 每次遍历，right都要右移一位
        }
    }
}

public class _0283_moveZeroes {
    public static void main(String[] args) {
        // [0,1,0,3,12]
//        int[] nums = {0, 0, 1};
//        int[] nums = {0, 1, 0, 3, 12, 0, 1, 5, 1};
        int[] nums = {1, 0, 2, 0, 1};
        Solution_0283 solution = new Solution_0283();
        solution.moveZeroes(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
