/**
 * // 50. 第一个只出现一次的字符
 * // 难度：简单
 * // 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * //
 * // 示例:
 * //
 * // s = "abaccdeff"
 * // 返回 "b"
 * //
 * // s = ""
 * // 返回 " "
 * //
 * // 限制：
 * // 0 <= s 的长度 <= 50000
 * //
 * // 思路：将字符串扫描一次，记录每个字符出现的次数，以及第一次出现的位置
 */

package com.offer;

class Solution_50 {
    public char firstUniqChar(String s) {
        if (s.length() == 0)
            return ' ';
        int[] counts = new int[26];
        int[] indexs = new int[26];
        for (int i = 0; i < 26; i++)
            indexs[i] = -1;     // 将索引全初始化为-1，因为0是有效索引，不能初始化为0
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts[ch - 'a']++;   // 计数加1
            if (indexs[ch - 'a'] < 0)
                indexs[ch - 'a'] = i;     // 记录每个字符第一次出现的位置
        }
        int minIndex = Integer.MAX_VALUE;   // 第一个只出现一次的字符的索引，初始化为无穷大
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 1) {
                if (indexs[i] < minIndex) {
                    minIndex = indexs[i];
                }
            }
        }
        return minIndex < Integer.MAX_VALUE ? s.charAt(minIndex) : ' ';
    }
}

public class _50_firstUniqChar {
    public static void main(String[] args) {
        String s = "aabbccd";
        Solution_50 solution = new Solution_50();
        char ans = solution.firstUniqChar(s);
        System.out.println(ans);
    }
}
