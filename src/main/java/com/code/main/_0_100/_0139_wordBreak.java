/**
 * // 139. 单词拆分
 * // 难度；中等
 * // 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * //
 * // 说明：
 * // 拆分时可以重复使用字典中的单词。
 * // 你可以假设字典中没有重复的单词。
 * //
 * // 示例 1：
 * // 输入: s = "leetcode", wordDict = ["leet", "code"]
 * // 输出: true
 * // 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * //
 * // 示例 2：
 * // 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * // 输出: true
 * // 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * //      注意你可以重复使用字典中的单词。
 * //
 * // 示例 3：
 * // 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * // 输出: false
 */

package com.code.main._0_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_0139 {
    /**
     * //     1、使用记忆法递归的方法
     * //     （1）、将列表重新修改为Map<char,String>;
     * //     （2）、建立一个列表noMatch，用来维护无法匹配的字符串。
     * //     (3)、对入参s的首字母进行判断，获取对应的Map中首字母对应的字符串列表；
     * //     0、首先判断noMatch中是否有该字符串。没有的话继续。
     * //     建立一个判断函数wordIsTrue，返回的类型boolean
     * //     a、如果Map中字符串列表遍历到的字符串b与入参s的前若干字符一一对应，则进行递归：
     * //     wordIsTrue(s-b,map);
     * //     b、如果不匹配，则继续遍历。
     * //     （4）、函数wordIsTrue，如果入参s为空，则返回true；
     * //     对Map中字符串列表遍历结束后，如果没有匹配的则返回false；
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        //1、第一步，将列表转换为Map<char,String>;
        Map<Character, List<String>> wordMap = new HashMap<>();
        for (String str : wordDict) {
            if (!wordMap.containsKey(str.charAt(0))) {
                List<String> word = new ArrayList<>();
                word.add(str);
                wordMap.put(str.charAt(0), word);
            } else {
                List<String> g = wordMap.get(str.charAt(0));
                g.add(str);
            }
        }
        return wordIsTrue(s, wordMap, new ArrayList<>());
    }

    //改造成记忆法递归
    private static boolean wordIsTrue(String s, Map<Character, List<String>> wordMap, List<String> noMatch) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (!wordMap.containsKey(s.charAt(0))) return false;
        if (noMatch.contains(s)) return false;
        for (String word : wordMap.get(s.charAt(0))) {
            if (s.length() >= word.length() & s.startsWith(word)) {
                String substr = s.substring(word.length());
                if (wordIsTrue(substr, wordMap, noMatch)) {
                    return true;
                }
            }
        }
        noMatch.add(s); // 当前子串无法匹配词典
        return false;
    }

    /**
     * //     2、动态规划
     * //
     * //     （1）、建立一个n+1(0--n)长度的数组dp，除第一个元素外，每一个元素的值都是false；
     * //     （2）、遍历字符串，遍历索引i：0===s.length-1
     * //     判断当前dp[i] == true;
     * //     遍历j：i+1==s.length-1；
     * //     判断s[i,j],是否在字典中；
     * //     是：dp[j] = true;
     * //     否：dp[j] = false;
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        int n = s.length();
        dp[0] = true;
        for (int index = 0; index < n; index++) {
            if (dp[index] == true) {
                for (int j = index + 1; j < n + 1; j++) {
                    String substr = s.substring(index, j);
                    if (wordDict.contains(substr)) {
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[n];
    }
}

public class _0139_wordBreak {
    public static void main(String[] args) {
        // "catsandog" ["cats","dog","sand","and","cat"]
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        Solution_0139 solution = new Solution_0139();
        System.out.println(solution.wordBreak(s, wordDict));
        System.out.println(solution.wordBreak2(s, wordDict));
    }
}
