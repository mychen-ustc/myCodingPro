/**
 * // 29. 顺时针打印矩阵
 * // 难度：简单
 * // 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * //
 * // 示例 1：
 * // 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * // 输出：[1,2,3,6,9,8,7,4,5]
 * //
 * // 示例 2：
 * // 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * // 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * //
 * // 限制：
 * // 0 <= matrix.length <= 100
 * // 0 <= matrix[i].length <= 100
 * //
 * // 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 */

package com.offer;

class Solution_29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return new int[0];
        int n = matrix[0].length;
        int[] ans = new int[m * n];
        int i = 0, j = 0, cnt = 0;
        int DIRECTION_NUM = 4;  // 定义方向的数量为4: 右、下、左、上
        int direction = 0;
        boolean[][] visit = new boolean[m][n];  // 记录节点是否已访问
        while (cnt < m * n) {
            ans[cnt] = matrix[i][j];
            visit[i][j] = true;
            cnt++;
            if (direction % DIRECTION_NUM == 0) {   // 向右
                if (j == n - 1 || visit[i][j + 1]) { // 已达到最右侧
                    direction = (direction + 1) % DIRECTION_NUM;
                    i++;
                } else {
                    j++;
                }
            } else if (direction % DIRECTION_NUM == 1) {    // 向下
                if (i == m - 1 || visit[i + 1][j]) {   // 已达到最底部
                    direction = (direction + 1) % DIRECTION_NUM;
                    j--;
                } else {
                    i++;
                }
            } else if (direction % DIRECTION_NUM == 2) {    // 向左
                if (j == 0 || visit[i][j - 1]) {   // 已达到最左侧
                    direction = (direction + 1) % DIRECTION_NUM;
                    i--;
                } else {
                    j--;
                }
            } else {    // 向上
                if (i == 0 || visit[i - 1][j]) {
                    direction = (direction + 1) % DIRECTION_NUM;
                    j++;
                } else {
                    i--;
                }
            }

        }
        return ans;
    }
}

public class _29_spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Solution_29 solution = new Solution_29();
        int[] ans = solution.spiralOrder(matrix);
        for (int num : ans) {
            System.out.println(num);
        }
    }
}
