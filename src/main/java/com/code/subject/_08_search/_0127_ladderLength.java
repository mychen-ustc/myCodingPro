/**
 * // 127. 单词接龙
 * // 难度：中等
 * //
 * // 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * //
 * // 每次转换只能改变一个字母。
 * // 转换过程中的中间单词必须是字典中的单词。
 * // 说明:
 * //
 * // 如果不存在这样的转换序列，返回 0。
 * // 所有单词具有相同的长度。
 * // 所有单词只由小写字母组成。
 * // 字典中不存在重复的单词。
 * // 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * // 示例 1:
 * //
 * // 输入:
 * // beginWord = "hit",
 * // endWord = "cog",
 * // wordList = ["hot","dot","dog","lot","log","cog"]
 * //
 * // 输出: 5
 * //
 * // 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * // 返回它的长度 5。
 * // 示例 2:
 * //
 * // 输入:
 * // beginWord = "hit"
 * // endWord = "cog"
 * // wordList = ["hot","dot","dog","lot","log"]
 * //
 * // 输出: 0
 * //
 * // 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */

package com.code.subject._08_search;

import javafx.util.Pair;

import java.util.*;

class Solution_0127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = buildGraph(beginWord, wordList);
        return bfs(beginWord, endWord, graph);
    }

    // 判断两个字符串定点是否相邻
    public boolean is_connected(String word1, String word2) {
        int cnt = 0;    // 记录不相同的字符个数
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                cnt++;
        }
        return cnt == 1;
    }

    //构建图
    public Map<String, List<String>> buildGraph(String beginWord, List<String> wordList) {
        wordList.add(beginWord);    // 把起点添加到单次列表中（起始单次可能不在列表中）
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) { // 初始化图
            graph.put(wordList.get(i), new ArrayList<>());
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (is_connected(wordList.get(i), wordList.get(j))) {   // 两个词汇相邻，构建边
                    graph.get(wordList.get(i)).add(wordList.get(j));
                    graph.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        return graph;
    }

    // 遍历图，寻找路径，并返回最短路径长度
    public int bfs(String beginWord, String endWord, Map<String, List<String>> graph) {
        Queue<Pair<String, Integer>> queue = new LinkedList<>();    // 定义队列
        Set<String> visit = new HashSet<>();    // 已访问的节点
        queue.offer(new Pair<>(beginWord, 1));  // 将起点存入队列
        visit.add(beginWord);   // 标记起始节点已访问
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();  // 取队头
            String word = pair.getKey();
            int step = pair.getValue();
            if (word.equals(endWord)) {     // 找到终点，返回
                return step;
            }
            List<String> neighbors = graph.get(word);   // 取节点的所有邻居
            for (String str : neighbors) {
                if (!visit.contains(str)) {
                    queue.offer(new Pair(str, step + 1));   // 将未访问过的邻居存入队列
                    visit.add(str);
                }
            }
        }
        return 0;
    }
}

public class _0127_ladderLength {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        Solution_0127 solution = new Solution_0127();
        int minCnt = solution.ladderLength(beginWord, endWord, list);
        System.out.println(minCnt);
    }
}
