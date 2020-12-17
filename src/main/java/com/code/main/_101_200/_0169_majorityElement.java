/**
 * // 169. 多数元素
 * // 难度：简单
 * // 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * //
 * // 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * //
 * // 示例 1:
 * // 输入: [3,2,3]
 * // 输出: 3
 * //
 * // 示例 2:
 * // 输入: [2,2,1,1,1,2,2]
 * // 输出: 2
 */

package com.code.main._101_200;

import java.util.Random;

class Solution_0169 {
    public int majorityElement(int[] nums) {
        // 思路1: 用hashmap统计数量
        // 思路2: 排序，中间的数即为所求
        // 思路3: 随机化， 由于一个给定的下标对应的数字很有可能是众数，我们随机挑选一个下标，检查它是否是众数，如果是就返回，否则继续随机挑选。
        // 思路4: Boyer-Moore 投票，如果我们把众数记为 +1+1，把其他数记为 -1−1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。

        // 解法1：排序
//        Arrays.sort(nums);
//        return nums[nums.length / 2];

        // 解法2: 随机化（效率跟解法1相当 75%）
        Random rand = new Random();
        int majorityCount = nums.length / 2;
        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }

        // 解法3：投票
//        int count = 0;
//        Integer candidate = null;
//        for (int num : nums) {
//            if (count == 0)
//                candidate = num;
//            count += (num == candidate) ? 1 : -1;
//        }
//        return candidate;
    }

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}

public class _0169_majorityElement {
    public static void main(String[] args) {
        // [3,2,3]
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        Solution_0169 solution = new Solution_0169();
        int ans = solution.majorityElement(nums);
        System.out.println(ans);
    }
}
