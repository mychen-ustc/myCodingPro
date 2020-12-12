/**
 * // 174. 地下城游戏
 * // 难度：困难
 * // 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * //
 * // 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * //
 * // 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * //
 * // 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * //
 * //  
 * //
 * // 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * //
 * // 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * //
 * // -2 (K)	-3	    3
 * // -5	   -10	    1
 * // 10	    30	    -5 (P)
 * //
 * // 说明:
 * //
 * // 骑士的健康点数没有上限。
 * //
 * // 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * //
 * // 解决思路类比64题
 * // 思路：
 * // 如果从左上向右下递推：没办法将“每个格子最多能获得多少血量”转换成初始时至少是多少血量。
 * // 改为从右下往左上递推：
 * // dp[i][j]代表如果要达到右下角，至少有多少血量，能在行走的过程中至少保持生命值为1
 * // 1.分析：若地牢数组为1*1的，dp[0][0]=max(1, 1-c[0][0])，用c表示地牢二维数组（写起来简便一点）
 * //            如果地牢数组为 1*n或n*1的：
 * //               1*n, i从n-2递推至0: dp[0][i] = max(1, dp[0][i+1]-c[0][i])
 * //               n*1，i从n-2递推至0: dp[i][0] = max(1, dp[i+1][0]-c[i][0])
 * // 2.边界条件&初始化：
 * //   右下角初始化 dp[m-1][n-1] = max(1, 1-c[m-1][n-1])
 * //   最后一行初始化 dp[m-1][i] = max(1,dp[m-1][i+1]-c[m-1[]i]), i从m-2到0
 * //   最后一列初始化 dp[i][n-1] = max(1,dp[i+1][n-1]-c[i][n-1]), i从n-2到0
 * // 3.如果代表地牢的二维数组为m*n的
 * //    dp_min = min(dp[i+1][j], dp[i][j+1)
 * //    dp[i][j] = max(1, dp_min - c[i][j])
 */

package com.code.subject._09_dynamic_program;

class Solution_0174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        if (row == 0) return 0;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = Math.max(1, 1 - dungeon[row - 1][col - 1]);  // 边界条件：初始化右下角
        for (int j = col - 2; j >= 0; j--) {    // 边界条件：初始化最后一行，倒数第2个位置到第0个位置
            dp[row - 1][j] = Math.max(1, dp[row - 1][j + 1] - dungeon[row - 1][j]);
        }
        for (int i = row - 2; i >= 0; i--) {    // 边界条件：初始化最后一列，倒数第2个位置到第0个位置
            dp[i][col - 1] = Math.max(1, dp[i + 1][col - 1] - dungeon[i][col - 1]);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                int dp_min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, dp_min - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}

public class _0174_calculateMinimumHP {
    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        Solution_0174 solution = new Solution_0174();
        int min = solution.calculateMinimumHP(dungeon);
        System.out.println(min);
    }
}
