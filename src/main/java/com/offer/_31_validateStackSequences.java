/**
 * // 31. 栈的压入、弹出序列
 * // 难度：中等
 * // 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * //
 * // 示例 1：
 * // 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * // 输出：true
 * // 解释：我们可以按以下顺序执行：
 * // push(1), push(2), push(3), push(4), pop() -> 4,
 * // push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * //
 * // 示例 2：
 * // 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * // 输出：false
 * // 解释：1 不能在 2 之前弹出。
 * //
 * // 提示：
 * // 0 <= pushed.length == popped.length <= 1000
 * // 0 <= pushed[i], popped[i] < 1000
 * // pushed 是 popped 的排列。
 * // 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/
 * //
 * // 思路：
 * // 给定一个压入序列 pushed 和弹出序列 popped ，则压入 / 弹出操作的顺序（即排列）是唯一确定的
 * // 考虑借用一个辅助栈 stack ，模拟 压入 / 弹出操作的排列。根据是否模拟成功，即可得到结果。
 */

package com.offer;

import java.util.Stack;

class Solution_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();   // 建立一个栈，用于模拟push/pop操作
        int i = 0;  // 用于索引pop序列中的元素
        for (int num : pushed) {
            stack.push(num);    // 将push序列中的数字压栈
            while (!stack.isEmpty() && stack.peek() == popped[i]) {     // 如果栈顶元素与pop序列匹配，就弹出
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}

public class _31_validateStackSequences {
    public static void main(String[] args) {
        // [1,2,3,4,5]
        // [4,5,3,2,1] --> true
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        Solution_31 solution = new Solution_31();
        System.out.println(solution.validateStackSequences(pushed, popped));
    }
}
