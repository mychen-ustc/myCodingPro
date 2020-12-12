/**
 * 114. 二叉树展开为链表
 * 难度：中等
 * // 给定一个二叉树，原地将它展开为一个单链表。
 * //
 * //  
 * //
 * // 例如，给定二叉树
 * //
 * //     1
 * //    / \
 * //   2   5
 * //  / \   \
 * // 3   4   6
 * // 将其展开为：
 * //
 * // 1
 * //  \
 * //   2
 * //    \
 * //     3
 * //      \
 * //       4
 * //        \
 * //         5
 * //          \
 * //           6
 * //
 */

package com.code.subject._05_tree_graph;

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

class Solution_0114 {
    public void flatten(TreeNode root) {
        TreeNode last = null;
        preorder(root);   // 当前子树的先序遍历的最后一个节点，传引用会传出来
    }

    public TreeNode preorder(TreeNode node) {
        TreeNode last = null;
        if (node == null)
            return null;
        if (node.left == null && node.right == null) {
            last = node;
        }
        TreeNode left = node.left;  // 备份左子节点的引用
        TreeNode right = node.right;    // 备份右子节点的引用
        TreeNode leftLast = null;   // 左子树最后一个节点
        TreeNode rightLast = null;  // 右子树最后一个节点
        if (left != null) { // 左子树不为空
            leftLast = preorder(left);   // 递归展开左子树
            node.left = null;   // 左子树置为空
            node.right = left;  // 将左子树首节点设置为右孩子
            last = leftLast;    // 将该节点的last设置成左子树的最后一个节点
        }
        if (right != null) {
            rightLast = preorder(right); // 递归展开右子树
            if (leftLast != null) { // 左子树不为空，要把右子树接到左子树后面
                leftLast.right = right;
            }
            last = rightLast;
        }
        return last;
    }
}

public class _0114_flatten {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = e;
        b.left = c;
        b.right = d;
        e.right = f;
        Solution_0114 solution = new Solution_0114();
        solution.flatten(a);
        System.out.println(a);
    }
}
