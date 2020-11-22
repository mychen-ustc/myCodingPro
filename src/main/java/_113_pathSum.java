/**
// * 113. 路径总和 II
// * 难度：中等
// * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
// *
// * 说明: 叶子节点是指没有子节点的节点。
// *
// * 示例:
// * 给定如下二叉树，以及目标和 sum = 22，
// *
// *               5
// *              / \
// *             4   8
// *            /   / \
// *           11  13  4
// *          /  \    / \
// *         7    2  5   1
// * 返回:
// *
// * [
// *    [5,4,11,2],
// *    [5,8,4,5]
// * ]
// *
// * 来源：力扣（LeetCode）
// * 链接：https://leetcode-cn.com/problems/path-sum-ii
// * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution_113 {
    List<List<Integer>> res = new ArrayList<>();
    Stack<Integer> path = new Stack<>();    // 用栈存储路径

    public void dfs(TreeNode node, int sum) {
        if (node == null)
            return;
        int val = node.val;
        path.push(val); // 将节点的值压栈
        sum -= val; // 计算差值
        if (node.left == null && node.right == null && sum == 0) {  // 遍历到叶子节点，并且路径之和满足要求
            res.add(new ArrayList<>(path));
        }
        dfs(node.left, sum);    // 遍历左子树
        dfs(node.right, sum);   // 遍历右子树
        path.pop(); // 弹出尾节点
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum); // 从根节点开始遍历
        return res;
    }
}


public class _113_pathSum {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        f.left = i;
        f.right = j;
        Solution_113 solution = new Solution_113();
        List<List<Integer>> res = solution.pathSum(a, 22);
        System.out.println(res);
    }

}
