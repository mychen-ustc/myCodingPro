/**
 * // 68 - I. 二叉搜索树的最近公共祖先
 * // 难度：简单
 * // 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * //
 * // 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * //
 * // 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * //
 * // 示例 1:
 * // 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * // 输出: 6
 * // 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * //
 * // 示例 2:
 * // 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * // 输出: 2
 * // 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * //
 * // 说明:
 * // 所有节点的值都是唯一的。
 * // p、q 为不同节点且均存在于给定的二叉搜索树中。
 * // 注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
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
class Solution_68_I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 循环判断
//        while (root != null) {
//            if (p.val < root.val && q.val < root.val) {     // 都在左子树
//                root = root.left;
//            } else if (p.val > root.val && q.val > root.val) {      // 都在右子树
//                root = root.right;
//            } else {    // 分别在左右子树，当前节点就是祖先
//                return root;
//            }
//        }
//        return root;

        // 递归判断
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);   // 左子树
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);  // 右子树
        } else {
            return root;
        }
    }
}

public class _68_I_lowestCommonAncestor {
    public static void main(String[] args) {
//        [6,2,8,0,4,7,9,null,null,3,5] 2 8
    }
}
