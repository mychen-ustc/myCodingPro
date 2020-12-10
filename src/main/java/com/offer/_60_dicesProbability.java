/**
 * // 60. n个骰子的点数
 * // 难度：中等
 * // 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * //
 * // 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * //
 * // 示例 1:
 * // 输入: 1
 * // 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * //
 * // 示例 2:
 * // 输入: 2
 * // 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * //
 * // 限制：
 * // 1 <= n <= 11
 */

package com.offer;

class Solution_60 {
    public double[] dicesProbability(int n) {
        // 动态规划：dp[i][j]表示投掷第i颗色子后，点数j出现的总次数。dp[i][j]可由dp[i-1][j-6~j-1]转化而来
        // 由于每颗色子的点数只与前一轮投掷的点数相关，可简化为用一维数组。
        int MAX_SUM = 6 * n;    // 最大点数
        double maxCnt = Math.pow((double) 6, (double) n);     // 所有可能出现的情况的总数
        int[][] dp = new int[n + 1][MAX_SUM + 1];    // 建立一个数组存储点数出现的次数，将dp[0]空出来便于理解，dp[i]表示点数i出现的次数
        for (int point = 1; point <= 6; point++) {  // 用第一颗色子的6个点数初始化
            dp[1][point] = 1;
        }
        for (int i = 2; i <= n; i++) {  // 递推求解n颗色子
            for (int j = i; j <= 6 * i; j++) {    // 递推求解每个可能出现的点数
                for (int point = 1; point <= 6; point++) {  // 由上一次的结果，计算本轮点数出现的次数
                    if (j - point < i - 1) break;   // 如果点数不合法，退出循环
                    dp[i][j] += dp[i - 1][j - point];
                }
            }
        }
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= MAX_SUM; i++) {
            ans[i - n] = (double) dp[n][i] / maxCnt;
        }
        return ans;

//        // 参考
//        int[][] dp = new int[n + 1][6 * n + 1];
//        //边界条件
//        for (int s = 1; s <= 6; s++) dp[1][s] = 1;
//        for (int i = 2; i <= n; i++) {
//            for (int s = i; s <= 6 * i; s++) {
//                //求dp[i][s]
//                for (int d = 1; d <= 6; d++) {
//                    if (s - d < i - 1) break;//为0了
//                    dp[i][s] += dp[i - 1][s - d];
//                }
//            }
//        }
//        double total = Math.pow((double) 6, (double) n);
//        double[] ans = new double[5 * n + 1];
//        for (int i = n; i <= 6 * n; i++) {
//            ans[i - n] = ((double) dp[n][i]) / total;
//        }
//        return ans;
    }
}

public class _60_dicesProbability {
    public static void main(String[] args) {
        // 1
        Solution_60 solution = new Solution_60();
        double[] ans = solution.dicesProbability(2);
        for (double num : ans) {
            System.out.println(num);
        }
    }
}
