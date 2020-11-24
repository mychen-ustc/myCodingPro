/**
 * 199. 二叉树的右视图
 * 难度：中等
// * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
// *
// * 示例:
// *
// * 输入: [1,2,3,null,5,null,4]
// * 输出: [1, 3, 4]
// * 解释:
// *
// *    1            <---
// *  /   \
// * 2     3         <---
// *  \     \
// *   5     4       <---
// *
// * 来源：力扣（LeetCode）
// * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
// * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// * 思路：层次遍历时，将节点与成熟绑定为pair，压如队列，并记录每一层出现的最后一个节点。
 */

package com.code._05_tree_graph;

import javafx.util.Pair;

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
class Solution_0199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new LinkedList<>(); // 记录每层最后一个节点
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();   // 初始化一个队列，用于存储每层的节点
        if (root != null) {
            queue.add(new Pair<>(root, 0));
        }
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();    // 取出对头
            TreeNode node = pair.getKey();  // 取当前结点
            int depth = pair.getValue();    // 节点的层
            if (view.size() == depth) { // 还没有添加当前层的结点
                view.add(node.val);
            } else {
                view.remove(view.size() - 1); // 移除已添加的当前层的结点
                view.add(node.val);
            }
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, depth + 1));   // 将左子节点添加到队列中
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, depth + 1));    // 将右子节点添加到队列中
            }
        }
        return view;
    }
}

public class _0199_rightSideView {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = e;
        c.right = d;
        Solution_0199 solution = new Solution_0199();
        List<Integer> list = solution.rightSideView(a);
        System.out.println(list);
    }
}
