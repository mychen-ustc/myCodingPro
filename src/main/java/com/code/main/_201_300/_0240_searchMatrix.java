/**
 * // 240. 搜索二维矩阵 II
 * // 难度：中等
 * // 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * //
 * // 每行的元素从左到右升序排列。
 * // 每列的元素从上到下升序排列。
 * //
 * // 示例 1：
 * // 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * // 输出：true
 * //
 * // 示例 2：
 * // 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * // 输出：false
 * //
 * // 提示：
 * // m == matrix.length
 * // n == matrix[i].length
 * // 1 <= n, m <= 300
 * // -10^9 <= matix[i][j] <= 10^9
 * // 每行的所有元素从左到右升序排列
 * // 每列的所有元素从上到下升序排列
 * // -10^9 <= target <= 10^9
 * //
 * // 在剑指offer中有类似题目: 思路是用右上角的数字比较，如果数字大于target则排除当前列，小于target则排除当前行
 */

package com.code.main._201_300;

class Solution_0240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 以右上角的数字为准，跟target比较，决定是排除列还是行
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;   // 从第一行，最后一列开始搜索
        while (i >= 0 && j >= 0 && i < m && j < n) {
            int num = matrix[i][j];
            if (num == target) {   // 第1种情况: 查找成功
                return true;
            } else if (num > target) {  // 第2种情况: 当前列的元素都比目标大，可排除当前列
                j--;    // 排除当前列
            } else {    // 第3种情况: 当前行的元素都比目标小，可排除当前行
                i++;
            }
        }
        return false;
    }
}

public class _0240_searchMatrix {
    public static void main(String[] args) {
        // [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]] 5
        Solution_0240 solution = new Solution_0240();

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
//        System.out.println(solution.searchMatrix(matrix, 5));
//        System.out.println(solution.searchMatrix(matrix, 15));
//        System.out.println(solution.searchMatrix(matrix, 25));
//        System.out.println(solution.searchMatrix(matrix, 35));
//        System.out.println(solution.searchMatrix(matrix, 45));

        int[][] matrix2 = {{-1, 3}};
        System.out.println(solution.searchMatrix(matrix2, 3));
    }
}
