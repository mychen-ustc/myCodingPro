/**
 * // 200. 岛屿数量
 * // 难度：中等
 * //
 * // 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * //
 * // 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * //
 * // 此外，你可以假设该网格的四条边均被水包围。
 * //
 * //  
 * //
 * // 示例 1：
 * //
 * // 输入：grid = [
 * // ['1','1','1','1','0'],
 * // ['1','1','0','1','0'],
 * // ['1','1','0','0','0'],
 * // ['0','0','0','0','0']
 * // ]
 * // 输出：1
 * // 示例 2：
 * //
 * // 输入：grid = [
 * // ['1','1','0','0','0'],
 * // ['1','1','0','0','0'],
 * // ['0','0','1','0','0'],
 * // ['0','0','0','1','1']
 * // ]
 * // 输出：3
 * //  
 * //
 * // 提示：
 * //
 * // m == grid.length
 * // n == grid[i].length
 * // 1 <= m, n <= 300
 * // grid[i][j] 的值为 '0' 或 '1'
 */

package com.code._8_search;

class Solution_0200_dfs {
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int numIsland = 0;
        int[][] mark = new int[grid.length][grid[0].length];  // 定义标记数组，用于标记位置是否已经被搜索
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (mark[i][j] == 0 && grid[i][j] == '1') { // 如果位置没被搜索，且为陆地，则向四周搜索
                    dfs(grid, mark, i, j);
                    numIsland++;
                }
            }
        }
        return numIsland;
    }

    public void dfs(char[][] grid, int[][] mark, int x, int y) {
        final int[] DX = {-1, 1, 0, 0};     // 方向数组的X坐标偏移量
        final int[] DY = {0, 0, -1, 1};     // 方向数组的Y坐标偏移量
        mark[x][y] = 1;     // 标记当前位置
        for (int i = 0; i < 4; i++) {
            int newx = DX[i] + x;   // 新的x坐标
            int newy = DY[i] + y;   // 新的y坐标
            if (newx < 0 || newy < 0 || newx >= mark.length || newy >= mark[newx].length) {
                continue;   // 越过边界
            }
            if (mark[newx][newy] == 0 && grid[newx][newy] == '1') {
                dfs(grid, mark, newx, newy);
            }
        }
    }
}

public class _0200_numIslands_dfs {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        Solution_0200_dfs solution = new Solution_0200_dfs();
        int result = solution.numIslands(grid);
        System.out.println(result);
    }
}
