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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        // 分析：不能偷相邻的2层，但是可以一次偷整层的所有房屋，先计算每层的金额总数，构建一个数组
        List<Integer> moneys = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;     // 如果输入为空，返回0
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int money = 0;
            for (int i = 0; i < size; i++) {    // 遍历一层
                TreeNode node = queue.poll();
                money += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            moneys.add(money);
        }
        // 基于金额数组计算最大总额: 动态规划 dp[i] 表示截止到第i家时的最大金额
        int len = moneys.size();
        int[] dp = new int[moneys.size()];
        dp[0] = moneys.get(0);
        if (len == 1) return dp[0];
        dp[1] = moneys.get(1);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + moneys.get(i), dp[i - 1]);     // 有2种选择：偷第i家和不偷第i家
        }

        return Math.max(dp[len - 2], dp[len - 1]);
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
