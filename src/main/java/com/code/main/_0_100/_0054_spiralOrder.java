/**
 * // 54. 螺旋矩阵
 * // 难度：中等
 * // 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * //
 * // 示例 1:
 * //
 * // 输入:
 * // [
 * // [ 1, 2, 3 ],
 * // [ 4, 5, 6 ],
 * // [ 7, 8, 9 ]
 * // ]
 * // 输出: [1,2,3,6,9,8,7,4,5]
 * // 示例 2:
 * //
 * // 输入:
 * // [
 * // [1, 2, 3, 4],
 * // [5, 6, 7, 8],
 * // [9,10,11,12]
 * // ]
 * // 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

package com.code.main._0_100;

import java.util.ArrayList;
import java.util.List;

class Solution_0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) return list;
        int col = matrix[0].length;
        boolean[][] visit = new boolean[row][col];  // 访问数组，记录某个位置是否已经访问
        int DIRECTION_NUM = 4;
        int direction = 0;  // 0向右，1向下，2向左，3向上，循环处理
        int cnt = 0;    // 计算已经遍历了多少个
        for (int i = 0, j = 0; ; ) {
            if (cnt >= row * col)
                break;
            if (visit[i][j]) {
                continue;
            }
            list.add(matrix[i][j]);
            cnt++;
            visit[i][j] = true;
            switch (direction % DIRECTION_NUM) {
                case 0:     // 向右
                    if (j + 1 >= col || visit[i][j + 1]) {
                        direction = 1;    // 已经到最右端，改为向下
                        i++;
                    } else {
                        j++;    // 继续往右边走
                    }
                    break;
                case 1:     // 向下
                    if (i + 1 >= row || visit[i + 1][j]) {
                        direction = 2;    // 已经到最底部，改为向左
                        j--;
                    } else {
                        i++;    // 继续向下走
                    }
                    break;
                case 2:     // 向左
                    if (j - 1 < 0 || visit[i][j - 1]) {
                        direction = 3;    // 已经到最左边，改为向上
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case 3:     // 向上
                    if (i - 1 < 0 || visit[i - 1][j]) {
                        direction = 0;    // 已经到最上方，改为向右
                        j++;
                    } else {
                        i--;
                    }
                    break;
                default:
                    break;
            }
        }
        return list;
    }
}

public class _0054_spiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Solution_0054 solution = new Solution_0054();
        List<Integer> list = solution.spiralOrder(matrix);
        System.out.println(list);
    }
}
