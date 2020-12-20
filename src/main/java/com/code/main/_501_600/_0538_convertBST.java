/**
 * // 538. 把二叉搜索树转换为累加树
 * // 难度：中等
 * // 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * //
 * // 提醒一下，二叉搜索树满足下列约束条件：
 * // 节点的左子树仅包含键 小于 节点键的节点。
 * // 节点的右子树仅包含键 大于 节点键的节点。
 * // 左右子树也必须是二叉搜索树。
 * // 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 * //
 * // 示例 1：
 * // 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * // 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * //
 * // 示例 2：
 * // 输入：root = [0,null,1]
 * // 输出：[1,null,1]
 * //
 * // 示例 3：
 * // 输入：root = [1,0,2]
 * // 输出：[3,3,2]
 * //
 * // 示例 4：
 * // 输入：root = [3,2,4,1]
 * // 输出：[7,9,4,10]
 * //  
 * //
 * // 提示：
 * // 树中的节点数介于 0 和 10^4 之间。
 * // 每个节点的值介于 -104 和 10^4 之间。
 * // 树中的所有值 互不相同 。
 * // 给定的树为二叉搜索树。
 * // Morris算法进行二叉树遍历 https://blog.csdn.net/yangfeisc/article/details/45673947
 */

package com.code.main._501_600;

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
class Solution_0538 {
    // 解法一：反序中序遍历
//    int sum = 0;  // 全局变量可以优化，将核心处理过程独立，sum作为参数
//
//    public TreeNode convertBST(TreeNode root) {
//        // 分析: 按照中序遍历序列的顺序递归求解节点的累加和
//        // 解法1: 实际操作的时候，按照中序反向执行 O(n) & O(n)
//        if (root != null) {
//            convertBST(root.right);     // 遍历右子树
//            sum += root.val;    // 处理当前节点
//            root.val = sum;
//            convertBST(root.left);  // 处理左子树
//        }
//        return root;
//    }

    // 解法2: Morris遍历
//    public TreeNode convertBST(TreeNode root) {
//        int sum = 0;
//        TreeNode cur = root;    // 当前处理节点，用于遍历二叉树
//        while (cur != null) {
//            if (cur.right == null) {   // 右子节点为空，处理当前节点，然后处理左子树
//                sum += cur.val;
//                cur.val = sum;
//                cur = cur.left;   // 处理左子树
//            } else {    // 右子节点不为空，将右子树最左节点的左指针指向当前节点，然后处理右子树
//                TreeNode succ = getSuccessor(cur);
//                if (succ.left == null) {
//                    succ.left = cur;
//                    cur = cur.right;
//                } else {
//                    succ.left = null;   // 还原最左节点的左指针（本身就是null）
//                    sum += cur.val;
//                    cur.val = sum;
//                    cur = cur.left;
//                }
//            }
//        }
//        return root;
//    }
//
//    public TreeNode getSuccessor(TreeNode node) {
//        TreeNode succ = node.right;
//        while (succ.left != null && succ.left != node) {    // 右子树最左节点不为空，且未指向当前节点
//            succ = succ.left;
//        }
//        return succ;
//    }

    // 解法1plus: 去掉全局变量，改用辅助函数和传参
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    // 递归处理: sum是当前已累积的和
    public int dfs(TreeNode node, int preval) {
        if (node == null)
            return preval;
        int rightVal = dfs(node.right, preval);   // 处理右子树
        node.val += rightVal;   // 当前节点的值加上右子节点的值
        return dfs(node.left, node.val);    // 处理左子树
    }
}

public class _0538_convertBST {
    public static void main(String[] args) {
        // [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(0);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(3);
        TreeNode i = new TreeNode(8);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;
        g.right = i;

        Solution_0538 solution = new Solution_0538();
        TreeNode node = solution.convertBST(a);
        System.out.println(node.val);
    }
}
