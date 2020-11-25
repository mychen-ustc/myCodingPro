/**
 * // 3. 无重复字符的最长子串
 * // 难度：中等
 * //
 * // 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * //
 * // 示例 1:
 * //
 * // 输入: "abcabcbb"
 * // 输出: 3
 * // 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * // 示例 2:
 * //
 * // 输入: "bbbbb"
 * // 输出: 1
 * // 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * // 示例 3:
 * //
 * // 输入: "pwwkew"
 * // 输出: 3
 * // 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * //      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

package com.code._07_hash_string;

class Solution_0003 {
    public int lengthOfLongestSubstring(String s) {
        int charNum = 128;  // 字符最大个数
        int begin = 0;  // 头指针
        int result = 0;
        String word = "";   // 记录当前组成的字符串
        int[] charMap = new int[charNum];   // 默认初始化为0
        for (int i = 0; i < s.length(); i++) {
            charMap[s.charAt(i)]++;    // 更新字符的个数
            if (charMap[s.charAt(i)] == 1) { // word中没有出现该字符
                word += s.charAt(i);    // 将字符追加到字符串中
                if (result < word.length()) // 找到更长的不重复字符串，更新最大长度
                    result = word.length();
            } else {    // 字符串出现重复，需要更新头指针
                while (begin < i && charMap[s.charAt(i)] > 1) {
                    charMap[s.charAt(begin)]--;
                    begin++;    // 向后移动指针
                }
                word = s.substring(begin, i + 1);   // 更新字符串
            }
        }

        return result;
    }
}

public class _0003_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "pwwkew";
        Solution_0003 solution = new Solution_0003();
        int result = solution.lengthOfLongestSubstring(str);
        System.out.println(result);
    }
}
