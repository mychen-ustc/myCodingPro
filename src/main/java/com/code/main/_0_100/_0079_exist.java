/**
 * // 79. 单词搜索
 * // 难度：中等
 * // 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * //
 * // 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * //
 * // 示例:
 * // board =
 * // [
 * // ['A','B','C','E'],
 * // ['S','F','C','S'],
 * // ['A','D','E','E']
 * // ]
 * //
 * // 给定 word = "ABCCED", 返回 true
 * // 给定 word = "SEE", 返回 true
 * // 给定 word = "ABCB", 返回 false
 * //
 * // 提示：
 * // board 和 word 中只包含大写和小写英文字母。
 * // 1 <= board.length <= 200
 * // 1 <= board[i].length <= 200
 * // 1 <= word.length <= 10^3
 */

package com.code.main._0_100;

class Solution_0079 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = judge(board, word, 0, i, j, visit);
                if (flag) return true;  // 已经找到完全匹配的
            }
        }
        return false;
    }

    public boolean judge(char[][] board, String word, int index, int row, int col, boolean[][] visit) {
        if (board[row][col] != word.charAt(index)) return false;    // 当前字符不匹配
        if (index == word.length() - 1) return true;    // 已经找到完全匹配的
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};   // 方向数组
        visit[row][col] = true;     // 标记当前位置已访问
        boolean flag = false;
        for (int i = 0; i < 4; i++) {   // 探索4个方向
            int newx = row + directions[i][0];
            int newy = col + directions[i][1];
            if (newx >= 0 && newx < board.length && newy >= 0 && newy < board[0].length) {
                if (!visit[newx][newy]) {
                    flag = judge(board, word, index + 1, newx, newy, visit);
                    if (flag) {
                        break;
                    }
                }
            }
        }
        return flag;
    }
}

public class _0079_exist {
    public static void main(String[] args) {
        // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]] "ABCCED"
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'F'}};
        Solution_0079 solution = new Solution_0079();
        System.out.println(solution.exist(board, "ABCCED"));
        System.out.println(solution.exist(board, "ABCCFD"));
        System.out.println(solution.exist(board, "ABCFD"));
        System.out.println(solution.exist(board, "ABCESF"));
    }
}
