/**
 * // 07. 重建二叉树
 * // 难度：中等
 * // 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * //
 * // 例如，给出
 * //
 * // 前序遍历 preorder = [3,9,20,15,7]
 * // 中序遍历 inorder = [9,3,15,20,7]
 * // 返回如下的二叉树：
 * //
 * // 3
 * // / \
 * // 9  20
 * // /  \
 * // 15   7
 * //
 * // 限制：
 * //
 * // 0 <= 节点个数 <= 5000
 */

package com.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);     // 构建数字在中序遍历中的序号映射
        }
        TreeNode root = buildTreeProcess(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
        return root;
    }

    TreeNode buildTreeProcess(int[] preorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd, Map<Integer, Integer> inorderMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];  // 前序遍历第一个节点即为根节点
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) { // 当前要处理的前序遍历序列只有1个节点
            return root;
        } else {
            int rootIndex = inorderMap.get(rootVal);   // 获取根节点在中序遍历中的序号
            int leftNodeCnt = rootIndex - inorderStart;     // 左子树的节点个数
            int rightNodeCnt = inorderEnd - rootIndex;      // 右子树的节点个数
            TreeNode leftSubTree = buildTreeProcess(preorder, preorderStart + 1, preorderStart + leftNodeCnt, inorderStart, rootIndex - 1, inorderMap);
            TreeNode rightSubTree = buildTreeProcess(preorder, preorderEnd - rightNodeCnt + 1, preorderEnd, rootIndex + 1, inorderEnd, inorderMap);
            root.left = leftSubTree;
            root.right = rightSubTree;
            return root;
        }
    }
}

public class _07_buildTree {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int[] inorder = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        Solution_07 solution = new Solution_07();
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println(root);
    }
}
