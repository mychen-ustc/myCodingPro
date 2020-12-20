/**
 * // 448. 找到所有数组中消失的数字
 * // 难度：简单
 * // 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * //
 * // 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * //
 * // 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * //
 * // 示例:
 * // 输入:
 * // [4,3,2,7,8,2,3,1]
 * //
 * // 输出:
 * // [5,6]
 */

package com.code.main._401_500;

import java.util.ArrayList;
import java.util.List;

class Solution_0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
//        // 最朴素的做法，用hashmap或数组计数，最后遍历找到计数为0的（时间性能没问题，空间为O(n)）
//        List<Integer> ans = new ArrayList<>();
//        int len = nums.length;
//        int[] arr = new int[len + 1];
//        for (int num : nums) {
//            arr[num]++;
//        }
//        for (int i = 1; i <= len; i++) {
//            if (arr[i] == 0)
//                ans.add(i);
//        }
//
//        return ans;

        // 优化: 原地修改数组，将空间复杂度降低为O(1)
        // 用nums[i]作为索引，将对应位置的绝对值乘以-1，既能起到标记作用，又不会覆盖对应位置的值影响后续判断
        // 不能直接覆盖索引位置，因为覆盖后就无法判断数字是否存在。绝对值乘以-1的方式很巧妙
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for (int i = 1; i <= nums.length; i++) {    // 遍历1~n，找到缺失的数字，不会有重复问题
            if (nums[i - 1] > 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}

public class _0448_findDisappearedNumbers {
    public static void main(String[] args) {
        // [4,3,2,7,8,2,3,1]
        Solution_0448 solution = new Solution_0448();
        List<Integer> ans = solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        for (int num : ans) {
            System.out.println(num);
        }
    }
}
