/**
 * // 407. 接雨水 II
 * // 难度：困难
 * //
 * // 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * //
 * // 示例：
 * //
 * // 给出如下 3x6 的高度图:
 * // [
 * // [1,4,3,1,3,2],
 * // [3,2,1,3,2,4],
 * // [2,3,3,2,3,1]
 * // ]
 * //
 * // 返回 4 。
 * // 见图1 _0407_rainwater_empty.png
 * // 如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。
 * // 见图2 _0407_rainwater_fill.png
 * // 下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。
 * // 提示：
 * //
 * // 1 <= m, n <= 110
 * // 0 <= heightMap[i][j] <= 20000
 * //
 * // 思路：
 * // 数组每一行对应的是三维空间内一行的高度，作为h轴坐标，数组的行列则用来映射x,y轴坐标
 * // 前言：可能不是最好的思路，如果有好的思路麻烦大佬们艾特我学习下！谢谢了！
 * //
 * // 接雨水I中，我们维护了左右两个最高的墙，那么在这里，就是维护周围一个圈，用堆来维护周围这一圈中的最小元素。
 * // 为什么是维护最小的元素不是最大的元素呢，因为木桶原理呀。
 * // 这个最小的元素从堆里弹出来，和它四个方向的元素去比较大小，看能不能往里灌水.
 * // 怎么灌水呢，如果用方向就比较复杂了，我们可以用visited数组来表示哪些遍历过，哪些没遍历过。
 * // 如果当前弹出来的高度比它周围的大，他就能往矮的里面灌水了，灌水后要把下一个柱子放进去的时候，放的高度要取两者较大的，也就是灌水后的高度，不是它原来矮的时候的高度了.
 * // 如果不能灌水，继续走。
 * //
 * //
 * // Given the following 3x6 height map:
 * // [
 * // [1,4,3,1,3,2],
 * // [3,2,1,3,2,4],
 * // [2,3,3,2,3,1]
 * // ]
 * // 就拿这个例子来说，我们先把第一圈都放进去，然后开始从堆中弹出，第一圈，最小值是1（遍历时候标记为访问过），1从堆里弹出来，比如弹出来1(坐标[0,3])，它下方的3没有被访问过，尝试灌水，发现不能灌水，3入堆，然后继续弹。比如说，我此时弹出来一个3（坐标[1,0]），它能向右边2(坐标[1,1])灌水，那这边就可以统计了，然后我们要插入2(坐标[1,1])这个位置，但是插入的时候，要记得你得是插入的高度得是灌水后的高度，而不是原来的高度了
 */

package com.code.list;

import java.util.PriorityQueue;

class Solution_0407 {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        // 用一个visit数组来标记这个位置有没有被访问过
        boolean[][] visit = new boolean[m][n];
        // 优先队列中存放三元组 [x,y,h] 坐标和高度
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        // 先把最外一圈放进去
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visit[i][j] = true;
                }
            }
        }
        int sum = 0;
        // 方向数组，4组偏移量对应上下左右4个方向
        int[] DX = {-1, 1, 0, 0};  // 方向数组，x轴
        int[] DY = {0, 0, -1, 1};  // 方向数组，y轴
        while (!pq.isEmpty()) {
            int[] top = pq.poll();  // 弹出堆顶
            // 看一下周围四个方向，没访问过的话能不能往里灌水
            for (int k = 0; k < 4; k++) {
                int nx = top[0] + DX[k];    // 待探索的新位置的x轴坐标
                int ny = top[1] + DY[k];    // 待探索的新位置的y轴坐标
                // 如果位置合法且没访问过
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]) {
                    // 如果外围这一圈中最小的比当前这个还高，那就说明能往里面灌水啊
                    if (top[2] > heightMap[nx][ny]) {     // 当前方向已扫描的最大高度高于当前位置的高度，可灌水
                        sum += top[2] - heightMap[nx][ny];
                    }
                    // 如果灌水高度得是你灌水后的高度了，如果没灌水也要取高的
                    pq.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], top[2])});
                    visit[nx][ny] = true;
                }
            }
        }
        return sum;
    }
}

public class _0407_trapRainWater {
    public static void main(String[] args) {
        int[][] heights = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        Solution_0407 solution = new Solution_0407();
        int sum = solution.trapRainWater(heights);
        System.out.println(sum);
    }
}
