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
import java.util.List;

class Solution_0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean flag = true;
        for (String word : wordDict) {
            flag &= judge(s, word);
        }
        return flag;
    }

    // 判断字符串中是否存在某个子串
    public boolean judge(String s, String word) {
        return s.indexOf(word) >= 0;
    }
}

public class _0139_wordBreak {
    public static void main(String[] args) {
        // "leetcode" ["leet","code"]
        // "catsandog" ["cats","dog","sand","and","cat"]
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        Solution_0139 solution = new Solution_0139();
        boolean ans = solution.wordBreak(s, wordDict);
        System.out.println(ans);
    }
}
