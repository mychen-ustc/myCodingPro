/**
 * // 54. 二叉搜索树的第k大节点
 * // 难度：简单
 * // 给定一棵二叉搜索树，请找出其中第k大的节点。
 * //
 * // 示例 1:
 * // 输入: root = [3,1,4,null,2], residule = 1
 * //      3
 * //     / \
 * //    1   4
 * //     \
 * //      2
 * // 输出: 4
 * //
 * // 示例 2:
 * // 输入: root = [5,3,6,2,4,null,null,1], residule = 3
 * //         5
 * //        / \
 * //       3   6
 * //      / \
 * //     2   4
 * //    /
 * //   1
 * // 输出: 4
 * //
 * // 限制：
 * // 1 ≤ residule ≤ 二叉搜索树元素个数
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
class Solution_54 {
    int ans;    // 返回值
    int residule;  // 用于计数，初值为k，当递减为0时求得结果

    public int kthLargest(TreeNode root, int k) {
        // 由于中序遍历的序列是有序的，中序遍历倒序为递减序列。
        // 于是求 “二叉搜索树第 residule 大的节点” 可转化为求 “此树的中序遍历倒序的第 residule 个节点”
        residule = k;
        dfs(root);
        return ans;
    }

    void dfs(TreeNode node) {
        if (node == null || residule == 0) return;
        dfs(node.right);
        residule--;
        if (residule == 0) {
            ans = node.val;
            return;
        }
        dfs(node.left);
    }
}

public class _54_kthLargest {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.right = d;
        Solution_54 solution = new Solution_54();
        System.out.println(solution.kthLargest(a, 1));
        System.out.println(solution.kthLargest(a, 2));
        System.out.println(solution.kthLargest(a, 3));
        System.out.println(solution.kthLargest(a, 4));
    }
}
