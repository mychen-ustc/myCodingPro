/**
 * // 12. 矩阵中的路径
 * // 难度：中等
 * // 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * //
 * // [["a","b","c","e"],
 * // ["s","f","c","s"],
 * // ["a","d","e","e"]]
 * //
 * // 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * //
 * // 示例 1：
 * //
 * // 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * // 输出：true
 * // 示例 2：
 * //
 * // 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * // 输出：false
 * //
 * // 提示：
 * // 1 <= board.length <= 200
 * // 1 <= board[i].length <= 200
 * // 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 */

package com.offer;

class Solution_12 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0))  // 遍历每个位置，开始搜索
                    return true;
            }
        }
        return false;
    }

    /**
     * @param board 字符矩阵
     * @param word  要查找的字符串
     * @param i     当前搜索位置的横坐标
     * @param j     当前搜索位置的纵坐标
     * @param k     当前查找的word的字符索引
     * @return
     */
    boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(k))
            return false;   // 剪枝
        if (k == word.length() - 1)
            return true;    // 已匹配到所有字符
        board[i][j] = '\0';     // 用\0标记当前位置已搜索，避免重复扫描
        // 遍历4个方向
        boolean res = dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1);
        board[i][j] = word.charAt(k);    // 回退当前位置进行回溯
        return res;
    }
}

public class _12_exist {
    public static void main(String[] args) {
        char[][] board = {{'a', 'b', 'c', 'd'}, {'s', 'f', 'c', 's'}, {'A', 'd', 'e', 'e'}};
        String word = "abcced";
        Solution_12 solution = new Solution_12();
        boolean ans = solution.exist(board, word);
        System.out.println(ans);
    }
}
