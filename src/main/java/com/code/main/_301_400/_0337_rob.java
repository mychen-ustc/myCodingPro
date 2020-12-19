/**
 * // 337. 打家劫舍 III
 * // 难度：中等
 * // 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * // 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * // 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * //
 * // 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * //
 * // 示例 1:
 * //
 * // 输入: [3,2,3,null,3,null,1]
 * //
 * //    3
 * //   / \
 * //  2   3
 * //   \   \
 * //    3   1
 * //
 * // 输出: 7
 * // 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * //
 * // 示例 2:
 * // 输入: [3,4,5,1,3,null,1]
 * //
 * //      3
 * //     / \
 * //    4   5
 * //   / \   \
 * //  1   3   1
 * //
 * // 输出: 9
 * // 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */

package com.code.main._301_400;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_0337 {
    public int rob(TreeNode root) {
        // 动态规划，dp[0]表示不偷根节点，dp[1]表示偷根节点
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    // 树的后续遍历，计算根节点偷或者不偷的最大总收益
    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] dp = new int[2];  // dp[0] 不偷当前节点(左右子树都可以偷)， dp[1]偷当前节点(不能偷左右子节点)
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = node.val + left[0] + right[0];
        return dp;
    }
}

public class _0337_rob {
    public static void main(String[] args) {
        // [3,2,3,null,3,null,1]
        // [3,4,5,1,3,null,1]
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        Solution_0337 solution = new Solution_0337();
        int ans = solution.rob(a);
        System.out.println(ans);
    }
}
