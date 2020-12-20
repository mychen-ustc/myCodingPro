/**
 * // 581. 最短无序连续子数组
 * // 难度：中等
 * // 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * //
 * // 你找到的子数组应是最短的，请输出它的长度。
 * //
 * // 示例 1:
 * // 输入: [2, 6, 4, 8, 10, 9, 15]
 * // 输出: 5
 * // 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * //
 * // 说明 :
 * // 输入的数组长度范围在 [1, 10,000]。
 * // 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */

package com.code.main._501_600;

class Solution_0581 {
    public int findUnsortedSubarray(int[] nums) {
        // 解法1: 朴素做法, 排序。将数组拷贝，排序后与原数组对比。时间O(nlogn) + O(n) ，实测时间56%
//        int[] arr = Arrays.copyOf(nums, nums.length);
//        Arrays.sort(arr);
//        int start = 0, end = nums.length - 1;
//        while (start <= end && nums[start] == arr[start]) start++;
//        while (start <= end && nums[end] == arr[end]) end--;
//        return end - start + 1;

        // 解法2: 利用栈，两次遍历分别找左右边界 O(n) + O(n).实测时间性能较差(15%)
        // 1. 从左到右入栈，如果数字一直是升序就将序号入栈。否则弹出栈顶，找到第一个乱序的索引
        // 2. 从右到左入栈，跟1相反。
//        Stack<Integer> stack = new Stack<>();
//        int left = nums.length, right = 0;
//        for (int i = 0; i < nums.length; i++) {
//            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
//                left = Math.min(left, stack.pop());
//            stack.push(i);
//        }
//        stack.clear();  // 清空栈
//        for (int i = nums.length - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
//                right = Math.max(right, stack.pop());
//            stack.push(i);
//        }
//        return right > left ? right - left + 1 : 0;

        // 解法3: 不适用额外空间，直接找左右边界 O(n)+O(n)，实测时间 62%
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}

public class _0581_findUnsortedSubarray {
    public static void main(String[] args) {
        // [2,6,4,8,10,9,15]
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        Solution_0581 solution = new Solution_0581();
        System.out.println(solution.findUnsortedSubarray(nums));
    }
}
