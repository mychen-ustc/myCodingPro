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
 */

package com.code._07_hash_string;

import java.util.HashSet;
import java.util.Set;

class Solution_0076 {
    public String minWindow(String s, String t) {
        int[] mapSource = new int[128]; // 源字符串的字符个数映射，默认都初始化为0
        int[] mapTarget = new int[128]; // 目标字符串的字符个数映射，默认都初始化为0
        Set<Character> chars = new HashSet<>();  // 目标字符串中包含的所有字符，用于快速索引
        String result = ""; // 存储结果字符串
        int windowBegin = 0;    // 字符串串口的起始位置
        // 遍历目标字符串，并做响应的计数
        for (int i = 0; i < t.length(); i++) {
            chars.add(t.charAt(i));
            mapTarget[t.charAt(i)]++;
        }
        // 遍历数据，移动字符串窗口进行统计
        for (int i = 0; i < s.length(); i++) {
            mapSource[s.charAt(i)]++;
            while (windowBegin < i) {
                char ch = s.charAt(windowBegin);
                if (mapTarget[ch] == 0) {     // 如果首字符在目标字符串中不存在，可将头指针后移一位
                    windowBegin++;  // 窗口头指针后移1位
                } else if (mapSource[ch] > mapTarget[ch]) {  // 首字符在目标字符串中存在，但是字符的个数多余目标字符串，可以后移
                    windowBegin++;  // 窗口头指针后移一位
                    mapSource[ch]--;    // 头指针后移1位，需要把对应的字符个数减1
                } else {
                    break;
                }
            }
            // 处理结果字符串
            if (isCovered(mapSource, mapTarget, chars)) {
                int windowLen = i - windowBegin + 1;
                if (result.length() == 0 || result.length() > windowLen) {
                    result = s.substring(windowBegin, i + 1);
                }
            }
        }
        return result;
    }

    /**
     * 判断 mapSource 是否完整包含 mapTarget 的所有字符
     *
     * @param mapSource 源字符串的字符映射
     * @param mapTarget 目标字符串的字符映射
     * @param chars     目标字符串包含的所有字符
     * @return
     */
    public Boolean isCovered(int[] mapSource, int[] mapTarget, Set<Character> chars) {
        for (char ch : chars) {
            if (mapSource[ch] < mapTarget[ch]) {
                return false;
            }
        }
        return true;
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
