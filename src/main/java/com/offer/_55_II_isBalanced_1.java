/**
 * // 55 - II. 平衡二叉树
 * // 难度：简单
 * // 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * //
 * // 示例 1:
 * // 给定二叉树 [3,9,20,null,null,15,7]
 * //
 * //       3
 * //      / \
 * //     9  20
 * //       /  \
 * //      15   7
 * // 返回 true 。
 * //
 * // 示例 2:
 * // 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * //
 * //           1
 * //          / \
 * //         2   2
 * //        / \
 * //       3   3
 * //      / \
 * //     4   4
 * // 返回 false 。
 * //
 * // 限制：
 * // 1 <= 树的结点个数 <= 10000
 * //
 * // 方法一：后序遍历 + 剪枝 （从底至顶）
 * // 此方法为本题的最优解法，但剪枝的方法不易第一时间想到。
 * // 思路是对二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
 */

package com.offer;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_55_II_1 {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    // 求深度，以及判断是否为二叉平衡树：如果不是二叉平衡树返回-1，否则返回深度
    int recur(TreeNode root) {
        if (root == null)
            return 0;
        int left = recur(root.left);
        if (left == -1)
            return -1;
        int right = recur(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}

public class _55_II_isBalanced_1 {
    public static void main(String[] args) {
        // [3,9,20,null,null,15,7]
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
        Solution_55_II_1 solution = new Solution_55_II_1();
        boolean ans = solution.isBalanced(a);
        System.out.println(ans);
    }
}
