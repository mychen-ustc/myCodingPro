/**
 * // 04. 二维数组中的查找
 * // 难度：中等
 * // 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * //
 * // 示例:
 * //
 * // 现有矩阵 matrix 如下：
 * //
 * // [
 * // [1,   4,  7, 11, 15],
 * // [2,   5,  8, 12, 19],
 * // [3,   6,  9, 16, 22],
 * // [10, 13, 14, 17, 24],
 * // [18, 21, 23, 26, 30]
 * // ]
 * // 给定 target = 5，返回 true。
 * //
 * // 给定 target = 20，返回 false。
 */

package com.offer;

class Solution_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        int i = 0, j = col - 1;     // 从右上角开始查找，逐步排除行或列，缩小查找范围
        boolean exist = false;
        while (i < row && j < col & i >= 0 && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {    // 当前右上角数字大于target，则不可能在下方，排除当前列
                j--;
            } else if (matrix[i][j] < target) {    // 当前右上角数字小于target，则不可能在上方，排除当前行
                i++;
            }
        }
        return exist;
    }
}

public class _04_findNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int targer = 20;
        Solution_04 solution = new Solution_04();
        boolean ans = solution.findNumberIn2DArray(matrix, targer);
        System.out.println(ans);
    }
}
