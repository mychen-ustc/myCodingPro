/**
 * 207. 课程表
 * 难度：中等
 * <p>
 * // 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * //
 * // 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * //
 * // 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * //
 * //  
 * //
 * // 示例 1:
 * //
 * // 输入: 2, [[1,0]]
 * // 输出: true
 * // 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * // 示例 2:
 * //
 * // 输入: 2, [[1,0],[0,1]]
 * // 输出: false
 * // 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * //  
 * //
 * // 提示：
 * //
 * // 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * // 你可以假定输入的先决条件中没有重复的边。
 * // 1 <= numCourses <= 10^5
 * <p>
 * // 思路：转换成图，判断图是否有环
 */

package com.code.subject._05_tree_graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

class Solution_0207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 处理邻接关系
        for (int[] pair : prerequisites) {
            indegrees[pair[0]]++;   // 更新节点的入度
            adjacency.get(pair[1]).add(pair[0]);    // 存储边
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0)  // 将入度为0的点添加到队列中
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int startNode = queue.poll();
            numCourses -= 1;  // 减掉一门课程
            List<Integer> endNodes = adjacency.get(startNode);
            for (int i = 0; i < endNodes.size(); i++) {
                int cur = endNodes.get(i);
                indegrees[cur] -= 1;
                if (indegrees[cur] == 0)
                    queue.add(cur);
            }
        }
        return numCourses == 0;
    }
}

public class _0207_canFinish {
    public static void main(String[] args) {
        int numCourses = 3;
        int prerequisites[][] = {{1, 0}, {2, 1}, {2, 0}};
        Solution_0207 solution = new Solution_0207();
        Boolean flag = solution.canFinish(numCourses, prerequisites);
        System.out.println(flag);
    }
}
