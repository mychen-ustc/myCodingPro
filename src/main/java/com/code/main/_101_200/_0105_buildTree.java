/**
 * // 105. 从前序与中序遍历序列构造二叉树
 * // 难度：中等
 * // 根据一棵树的前序遍历与中序遍历构造二叉树。
 * //
 * // 注意:
 * // 你可以假设树中没有重复的元素。
 * //
 * // 例如，给出
 * //
 * // 前序遍历 preorder = [3,9,20,15,7]
 * // 中序遍历 inorder = [9,3,15,20,7]
 * // 返回如下的二叉树：
 * //
 * //    3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 */

package com.code.main._101_200;

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
class Solution_0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        // 由于没有重复元素，可以将其中一棵树的所有结点的索引存放到hashmap。
        // 前序遍历直接能知道根节点，所以将中序遍历做索引，辅助前序遍历划分左右子树
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);  // 建立数值到中序遍历序号的映射
        }
        TreeNode root = buildProcess(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
        return root;
    }

    public TreeNode buildProcess(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd) {   // 序列只剩一个结点
            return root;
        } else {
            int rootIndex = inorderMap.get(rootVal);    // 获取根节点的索引
            int leftNodeCnt = rootIndex - inStart;     // 左子树节点数
            int rightNodeCnt = inEnd - rootIndex;
            TreeNode leftRoot = buildProcess(preorder, preStart + 1, preStart + leftNodeCnt, inStart, rootIndex - 1, inorderMap);
            TreeNode rightRoot = buildProcess(preorder, preEnd - rightNodeCnt + 1, preEnd, rootIndex + 1, inEnd, inorderMap);
            root.left = leftRoot;
            root.right = rightRoot;
            return root;
        }
    }
}

public class _0105_buildTree {
    public static void main(String[] args) {
        // [3,9,20,15,7] [9,3,15,20,7]
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Solution_0105 solution = new Solution_0105();
        TreeNode root = solution.buildTree(preorder, inorder);
    }
}
