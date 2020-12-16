/**
 * // 101. 对称二叉树
 * // 给定一个二叉树，检查它是否是镜像对称的。
 * //
 * // 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * //     1
 * //    / \
 * //   2   2
 * //  / \ / \
 * // 3  4 4  3
 * //
 * // 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * //    1
 * //   / \
 * //  2   2
 * //   \   \
 * //   3    3
 * // 进阶：
 * // 你可以运用递归和迭代两种方法解决这个问题吗？
 */

package com.code.main._101_200;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_0101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;     // 左右子节点都为空，对称
        if (left == null || right == null || left.val != right.val) return false;   // 不满足对称条件
        return judge(left.left, right.right) && judge(left.right, right.left);  // 递归比较左右子树
    }
}

public class _0101_isSymmetric {
    public static void main(String[] args) {
//        [1,2,2,3,4,4,3]
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(2);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        Solution_0101 solution = new Solution_0101();
        System.out.println(solution.isSymmetric(a));
    }
}
