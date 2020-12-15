/**
 * // 102. 二叉树的层序遍历
 * // 难度：中等
 * // 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * //
 * // 示例：
 * // 二叉树：[3,9,20,null,null,15,7],
 * //
 * //     3
 * //    / \
 * //   9  20
 * //     /  \
 * //    15   7
 * // 返回其层次遍历结果：
 * //
 * // [
 * // [3],
 * // [9,20],
 * // [15,7]
 * // ]
 */

package com.code.main._0_100;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 用一个队列实现宽度优先搜索，即得到层序遍历结果
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();  // 存储节点和层
        queue.add(new Pair<>(root, 0));    // 将根节点添加到队列中
        ans.add(new ArrayList<>());     // 添加第0层的列表
        int curDepth = 0;  // 记录上一次处理的层
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            if (depth > curDepth) {   // 如果当前层还没有处理过，先新增一个列表
                ans.add(new ArrayList<>());
                curDepth = depth;  // 更新当前处理的层
            }
            ans.get(depth).add(node.val);   // 添加当前节点的值到对应的列表中
            if (node.left != null) queue.add(new Pair<>(node.left, depth + 1));
            if (node.right != null) queue.add(new Pair<>(node.right, depth + 1));
        }
        return ans;
    }
}

public class _0102_levelOrder {

    public static void main(String[] args) {
        // [3,9,20,null,null,15,7]
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        Solution_0102 solution = new Solution_0102();
        List<List<Integer>> ans = solution.levelOrder(a);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
