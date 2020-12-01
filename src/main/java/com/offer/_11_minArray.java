/**
 * // 11. 旋转数组的最小数字
 * // 难度：简单
 * // 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * //
 * // 示例 1：
 * //
 * // 输入：[3,4,5,1,2]
 * // 输出：1
 * // 示例 2：
 * //
 * // 输入：[2,2,2,0,1]
 * // 输出：0
 * // 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */

package com.offer;

class Solution_11 {
    public int minArray(int[] numbers) {
        // 题目没有说明数组为空时如何处理，interview的时候要问一下
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {    // 忽略左半边
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {  // 忽略右半边
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];   // 终止时left=right，都指向最小值
    }
}

public class _11_minArray {
    public static void main(String[] args) {
        int[] numbers = {5, 5, 9, 10, 1, 2, 3, 4, 5, 5};
        Solution_11 solution = new Solution_11();
        int ans = solution.minArray(numbers);
        System.out.println(ans);
    }
}
