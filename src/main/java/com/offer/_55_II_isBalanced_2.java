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
 * // 方法二：先序遍历 + 判断深度 （从顶至底）
 * // 此方法容易想到，但会产生大量重复计算，时间复杂度较高。
 * // 思路是构造一个获取当前子树的深度的函数 depth(root) （即 面试题55 - I. 二叉树的深度 ），
 * // 通过比较某子树的左右子树的深度差 abs(depth(root.left) - depth(root.right)) <= 1 是否成立，来判断某子树是否是二叉平衡树。
 * // 若所有子树都平衡，则此树平衡。
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
class Solution_55_II_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

public class _55_II_isBalanced_2 {
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
        Solution_55_II_2 solution = new Solution_55_II_2();
        boolean ans = solution.isBalanced(a);
        System.out.println(ans);
    }
}
