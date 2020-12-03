/**
 * // 27. 二叉树的镜像
 * // 难度：简单
 * // 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * //
 * // 例如输入：
 * //
 * //      4
 * //    /   \
 * //   2     7
 * //  / \   / \
 * // 1   3 6   9
 * // 镜像输出：
 * //
 * //      4
 * //    /   \
 * //   7     2
 * //  / \   / \
 * // 9   6 3   1
 * //
 * // 示例 1：
 * // 输入：root = [4,2,7,1,3,6,9]
 * // 输出：[4,7,2,9,6,3,1]
 */

package com.offer;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;|
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode ans = handleTree(root);
        return ans;
    }

    // 处理二叉树：递归交换左右子节点
    public TreeNode handleTree(TreeNode node) {
        if (node.left == null && node.right == null)    // 左右子树都为空，直接返回
            return node;
        if (node.left == null && node.right != null) {  // 做子树为空，先递归处理右子树，然后设置成左子树
            node.left = handleTree(node.right);
            node.right = null;
            return node;
        }
        if (node.right == null && node.left != null) {  // 右子树为空，先递归处理做子树，然后设置成右子树
            node.right = handleTree(node.left);
            node.left = null;
            return node;
        }
        TreeNode left = handleTree(node.left);
        TreeNode right = handleTree(node.right);
        node.left = right;
        node.right = left;
        return node;
    }
}

public class _27_mirrorTree {
    public static void main(String[] args) {
//        TreeNode a = new TreeNode(4);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(7);
//        TreeNode d = new TreeNode(1);
//        TreeNode e = new TreeNode(3);
//        TreeNode f = new TreeNode(6);
//        TreeNode h = new TreeNode(9);
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        c.right = h;

        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(5);
        a.right = b;
        b.left = c;

        Solution_27 solution = new Solution_27();
        TreeNode node = solution.mirrorTree(a);
        System.out.println(node.val);
    }
}
