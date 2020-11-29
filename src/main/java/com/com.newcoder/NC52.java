/**
 * NC52 括号序列
 * 难度：简单
 * <p>
 * 题目描述
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 * 示例1
 * 输入
 * "["
 * 返回值
 * false
 * 示例2
 * 输入
 * "[]"
 * 返回值
 * true
 */
package com.newcoder;

import java.util.Stack;

class SolutionNC52 {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.size() == 0)  // 如果没有匹配的左括号，说明序列非法
                    return false;
                char top = stack.pop();
                if (!((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')))
                    return false;
            }
        }
        if (stack.size() != 0)  // 如果字符串遍历结束，栈不为空，说明还有没匹配的左括号
            return false;
        return true;
    }
}

public class NC52 {
    public static void main(String[] args) {
        SolutionNC52 solution = new SolutionNC52();
//        String ss = "()[]{}";
        String ss = "(";
        System.out.println(solution.isValid(ss));
    }
}
