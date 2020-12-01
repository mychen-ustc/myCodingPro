/**
 * // 13. 机器人的运动范围
 * // 难度：中等
 * // 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * //
 * // 示例 1：
 * //
 * // 输入：m = 2, n = 3, k = 1
 * // 输出：3
 * // 示例 2：
 * //
 * // 输入：m = 3, n = 1, k = 0
 * // 输出：1
 * //
 * // 提示：
 * // 1 <= n,m <= 100
 * // 0 <= k <= 20
 */

package com.offer;

import java.util.LinkedList;
import java.util.Queue;

class Solution_13 {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        //方向数组
        int[] dx = {0, 1}, dy = {1, 0};
        boolean[][] visit = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        visit[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];
                if (newx < 0 || newx >= m || newy < 0 || newy >= n || visit[newx][newy] || bitSum(newx) + bitSum(newy) > k) {
                    continue;
                }
                queue.offer(new int[]{newx, newy});
                visit[newx][newy] = true;
                ans++;
            }
        }
        return ans;
    }

    /**
     * 计算数位之和
     *
     * @param num
     * @return
     */
    int bitSum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;    // 累计余数
            num /= 10;  // num丢掉最低位
        }
        return res;
    }
}

public class _13_movingCount {
    public static void main(String[] args) {
        Solution_13 solution = new Solution_13();
        int ans = solution.movingCount(2, 3, 3);
        System.out.println(ans);
        System.out.println(solution.bitSum(123));
    }
}
