/**
 * // 104. 二叉树的最大深度
 * // 难度：简单
 * // 给定一个二叉树，找出其最大深度。
 * //
 * // 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * //
 * // 说明: 叶子节点是指没有子节点的节点。
 * //
 * // 示例：
 * // 给定二叉树 [3,9,20,null,null,15,7]，
 * //    3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * // 返回它的最大深度 3 。
 */

package com.code.main._0_100;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution_0104 {
    public int maxDepth(TreeNode root) {
        // 可用DFS或BFS遍历，统计最大层
        // BFS解法: 非递归
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int maxDepth = 0;
//        while (!queue.isEmpty()) {
//            int curLevelCnt = queue.size();
//            for (int i = 0; i < curLevelCnt; i++) {   // 把队列中，当前层的元素全部处理完
//                TreeNode node = queue.poll();
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//            }
//            maxDepth++;
//        }
//        return maxDepth;

        // DFS解法：递归，实测递归的解法效率更高（100% vs 16%, 0ms vs 1ms）
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}

public class _0104_maxDepth {
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

        Solution_0104 solution = new Solution_0104();
        int ans = solution.maxDepth(a);
        System.out.println(ans);
    }
}
