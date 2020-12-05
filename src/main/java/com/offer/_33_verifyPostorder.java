/**
 * // 33. 二叉搜索树的后序遍历序列
 * // 难度：中等
 * // 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * //
 * // 参考以下这颗二叉搜索树：
 * //  5
 * // / \
 * // 2   6
 * // / \
 * // 1   3
 * //
 * // 示例 1：
 * // 输入: [1,6,3,2,5]
 * // 输出: false
 * //
 * // 示例 2：
 * // 输入: [1,3,2,6,5]
 * // 输出: true
 * //
 * // 提示：
 * // 数组长度 <= 1000
 * //
 * // 思路：递归分治
 * // 根据二叉搜索树的定义，可以通过递归，判断所有子树的 正确性 （即其后序遍历是否满足二叉搜索树的定义） ，若所有子树都正确，则此序列为二叉搜索树的后序遍历。
 * // 递归解析：
 * // 终止条件： 当 i≥j ，说明此子树节点数量 ≤1 ，无需判别正确性，因此直接返回 true ；
 * // 递推工作：
 * //   1.划分左右子树： 遍历后序遍历的 [i,j] 区间元素，寻找 第一个大于根节点 的节点，索引记为 m 。此时，可划分出左子树区间 [i,m−1] 、右子树区间 [m,j−1] 、根节点索引 j 。
 * //   2.判断是否为二叉搜索树：
 * //     左子树区间 [i,m−1] 内的所有节点都应 < postorder[j] 。而第 1.划分左右子树 步骤已经保证左子树区间的正确性，因此只需要判断右子树区间即可。
 * //     右子树区间 [m,j−1] 内的所有节点都应 > postorder[j] 。实现方式为遍历，当遇到 ≤postorder[j] 的节点则跳出；则可通过 p=j 判断是否为二叉搜索树。
 * // 返回值： 所有子树都需正确才可判定正确，因此使用 与逻辑符 && 连接。
 * //   1.p=j ： 判断 此树 是否正确。
 * //   2.recur(i,m−1) ： 判断 此树的左子树 是否正确。
 * //   3.recur(m,j−1) ： 判断 此树的右子树 是否正确。
 */

package com.offer;

class Solution_33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int begin, int end) {
        if (begin >= end)
            return true;
        int p = begin;
        while (postorder[p] < postorder[end])    // 寻找第一个大于根节点的索引，作为左右子树的分界
            p++;
        int m = p;  // 记录左右子树划分的索引
        while (postorder[p] > postorder[end])   // 遍历p指针后面的数字，如果全部大于根节点，指针会走到根节点处
            p++;

        return p == end && recur(postorder, begin, m - 1) && recur(postorder, m, end-1);  //递归判断左右子树
    }
}

public class _33_verifyPostorder {
    public static void main(String[] args) {
        // [4, 8, 6, 12, 16, 14, 10]
        int[] postorder = {4, 8, 6, 12, 16, 14, 10};
        Solution_33 solution = new Solution_33();
        boolean ans = solution.verifyPostorder(postorder);
        System.out.println(ans);
    }
}
