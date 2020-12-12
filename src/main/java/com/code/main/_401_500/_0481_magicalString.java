/**
 * // 481. 神奇字符串
 * // 难度：中等
 * // 神奇的字符串 S 只包含 '1' 和 '2'，并遵守以下规则：
 * //
 * // 字符串 S 是神奇的，因为串联字符 '1' 和 '2' 的连续出现次数会生成字符串 S 本身。
 * //
 * // 字符串 S 的前几个元素如下：S = “1221121221221121122 ......”
 * //
 * // 如果我们将 S 中连续的 1 和 2 进行分组，它将变成：
 * //
 * // 1 22 11 2 1 22 1 22 11 2 11 22 ......
 * //
 * // 并且每个组中 '1' 或 '2' 的出现次数分别是：
 * //
 * // 1 2 2 1 1 2 1 2 2 1 2 2 ......
 * //
 * // 你可以看到上面的出现次数就是 S 本身。
 * //
 * // 给定一个整数 N 作为输入，返回神奇字符串 S 中前 N 个数字中的 '1' 的数目。
 * //
 * // 注意：N 不会超过 100,000。
 * //
 * // 示例：
 * // 输入：6
 * // 输出：3
 * // 解释：神奇字符串 S 的前 6 个元素是 “12211”，它包含三个 1，因此返回 3。
 * //
 * // 思路：神奇字符串可以由自身简单生成，规则如下：
 * // 从头开始遍历，如果碰到1，则在字符串末尾添加一个与结尾字符串不同的字符，反之添加两个。
 * // 是很明显的快慢指针可以处理的题目。
 */

package com.code.main._401_500;

class Solution_0481 {
    public int magicalString(int n) {
        if (n == 0) return 0;
        // 用快慢指针，快指针用于在尾部生成新字符串，慢指针用于控制生成字符的个数
        StringBuilder sbuiler = new StringBuilder();
        sbuiler.append("122");      // 用3个字符初始化
        int fast = 2, slow = 2;     // 快指针指向2（当前已有3个字符），慢指针指向2（已初始化2组）
        int ans = 1;
        while (fast < n - 1) {  // 达到n个字符后退出循环
            if (sbuiler.charAt(slow) == '1') {   // 如果慢指针指向的字符为1，则在末尾添加1个与结尾字符不同的字符
                if (sbuiler.charAt(fast) == '1') {
                    sbuiler.append("2");
                } else {
                    sbuiler.append("1");
                    ans += 1;
                }
                fast += 1;      // 快指针移动2位
            } else {    // 如果慢指针指向的字符为2，则在末尾添加2个与结尾字符不同的字符
                if (sbuiler.charAt(fast) == '1') {
                    sbuiler.append("22");
                } else {
                    sbuiler.append("11");
                    if (sbuiler.length() > n) {     // 更新1的个数时，要注意字符个数不能超过n，否则可能多计算1的个数
                        ans += 1;
                    } else {
                        ans += 2;
                    }
                }
                fast += 2;      // 快指针移动1位
            }
            slow++;     // 慢指针每次只移动一位
        }
        return ans;
    }
}

public class _0481_magicalString {
    public static void main(String[] args) {
        Solution_0481 solution = new Solution_0481();
        int ans = solution.magicalString(1003);
        System.out.println(ans);
    }
}
