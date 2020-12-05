/**
 * // 34. 二叉树中和为某一值的路径
 * // 难度：中等
 * // 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * //
 * // 示例:
 * // 给定如下二叉树，以及目标和 sum = 22，
 * //      5
 * //     / \
 * //    4   8
 * //   /   / \
 * //  11  13  4
 * //  /  \    / \
 * // 7    2  5   1
 * //
 * // 返回:
 * // [
 * // [5,4,11,2],
 * // [5,8,4,5]
 * // ]
 * //
 * // 提示：
 * // 节点总数 <= 10000
 * // 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 */

package com.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        dfs(ans, path, root, sum);
        return ans;
    }

    /**
     * 递归+回溯，深度优先搜索求路径
     *
     * @param ans  结果集
     * @param path 当前处理的路径
     * @param node 当前节点
     * @param sum  当前需要处理的目标和
     */
    public void dfs(List<List<Integer>> ans, Stack<Integer> path, TreeNode node, int sum) {
        if (node == null)
            return;
        path.push(node.val);    // 将当前节点添加到路径中
        sum -= node.val;    // 将目标和减去当前节点的值
        if (node.left == null && node.right == null && sum == 0) {   // 如果当前节点为叶子节点，并且目标和为0，则满足要求
            ans.add(new ArrayList<>(path));     // 将当前路径添加到结果集
        }
        dfs(ans, path, node.left, sum);     // 递归求解子树
        dfs(ans, path, node.right, sum);    // 递归求解子树

        path.pop();     // 弹出当前节点，进行回溯
    }
}

public class _34_pathSum {
    public static void main(String[] args) {
        // [5,4,8,11,null,13,4,7,2,null,null,5,1]
        // 22
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        f.left = i;
        f.right = j;
        Solution_34 solution = new Solution_34();
        List<List<Integer>> res = solution.pathSum(a, 22);
        System.out.println(res);
    }
}
