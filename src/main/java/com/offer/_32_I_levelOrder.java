/**
 * // 32 - I. 从上到下打印二叉树
 * // 难度：中等
 * // 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * //
 * // 例如:
 * // 给定二叉树: [3,9,20,null,null,15,7],
 * //
 * //    3
 * //   / \
 * //  9  20
 * //  /  \
 * // 15   7
 * // 返回：
 * //
 * // [3,9,20,15,7]
 * //
 * // 提示：
 * // 节点总数 <= 1000
 */

package com.offer;

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
class Solution_32_I {
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();   // 取队头
            list.add(node.val);
            if (node.left != null) {    // 将左子节点添加到队列
                queue.add(node.left);
            }
            if (node.right != null) {   // 将右子节点添加到队列
                queue.add(node.right);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }
}

public class _32_I_levelOrder {
    public static void main(String[] args) {
        // [3,9,20,null,null,15,7]
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        Solution_32_I solution = new Solution_32_I();
        int[] ans = solution.levelOrder(a);
        for (int num : ans)
            System.out.println(num);
    }
}
