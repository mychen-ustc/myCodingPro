/**
 * // 32 - II. 从上到下打印二叉树 II
 * // 难度：简单
 * // 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * //
 * // 例如:
 * // 给定二叉树: [3,9,20,null,null,15,7],
 * //
 * // 3
 * // / \
 * // 9  20
 * // /  \
 * // 15   7
 * //
 * // 返回其层次遍历结果：
 * //
 * // [
 * // [3],
 * // [9,20],
 * // [15,7]
 * // ]
 * //
 * // 提示：
 * // 节点总数 <= 1000
 * // 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */

package com.offer;

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
class Solution_32_II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();   // 用pair存储节点和层
        if (root == null) {
            return ans;
        }
        queue.add(new Pair(root, 0));   // 将根节点添加到队列
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();     // 取队头
            TreeNode node = pair.getKey();  // 获取节点
            int depth = pair.getValue();
            if (ans.size() < depth + 1) {  // 当前层的列表尚未生成，先添加一个列表
                ans.add(new ArrayList<>());
            }
            ans.get(depth).add(node.val);

            if (node.left != null) {
                queue.add(new Pair(node.left, depth + 1));  // 左子节点入队列
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, depth + 1));    // 右子节点入队列
            }
        }
        return ans;
    }
}

public class _32_II_levelOrder {
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

        Solution_32_II solution = new Solution_32_II();
        List<List<Integer>> ans = solution.levelOrder(a);
        System.out.println(ans);
    }
}
