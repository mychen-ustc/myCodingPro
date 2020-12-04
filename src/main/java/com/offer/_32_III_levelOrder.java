/**
 * // 32 - III. 从上到下打印二叉树 III
 * // 难度：中等
 * // 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * //
 * // 例如:
 * // 给定二叉树: [3,9,20,null,null,15,7],
 * //
 * // 3
 * // / \
 * // 9  20
 * // /  \
 * // 15   7
 * //
 * // 返回其层次遍历结果：
 * // [
 * // [3],
 * // [20,9],
 * // [15,7]
 * // ]
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
class Solution_32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}

public class _32_III_levelOrder {
    public static void main(String[] args) {
        // [3,9,20,null,null,15,7]
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        c.right = e;

        Solution_32_III solution = new Solution_32_III();
        List<List<Integer>> ans = solution.levelOrder(a);
        System.out.println(ans);
    }
}
