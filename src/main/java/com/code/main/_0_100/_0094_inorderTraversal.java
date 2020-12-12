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
        // 解法1: DFS遍历
//        List<Integer> ans = new ArrayList<>();
//        recur(root, ans);
//        return ans;

        // 解法2: 迭代
//        List<Integer> ans = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {  // DFS处理左子树
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            ans.add(root.val);
//            root = root.right;  // 处理右子树
//        }
//        return ans;

        // 解法3: Morris中序遍历(参考图_0094.png)
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
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
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        Solution_0094 solution = new Solution_0094();
        List<Integer> ans = solution.inorderTraversal(a);
        System.out.println(ans);
    }
}
