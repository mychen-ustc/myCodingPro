/**
 * // 136. 只出现一次的数字
 * // 难度：简单
 * // 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * //
 * // 说明：
 * // 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * //
 * // 示例 1:
 * // 输入: [2,2,1]
 * // 输出: 1
 * //
 * // 示例 2:
 * // 输入: [4,1,2,1,2]
 * // 输出: 4
 */

package com.code.main._101_200;

class Solution_0136 {
    public int singleNumber(int[] nums) {
        // 由于所有其他数字都是2个，异或之后就是0，将所有数字都进行异或操作，最后剩下的就是指出现一次的
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}

public class _0136_singleNumber {
    public static void main(String[] args) {
        // [2,2,1]
        int[] num = {5};
        Solution_0136 solution = new Solution_0136();
        System.out.println(solution.singleNumber(num));
    }
}
