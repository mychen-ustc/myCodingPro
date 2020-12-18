/**
 * // 226. 翻转二叉树
 * // 难度：简单
 * // 翻转一棵二叉树。
 * //
 * // 示例：
 * // 输入：
 * //      4
 * //    /   \
 * //   2     7
 * //  / \   / \
 * // 1   3 6   9
 * //
 * // 输出：
 * //      4
 * //    /   \
 * //   7     2
 * //  / \   / \
 * // 9   6 3   1
 * // 备注:
 * // 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * //
 * // 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */

package com.code.main._201_300;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_0226 {
    public TreeNode invertTree(TreeNode root) {
//        if (root == null || (root.left == null && root.right == null))  // 节点为空或者左右子树都为空
//            return root;
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        if (root.left == null) {    // 左子树为空，右子树不为空
//            root.left = right;
//            root.right = null;
//        } else if (root.right == null) {    // 右子树为空，左子树不为空
//            root.right = left;
//            root.left = null;
//        } else {    // 左右子树都不空
//            root.left = right;
//            root.right = left;
//        }
//        return root;

        // 代码简化: 上面的逻辑判断都可以省掉，只要一个root == null分支即可
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

public class _0226_invertTree {
    public static void main(String[] args) {
        // [4,2,7,1,3,6,9]
//        TreeNode a = new TreeNode(4);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(7);
//        TreeNode d = new TreeNode(1);
//        TreeNode e = new TreeNode(3);
//        TreeNode f = new TreeNode(6);
//        TreeNode g = new TreeNode(9);
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        c.right = g;

        // [1,2]
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;

        Solution_0226 solution = new Solution_0226();
        TreeNode root = solution.invertTree(a);
    }
}
