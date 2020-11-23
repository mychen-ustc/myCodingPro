/**
 * 236. 二叉树的最近公共祖先
 * 难度：中等
 * //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * //
 * //百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * //
 * //例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * //
 * //
 * //
 * // 
 * //
 * //示例 1:
 * //
 * //输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * //输出: 3
 * //解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * //示例 2:
 * //
 * //输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * //输出: 5
 * //解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * // 
 * //
 * //说明:
 * //
 * //所有节点的值都是唯一的。
 * //p、q 为不同节点且均存在于给定的二叉树中。
 * //
 * //来源：力扣（LeetCode）
 * //链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
//思路：用人思考的方式去向想递归。思考模式，先从左子树里面看有没有p、q中任意一个元素，再从右子树中看有没有p、q中任意一个元素。如果其中一个有了就向上返回根节点。
//
//递归点：
//
//左子树查找有没有p、q中任意一个元素
//
//右子树查找有没有p、q中任意一个元素
//
//返回值的情况：
//
//当root为null，肯定要返回null
//当root等于p、q中任意一个元素，表明这个分支肯定有用，返回再说
//判断左边和右边的返回值情况：
//​ case 1：left ,right都不空，则root可以直接返回
//
//​ case 2 ： 其中有一个为空，返回非空的那一支。p、q都在这一支非空的上面
//
//​ case 3: 两个都为空，则返回空吧。就把这个分支放弃了
//
//作者：zxh1008610086
//链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/shen-du-xiang-jie-zui-jin-gong-gong-zu-xian-qing-x/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package com.code._05_tree_graph;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_0236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }
}

public class _0236_lowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(0);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(7);
        TreeNode i = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        e.right = i;
        Solution_0236 solution = new Solution_0236();
        TreeNode node = solution.lowestCommonAncestor(a, d, i);
        System.out.println(node);
    }


}