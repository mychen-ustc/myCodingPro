/**
 * // 338. 比特位计数
 * // 难度：中等
 * // 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * //
 * // 示例 1:
 * // 输入: 2
 * // 输出: [0,1,1]
 * //
 * // 示例 2:
 * // 输入: 5
 * // 输出: [0,1,1,2,1,2]
 * //
 * // 进阶:
 * // 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * // 要求算法的空间复杂度为O(n)。
 * // 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */

package com.code.main._301_400;

class Solution_0338 {
    public int[] countBits(int num) {
        // 解法1: 通过位运算收集1的个数 时间 O(n*digit(n))
//        int[] ans = new int[num + 1];
//        for (int i = 0; i <= num; i++) {
//            int k = i;
//            while (k > 0) {
//                int tmp = k & 1;    // 与操作查看最低位是否为1
//                if (tmp > 0)    // 最低位为1，计数加1
//                    ans[i]++;
//                k >>= 1;    // 右移1位
//            }
//        }
//        return ans;

        // 解法2: Popcount, 跟解法1类似，但是计算次数少很多 (67.9% vs 10.96%, 2ms vs 6ms)
//        int[] ans = new int[num + 1];
//        for (int i = 0; i <= num; ++i)
//            ans[i] = popcount(i);
//        return ans;

        // 解法3:动态规划 + 最高有效位, 状态转移函数 P(x+b) = P(x) + 1, b = 2^k > x;
        // 利用已有的计数结果来生成新的计数结果
//        int[] ans = new int[num + 1];
//        int b = 1;  // b用于控制下一组可生成的数字的范围，会以2^k扩大
//        // [0, b) is calculated
//        while (b <= num) {
//            int i = 0;  // i用于递推
//            // generate [b, 2b) or [b, num) from [0, b)
//            while (i < b && i + b <= num) {
//                ans[i + b] = ans[i] + 1;
//                i++;
//            }
//            b <<= 1;    // b = 2b
//        }
//        return ans;

        // 解法4: 动态规划 + 最低有效位, 状态转移函数 p(x) = P(x/2) + (x mod 2)
//        int[] ans = new int[num + 1];
//        for (int i = 1; i <= num; i++) {
//            ans[i] = ans[i >> 1] + (i & 1);  // x / 2 is x >> 1 and x % 2 is x & 1
//        }
//        return ans;

        // 解法5: 动态规划 + 最后设置位, 状态转移函数 P(x) = P(x & (x-1)) + 1
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

    private int popcount(int x) {
        int count;
        for (count = 0; x != 0; count++)
            x &= x - 1; // zeroing out the least significant nonzero bit
        return count;
    }
}

public class _0338_countBits {
    public static void main(String[] args) {
        // 2 输出 [0,1,1]
        // 5 输出 [0,1,1,2,1,2]
        Solution_0338 solution = new Solution_0338();
        int[] ans = solution.countBits(5);
        for (int num : ans)
            System.out.println(num);
    }
}
