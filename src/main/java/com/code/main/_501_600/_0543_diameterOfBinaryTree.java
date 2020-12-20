/**
 * // 543. 二叉树的直径
 * // 难度：简单
 * // 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * //
 * // 示例 :
 * // 给定二叉树
 * //       1
 * //      / \
 * //     2   3
 * //    / \
 * //   4   5
 * // 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * //
 * // 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */

package com.code.main._501_600;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_0543 {
    int maxLen = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 分析: 最长路径的节点数为左子树深度+右子树深度+1，路径长度为节点数-1
        // 最长路径不一定经过根节点，所以需要在计算深度的过程中记录最大路径长度
        depth(root);
        return maxLen;
    }

    // 求二叉树的最大深度
    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left + right > maxLen)
            maxLen = left + right;
        return Math.max(left, right) + 1;
    }
}

public class _0543_diameterOfBinaryTree {
    public static void main(String[] args) {
        // [1,2,3,4,5]
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        Solution_0543 solution = new Solution_0543();
        System.out.println(solution.depth(a));
        System.out.println(solution.depth(b));
        System.out.println(solution.depth(c));
        System.out.println(solution.depth(d));
        System.out.println(solution.depth(e));

        System.out.println(solution.diameterOfBinaryTree(a));
    }
}
