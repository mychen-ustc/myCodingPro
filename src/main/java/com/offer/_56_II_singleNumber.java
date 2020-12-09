/**
 * // 56 - II. 数组中数字出现的次数 II
 * // 难度：中等
 * // 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * //
 * // 示例 1：
 * // 输入：nums = [3,4,3,3]
 * // 输出：4
 * //
 * // 示例 2：
 * // 输入：nums = [9,1,7,9,7,9,7]
 * // 输出：1
 * //
 * // 限制：
 * // 1 <= nums.length <= 10000
 * // 1 <= nums[i] < 2^31
 * //
 * // 思路：
 * // 如果一个数字出现三次,那么它的二进制表示的每一位(0或者1)也出现三次。
 * // 如果把所有出现三次的数字的二进制表示的每一位都分别加起来,那么每一位的和都能被3整除。
 * // 如果某一位的和能被3整除,那么那个只出现一次的数字二进制表示中对应的那一位是0;否则就是1;
 * // 上述思路同样适用于数组中一个数字出现一次，其他数字出现奇数次问题(如果是偶数次，直接用异或就可)。
 * // 这种解法的时间效率是O(n)。我们需要一个长度为32的辅助数组存储二进制表示的每一位的和。由于数组的长度是固定的,因此空间效率是O(1)。
 */

package com.offer;

class Solution_56_II {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) return 0;
        // 建立长度为32的数组，用于存储所有数字按位与操作的结果
        // 如果最后某一位能被3整除，说明所求的数字在那一位为0，否则为1
        int[] digits = new int[32];
        // 第一次遍历，对所有数字按位与，将结果存入数组
        for (int num : nums) {
            int digit = 1;
            for (int i = 31; i >= 0; i--) {
                if ((num & digit) != 0) digits[i]++;    // 如果该位与预算后部位0，则该位需要加1
                digit <<= 1;    // 左移1位
            }
        }
        // 第二次遍历，还原所求的数字
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;  // 先将结果右移一位
            ans ^= digits[i] % 3;   // 最低位加上位对3的余数 ans ^= digits[i] % 3; 比 ans += digits[i] % 3;快一点点
        }
        return ans;
    }
}

public class _56_II_singleNumber {
    public static void main(String[] args) {
        // [3,4,3,3]
        int[] nums = {1, 1, 6, 1};
        Solution_56_II solution = new Solution_56_II();
        int ans = solution.singleNumber(nums);
        System.out.println(ans);
    }
}
