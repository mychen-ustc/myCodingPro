/**
 * // 437. 路径总和 III
 * // 难度：中等
 * //
 * // 给定一个二叉树，它的每个结点都存放着一个整数值。
 * // 找出路径和等于给定数值的路径总数。
 * //
 * // 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * //
 * // 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * //
 * // 示例：
 * // root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * //
 * //        10
 * //       /  \
 * //      5   -3
 * //     / \    \
 * //    3   2   11
 * //   / \   \
 * //   3  -2   1
 * //
 * // 返回 3。和等于 8 的路径有:
 * // 1.  5 -> 3
 * // 2.  5 -> 2 -> 1
 * // 3.  -3 -> 11
 */

package com.code.main._401_500;

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
class Solution_0437 {
    public int pathSum(TreeNode root, int sum) {
        int ans = dfs(root, sum, sum);
        return ans;
    }

    // 深度优先遍历寻找路径
    public int dfs(TreeNode node, int sum, int target) {
        if (node == null) return 0;
        if (node.val == target) return 1;
        // 包含当前结点
        int leftWithRoot = dfs(node.left, sum, target - node.val);
        int rightWithRoot = dfs(node.right, sum, target - node.val);
        // 不包含当前结点(从字节点开始查找)
        int left = dfs(node.left, sum, sum);
        int right = dfs(node.right, sum, sum);
        return leftWithRoot + rightWithRoot + left + right;
    }
}

public class _0437_pathSum {
    public static void main(String[] args) {
        Solution_0437 solution = new Solution_0437();

        // [10,5,-3,3,2,null,11,3,-2,null,1] 8
//        TreeNode a = new TreeNode(10);
//        TreeNode b = new TreeNode(5);
//        TreeNode c = new TreeNode(-3);
//        TreeNode d = new TreeNode(3);
//        TreeNode e = new TreeNode(2);
//        TreeNode f = new TreeNode(11);
//        TreeNode g = new TreeNode(3);
//        TreeNode h = new TreeNode(-2);
//        TreeNode i = new TreeNode(1);
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.right = f;
//        d.left = g;
//        d.right = h;
//        e.right = i;
//        System.out.println(solution.pathSum(a, 8));

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(-2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        b.right = c;
        System.out.println(solution.pathSum(a, 3));
    }
}
