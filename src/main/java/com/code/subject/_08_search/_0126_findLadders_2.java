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

package com.code.subject._08_search;

import java.util.*;

// 定义一个类，用于封装词汇、前驱、当前步数
class Qitem {
    String word;
    int parentPos;
    int step;

    Qitem(String word, int parentPos, int step) {
        this.word = word;
        this.parentPos = parentPos;
        this.step = step;
    }
}

class Solution_0126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = buildGraph(beginWord, wordList);
        List<Qitem> queue = new ArrayList<>();
        List<Integer> endWordPos = new ArrayList<>();
        bfs(beginWord, endWord, graph, queue, endWordPos);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < endWordPos.size(); i++) {
            int pos = endWordPos.get(i);
            List<String> backPath = new ArrayList<>();
            while (pos != -1) {
                Qitem item = queue.get(pos);
                backPath.add(item.word);
                pos = item.parentPos;
            }
            List<String> path = new ArrayList<>();
            for (int j = backPath.size() - 1; j >= 0; j--) {
                path.add(backPath.get(j));
            }
            result.add(path);
        }
        return result;
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
        // 判断起点是否在词汇列表中
        boolean begin_in_list = false;
        for (String str : wordList) {
            if (str.equals(beginWord))
                begin_in_list = true;
        }
        if (!begin_in_list)
            wordList.add(beginWord);
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

    // 遍历图，寻找并返回所有路径
    public void bfs(String beginWord, String endWord, Map<String, List<String>> graph,
                    List<Qitem> queue, List<Integer> endWordPos) {
        List<List<String>> result = new ArrayList<>();  // 存储找到的结果
        Map<String, Integer> visit = new HashMap<>();    // 已访问的节点
        int minStep = 0;    // 到达word的最小步数
        queue.add(new Qitem(beginWord, -1, 1));  // 将起点存入队列，起点的前驱为-1
        visit.put(beginWord, 1);   // 标记起始节点已访问
        int front = 0;  // 队头指针，指向queue的队头
        while (front != queue.size()) {
            Qitem item = queue.get(front);  // 取队头
            String word = item.word;
            int step = item.step;
            if (minStep != 0 && step > minStep) {
                break;  // step > minStep表示所有最短路径都已搜索完成
            }
            if (word.equals(endWord)) {     // 找到终点，返回
                minStep = step;     // 搜素到结果时，记录最小步数
                endWordPos.add(front);
            }
            List<String> neighbors = graph.get(word);   // 取节点的所有邻居
            for (String str : neighbors) {
                if (!visit.containsKey(str) || visit.get(str) == step + 1) {    // 节点没被访问，或者是另一条最短路径
                    queue.add(new Qitem(str, front, step + 1));   // 将未访问过的邻居存入队列
                    visit.put(str, step + 1);
                }
            }
            front++;
        }
    }
}

public class _0126_findLadders_2 {

    public static void main(String[] args) {
        Solution_0126 solution = new Solution_0126();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog", "hit"));
        List<List<String>> result = solution.findLadders(beginWord, endWord, list);
        System.out.println(result);
    }
}
