/**
 * // 26. 树的子结构
 * // 难度：中等
 * // 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * //
 * // B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * //
 * // 例如:
 * // 给定的树 A:
 * //
 * //      3
 * //     / \
 * //    4   5
 * //   / \
 * //  1   2
 * // 给定的树 B：
 * //
 * //    4 
 * //   /
 * //  1
 * // 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * //
 * // 示例 1：
 * // 输入：A = [1,2,3], B = [3,1]
 * // 输出：false
 * //
 * // 示例 2：
 * // 输入：A = [3,4,5,1,2], B = [4,1]
 * // 输出：true
 * //
 * // 限制：
 * // 0 <= 节点个数 <= 10000
 */

package com.offer;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)     // 如果某棵树为空，返回false
            return false;

        return judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 从当前节点开始判断是否满足条件
    boolean judge(TreeNode A, TreeNode B) {
        if (B == null)  // B节点已经遍历完，返回true
            return true;
        if (A == null || A.val != B.val)    // 如果A节点都比较完了，或者当前根节点值不同，返回false
            return false;
        return judge(A.left, B.left) && judge(A.right, B.right);    // 判断左右子树是否满足条件
    }
}

public class _26_isSubStructure {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(3);
        TreeNode b1 = new TreeNode(4);
        TreeNode c1 = new TreeNode(5);
        TreeNode d1 = new TreeNode(1);
        TreeNode e1 = new TreeNode(2);
        a1.left = b1;
        a1.right = c1;
        b1.left = d1;
        b1.right = e1;

        TreeNode a2 = new TreeNode(4);
        TreeNode b2 = new TreeNode(1);
        a2.left = b2;

        Solution_26 solution = new Solution_26();
        boolean ans = solution.isSubStructure(a1, a2);
        System.out.println(ans);
    }
}
