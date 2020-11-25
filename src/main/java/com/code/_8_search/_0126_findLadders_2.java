/**
 * // 126. 单词接龙 II
 * // 难度：困难
 * //
 * // 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * //
 * // 每次转换只能改变一个字母。
 * // 转换后得到的单词必须是字典中的单词。
 * // 说明:
 * //
 * // 如果不存在这样的转换序列，返回一个空列表。
 * // 所有单词具有相同的长度。
 * // 所有单词只由小写字母组成。
 * // 字典中不存在重复的单词。
 * // 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * // 示例 1:
 * //
 * // 输入:
 * // beginWord = "hit",
 * // endWord = "cog",
 * // wordList = ["hot","dot","dog","lot","log","cog"]
 * //
 * // 输出:
 * // [
 * // ["hit","hot","dot","dog","cog"],
 * //   ["hit","hot","lot","log","cog"]
 * // ]
 * // 示例 2:
 * //
 * // 输入:
 * // beginWord = "hit"
 * // endWord = "cog"
 * // wordList = ["hot","dot","dog","lot","log"]
 * //
 * // 输出: []
 * //
 * // 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */

package com.code._8_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_0126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return null;
    }
}

public class _0126_findLadders_2 {

    public static void main(String[] args) {
        Solution_0126 solution = new Solution_0126();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        List<List<String>> result = solution.findLadders(beginWord, endWord, list);
        System.out.println(result);
    }
}
