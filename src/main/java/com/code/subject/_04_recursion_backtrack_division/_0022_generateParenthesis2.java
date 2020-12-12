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
 * 做加法:另外一种形式，以左右括号用了几个画二叉树
 */

class Solution0022_2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) return res;

        // 执行深度优先遍历，搜索可能的结果
        dfs("", 0, 0, res, n);
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
    private void dfs(String curStr, int left, int right, List<String> res, int n) {
        // 递归终止的时候，添加到结果集
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }
        // 剪枝: 左括号已用的个数小于右括号已用的个数，剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left + 1, right, res, n);
        }

        if (right < n) {
            dfs(curStr + ")", left, right + 1, res, n);
        }
    }
}

public class _0022_generateParenthesis2 {

    public static void main(String[] args) {
        Solution0022_2 solution = new Solution0022_2();
        int n = 3;
        System.out.println(solution.generateParenthesis(n));
    }
}
