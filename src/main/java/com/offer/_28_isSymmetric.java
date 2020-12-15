/**
 * // 28. 对称的二叉树
 * // 难度：简单
 * // 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * //
 * // 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * //
 * //     1
 * //    / \
 * //   2   2
 * //  / \ / \
 * // 3  4 4  3
 * //
 * // 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * //
 * //     1
 * //    / \
 * //   2   2
 * //    \   \
 * //    3    3
 * //
 * // 示例 1：
 * // 输入：root = [1,2,2,3,4,4,3]
 * // 输出：true
 * //
 * // 示例 2：
 * // 输入：root = [1,2,2,null,3,null,3]
 * // 输出：false
 * //
 * // 限制：
 * // 0 <= 节点个数 <= 1000
 * //
 * // 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
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
class Solution_28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return judge(root.left, root.right);
    }

    boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)     // 不满足对称条件
            return false;
        return judge(left.left, right.right) && judge(left.right, right.left);  // 递归比较子节点
    }
}

public class _28_isSymmetric {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        Solution_28 solution = new Solution_28();
        boolean ans = solution.isSymmetric(a);
        System.out.println(ans);
    }
}
