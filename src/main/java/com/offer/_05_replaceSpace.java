/**
 * // 05. 替换空格
 * // 难度：简单
 * // 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * //
 * // 示例 1：
 * //
 * // 输入：s = "We are happy."
 * // 输出："We%20are%20happy."
 * //
 * // 限制：
 * //
 * // 0 <= s 的长度 <= 10000
 */

package com.offer;

class Solution_05 {
    public String replaceSpace(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                buffer.append("%20");
            } else {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }
}

public class _05_replaceSpace {
    public static void main(String[] args) {
        String s = "We are happy.";
        Solution_05 solution = new Solution_05();
        String ans = solution.replaceSpace(s);
        System.out.println(ans);
    }
}
