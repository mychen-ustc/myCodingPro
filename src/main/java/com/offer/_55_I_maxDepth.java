/**
 * // 55 - I. 二叉树的深度
 * // 难度：简单
 * // 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * //
 * // 例如：
 * // 给定二叉树 [3,9,20,null,null,15,7]，
 * //
 * //      3
 * //     / \
 * //    9  20
 * //      /  \
 * //     15   7
 * // 返回它的最大深度 3 。
 * //
 * // 提示：
 * // 节点总数 <= 10000
 * // 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */

package com.offer;

import javafx.util.Pair;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_55_I {
    public int maxDepth(TreeNode root) {
        // 解法1：用栈存储节点和层，效率较低
//        if (root == null) {
//            return 0;
//        }
//        int maxDepth = 0;
//        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();  // 定义栈，存储节点用于深度优先搜索，并保存节点深度
//        stack.push(new Pair<>(root, 1));
//        while (!stack.isEmpty()) {
//            Pair pair = stack.pop();    // 取栈顶
//            TreeNode node = (TreeNode) pair.getKey();
//            int depth = (int) pair.getValue();
//            if (node.left == null && node.right == null) {
//                if (depth > maxDepth)
//                    maxDepth = depth;
//            } else {
//                if (node.left != null)
//                    stack.push(new Pair<>(node.left, depth + 1));
//                if (node.right != null)
//                    stack.push(new Pair<>(node.right, depth + 1));
//            }
//        }
//        return maxDepth;

        // 解法2：
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

public class _55_I_maxDepth {
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
        Solution_55_I solution = new Solution_55_I();
        int ans = solution.maxDepth(a);
        System.out.println(ans);

    }
}
