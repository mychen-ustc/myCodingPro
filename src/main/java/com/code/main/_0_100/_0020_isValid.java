/**
 * // 20. 有效的括号
 * // 难度：简单
 * // 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * //
 * // 有效字符串需满足：
 * //
 * // 左括号必须用相同类型的右括号闭合。
 * // 左括号必须以正确的顺序闭合。
 * // 注意空字符串可被认为是有效字符串。
 * //
 * // 示例 1:
 * // 输入: "()"
 * // 输出: true
 * //
 * // 示例 2:
 * // 输入: "()[]{}"
 * // 输出: true
 * //
 * // 示例 3:
 * // 输入: "(]"
 * // 输出: false
 * //
 * // 示例 4:
 * // 输入: "([)]"
 * // 输出: false
 * //
 * // 示例 5:
 * // 输入: "{[]}"
 * // 输出: true
 */

package com.code.main._0_100;

import java.util.Stack;

class Solution_0020 {
    public boolean isValid(String s) {
        // 用栈进行匹配，如果遇到左括号就入栈，遇到右括号弹出栈顶进行比较
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {   // 左括号入栈
                stack.push(ch);
            } else {    // 右括号
                if (stack.isEmpty()) return false;  // 没有左括号进行匹配
                char top = stack.pop();     // 弹出栈顶
                if (!((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')))
                    return false;   // 不能匹配，返回false
            }
        }
        return stack.isEmpty();     // 如果栈为空，则全部匹配成功。否则还有未匹配的左括号
    }
}

public class _0020_isValid {
    public static void main(String[] args) {
        // ()[]{}
        Solution_0020 solution = new Solution_0020();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("(){}"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(}"));
        System.out.println(solution.isValid("({})"));
        System.out.println(solution.isValid("{()}"));
        System.out.println(solution.isValid("{[()]}"));
        System.out.println(solution.isValid("{[(])]}"));
        System.out.println(solution.isValid("]"));
    }
}
