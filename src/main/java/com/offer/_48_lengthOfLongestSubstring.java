/**
 * // 48. 最长不含重复字符的子字符串
 * // 难度：中等
 * // 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * //
 * // 示例 1:
 * // 输入: "abcabcbb"
 * // 输出: 3
 * // 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * //
 * // 示例 2:
 * // 输入: "bbbbb"
 * // 输出: 1
 * // 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * //
 * // 示例 3:
 * // 输入: "pwwkew"
 * // 输出: 3
 * // 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * //      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * //  
 * // 提示：
 * // s.length <= 40000
 * //
 * // 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */

package com.offer;

import java.util.HashMap;
import java.util.Map;

class Solution_48 {
    public int lengthOfLongestSubstring(String s) {
        // 用动态规划求解：dp表示以当前字符结尾的最大不重复子串
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int dp = 0;    // 由于dp的状态只由前一个状态转移而来，只需要一个变量即可，不需要创建dp数组
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = map.getOrDefault(ch, -1);     // 获取字符上一次出现的位置
            map.put(ch, i);
            if (dp < i - idx) {
                dp = dp + 1;
            } else {
                dp = i - idx;
            }
            ans = Math.max(ans, dp);
        }
        return ans;
    }
}

public class _48_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution_48 solution = new Solution_48();
        int ans = solution.lengthOfLongestSubstring(s);
        System.out.println(ans);
    }
}
