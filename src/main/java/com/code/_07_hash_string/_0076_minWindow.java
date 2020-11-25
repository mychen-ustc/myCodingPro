/**
 * // 76. 最小覆盖子串
 * // 难度：困难
 * //
 * // 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * //
 * // 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * //
 * //  
 * //
 * // 示例 1：
 * //
 * // 输入：s = "ADOBECODEBANC", t = "ABC"
 * // 输出："BANC"
 * // 示例 2：
 * //
 * // 输入：s = "a", t = "a"
 * // 输出："a"
 * //  
 * //
 * // 提示：
 * //
 * // 1 <= s.length, t.length <= 10^5
 * // s 和 t 由英文字母组成
 * //  
 * //
 * // 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 * //
 * // 来源：力扣（LeetCode）
 * // 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package com.code._07_hash_string;

class Solution_0076 {
    public String minWindow(String s, String t) {

    }
}

public class _0076_minWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution_0076 solution = new Solution_0076();
        String result = solution.minWindow(s, t);
        System.out.println(result);
    }
}
