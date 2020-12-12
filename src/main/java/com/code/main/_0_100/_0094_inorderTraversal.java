/**
 * // 94. 二叉树的中序遍历
 * // 难度：中等
 * // 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * //
 * // 示例 1：
 * // 输入：root = [1,null,2,3]
 * // 输出：[1,3,2]
 * //
 * // 示例 2：
 * // 输入：root = []
 * // 输出：[]
 * //
 * // 示例 3：
 * // 输入：root = [1]
 * // 输出：[1]
 * //
 * // 示例 4：
 * // 输入：root = [1,2]
 * // 输出：[2,1]
 * //
 * // 示例 5：
 * // 输入：root = [1,null,2]
 * // 输出：[1,2]
 * //
 * // 提示：
 * // 树中节点数目在范围 [0, 100] 内
 * // -100 <= Node.val <= 100
 * //
 * // 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

package com.code.main._0_100;

import java.util.ArrayList;
import java.util.List;

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
class Solution_0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recur(root, ans);
        return ans;
    }

    // 递归DFS遍历子树
    void recur(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        recur(node.left, ans);  // 遍历左子树
        ans.add(node.val);
        recur(node.right, ans);     // 遍历右子树
    }
}

public class _0094_inorderTraversal {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;
        Solution_0094 solution = new Solution_0094();
        List<Integer> ans = solution.inorderTraversal(a);
        System.out.println(ans);
    }
}
