/**
 * // 461. 汉明距离
 * // 难度：简单
 * // 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * //
 * // 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * //
 * // 注意：
 * // 0 ≤ x, y < 2^31.
 * //
 * // 示例:
 * // 输入: x = 1, y = 4
 * // 输出: 2
 * //
 * // 解释:
 * // 1   (0 0 0 1)
 * // 4   (0 1 0 0)
 * //        ↑   ↑
 * //
 * // 上面的箭头指出了对应二进制位不同的位置。
 */

package com.code.main._401_500;

class Solution_0461 {
    public int hammingDistance(int x, int y) {
        // 解法1: 先对2个数字做异或，然后用位运算统计1的个数
//        int ans = 0;
//        int xor = x ^ y;
//        while (xor > 0) {
//            if (xor % 2 != 0)
//                ans++;
//            xor >>= 1;    // 逐位运算（运算次数为二进制位数）
//        }
//        return ans;

        // 解法2：布赖恩·克尼根算法，思路跟解法1类似，只是算下一次二进制数有区别
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'
            xor = xor & (xor - 1);  // 跳过中间的0，直接跳到下一个1（运算次数为二进制中1的个数）
        }
        return distance;
    }
}

public class _0461_hammingDistance {
    public static void main(String[] args) {
        Solution_0461 solution = new Solution_0461();
        System.out.println(solution.hammingDistance(1, 4));
    }
}
