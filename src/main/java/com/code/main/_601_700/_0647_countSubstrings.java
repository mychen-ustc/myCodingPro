/**
 * // 647. 回文子串
 * // 难度：中等
 * // 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * //
 * // 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * //
 * // 示例 1：
 * // 输入："abc"
 * // 输出：3
 * // 解释：三个回文子串: "a", "b", "c"
 * //
 * // 示例 2：
 * // 输入："aaa"
 * // 输出：6
 * // 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * //
 * // 提示：
 * // 输入的字符串长度不会超过 1000 。
 */

package com.code.main._601_700;

class Solution_0647 {
    public int countSubstrings(String s) {
        // 解法1: 朴素做法，穷举所有的子串，检查是否为回文串 时间O(n^3) 5%
//        int ans = 0;
//        int len = s.length();
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                String str = s.substring(i, j + 1);
//                if (check(str))
//                    ans++;
//            }
//        }
//        return ans;

        // 解法2: 中心扩散 O(n^2) & O(1) 80%
//        int n = s.length(), ans = 0;
//        for (int i = 0; i < 2 * n - 1; i++) {
//            int left = i / 2, right = i / 2 + i % 2;
//            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
//                left--;
//                right++;
//                ans++;
//            }
//        }
//        return ans;

        // 解法3: Manacher算法 O(n) & O(n)  92.5%
        // 每2个字符之间添加特殊符号将长度扩充到2n+1, 在开头和结尾多加个$和!，保证循环不会越界（正常终止）
        // 初始化的公司稍微难理解
        int n = s.length();
        StringBuffer buffer = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            buffer.append(s.charAt(i));
            buffer.append('#');
        }
        n = buffer.length();
        buffer.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;    // 用rMax记录历史右端点的最大的回文串的右端点，iMax指向对应的中心
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i] 有两个限制: 1.初始值不超过右端点rmax，2.对称点的半径
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;     // 处理每个位置时，先用已经算出来的结果初始化
            // 中心拓展
            while (buffer.charAt(i + f[i]) == buffer.charAt(i - f[i])) {    // 一直扩展到两个端点不相同
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;    // 字母一定是在中心扩展的偶数位上（奇数位为#）
        }

        return ans;
    }

    // 判断是不是回文串
    public boolean check(String str) {
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

public class _0647_countSubstrings {
    public static void main(String[] args) {
        // aaabcbcba
        Solution_0647 solution = new Solution_0647();
//        System.out.println(solution.check("bcb"));
//        System.out.println(solution.countSubstrings("abc"));
//        System.out.println(solution.countSubstrings("aaa"));
//        System.out.println(solution.countSubstrings("aaabcbcba"));
        System.out.println(solution.countSubstrings("abacabac"));
    }
}
