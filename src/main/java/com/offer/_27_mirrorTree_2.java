/**
 * // 27. 二叉树的镜像
 * // 难度：简单
 * // 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * //
 * // 例如输入：
 * //
 * //      4
 * //    /   \
 * //   2     7
 * //  / \   / \
 * // 1   3 6   9
 * // 镜像输出：
 * //
 * //      4
 * //    /   \
 * //   7     2
 * //  / \   / \
 * // 9   6 3   1
 * //
 * // 示例 1：
 * // 输入：root = [4,2,7,1,3,6,9]
 * // 输出：[4,7,2,9,6,3,1]
 */

package com.offer;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;|
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_27_2 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;  // 把left节点先暂存起来，因为后面会切断父节点与做子树的联系
        root.left = mirrorTree(root.right);     // 递归处理右子树，设置成父节点的左孩子
        root.right = mirrorTree(left);  // 递归处理左子树，设置成父节点的右孩子
        return root;
    }

}

public class _27_mirrorTree_2 {
    public static void main(String[] args) {
//        TreeNode a = new TreeNode(4);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(7);
//        TreeNode d = new TreeNode(1);
//        TreeNode e = new TreeNode(3);
//        TreeNode f = new TreeNode(6);
//        TreeNode h = new TreeNode(9);
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        c.right = h;

        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(5);
        a.right = b;
        b.left = c;

        Solution_27_2 solution = new Solution_27_2();
        TreeNode node = solution.mirrorTree(a);
        System.out.println(node.val);
    }
}
