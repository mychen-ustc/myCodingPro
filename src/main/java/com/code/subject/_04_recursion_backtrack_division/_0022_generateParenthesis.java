/**
 * 22. 括号生成
 * 难度：中等
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */

package com.code.subject._04_recursion_backtrack_division;

import java.util.ArrayList;
import java.util.List;

/**
 * 做减法:以左右括号还剩余几个可用画二叉树，分析得出结论：
 * 当前左括号都有大于0个可以用使用的时候，才产生分支
 * 产生左分支的时候，只看当前是否还有左括号可以使用
 * 产生右分支的时候，还收到左分支的限制，右括号剩余可用的数量一定大于左括号剩余数量，才产生分支。
 * 当左右边剩余的括号都等于0的时候结算
 */

class Solution0022 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) return res;

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * 深度优先搜索：用作减法的形式
     *
     * @param curStr 当前得到的结果
     * @param left   左括号还有几个可用
     * @param right  右括号还有几个可用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 递归终止的时候，添加到结果集
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
        // 剪枝: 左括号的剩余个数大于右括号个数，剪枝
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }
}

public class _0022_generateParenthesis {

    public static void main(String[] args) {
        Solution0022 solution = new Solution0022();
        int n = 3;
        System.out.println(solution.generateParenthesis(n));
    }
}
