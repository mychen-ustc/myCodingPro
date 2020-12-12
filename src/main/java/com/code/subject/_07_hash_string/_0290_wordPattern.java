/**
 * 290. 单词规律
 * 难度：简单
 * <p>
 * // 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * //
 * // 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * //
 * // 示例1:
 * //
 * // 输入: pattern = "abba", str = "dog cat cat dog"
 * // 输出: true
 * // 示例 2:
 * //
 * // 输入:pattern = "abba", str = "dog cat cat fish"
 * // 输出: false
 * // 示例 3:
 * //
 * // 输入: pattern = "aaaa", str = "dog cat cat dog"
 * // 输出: false
 * // 示例 4:
 * //
 * // 输入: pattern = "abba", str = "dog dog dog dog"
 * // 输出: false
 * // 说明:
 * // 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 */

package com.code.subject._07_hash_string;

import java.util.HashMap;
import java.util.Map;

class Solution_0290 {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> tokenMap = new HashMap<>();
        Map<Character, String> charMap = new HashMap<>();
        String[] tokens = s.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (pattern.length() != tokens.length) {
                return false;   // 如果pattern里面的字符数量跟s中的token数量不一致，则不能匹配
            }
            char ch = pattern.charAt(i);

            // 判断字符串的映射是否符合条件
            if (tokenMap.containsKey(str)) {
                if (tokenMap.get(str) != ch)
                    return false;   // 字符串已存储的字符映射不匹配，返回false
            } else {
                tokenMap.put(str, ch);   // 存储 字符串->pattern字符 映射
            }
            // 判断字符的映射是否符合条件
            if (charMap.containsKey(ch)) {
                if (!charMap.get(ch).equals(str))
                    return false;
            } else {
                charMap.put(ch, str);   // 存储 pattern字符到->字符串 映射
            }
        }
        return true;
    }
}

public class _0290_wordPattern {
    public static void main(String[] args) {
        String pattern = "aaaa";
        String str = "dog dog dog dog";
        Solution_0290 solution = new Solution_0290();
        boolean flag = solution.wordPattern(pattern, str);
        System.out.println(flag);
    }
}
