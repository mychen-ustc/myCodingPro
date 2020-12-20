/**
 * // 437. 路径总和 III
 * // 难度：中等
 * //
 * // 给定一个二叉树，它的每个结点都存放着一个整数值。
 * // 找出路径和等于给定数值的路径总数。
 * //
 * // 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * //
 * // 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * //
 * // 示例：
 * // root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * //
 * //        10
 * //       /  \
 * //      5   -3
 * //     / \    \
 * //    3   2   11
 * //   / \   \
 * //   3  -2   1
 * //
 * // 返回 3。和等于 8 的路径有:
 * // 1.  5 -> 3
 * // 2.  5 -> 2 -> 1
 * // 3.  -3 -> 11
 */

package com.code.main._401_500;

import java.util.HashMap;
import java.util.Map;

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
class Solution_0437_2 {
    public int pathSum(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 前缀和为0的一条路径
        prefixSumCount.put(0, 1);
        // 前缀和的递归回溯思路
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }

    /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     *
     * @param node           树节点
     * @param prefixSumCount 前缀和Map
     * @param target         目标值
     * @param curSum         当前路径和
     * @return 满足题意的解
     */
    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int curSum) {
        // 1.递归终止条件
        if (node == null) {
            return 0;
        }
        // 2.本层要做的事情
        int res = 0;
        // 当前路径上的和
        curSum += node.val;

        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixSumCount.getOrDefault(curSum - target, 0);     // 当前层的解数量
        // 更新路径上当前节点前缀和的个数
        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);
        //---核心代码

        // 3.进入下一层
        res += recursionPathSum(node.left, prefixSumCount, target, curSum);     // 左子树的解数量
        res += recursionPathSum(node.right, prefixSumCount, target, curSum);    // 右子树的解数量

        // 4.回到本层，恢复状态，去除当前节点的前缀和数量，进行回溯
        prefixSumCount.put(curSum, prefixSumCount.get(curSum) - 1);
        return res;
    }
}

public class _0437_pathSum_2 {
    public static void main(String[] args) {
        Solution_0437_2 solution = new Solution_0437_2();
        // [10,5,-3,3,2,null,11,3,-2,null,1] 8
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(11);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(-2);
        TreeNode i = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        d.left = g;
        d.right = h;
        e.right = i;
        System.out.println(solution.pathSum(a, 8));

        // [1,-2,null,null,3]
        TreeNode a2 = new TreeNode(1);
        TreeNode b2 = new TreeNode(-2);
        TreeNode c2 = new TreeNode(3);
        a2.left = b2;
        b2.right = c2;
        System.out.println(solution.pathSum(a2, 3));
    }
}
