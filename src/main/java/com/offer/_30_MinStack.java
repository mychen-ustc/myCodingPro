/**
 * // 30. 包含min函数的栈
 * // 难度：简单
 * // 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * //
 * // 示例:
 * //
 * // MinStack minStack = new MinStack();
 * // minStack.push(-2);
 * // minStack.push(0);
 * // minStack.push(-3);
 * // minStack.min();   --> 返回 -3.
 * // minStack.pop();
 * // minStack.top();      --> 返回 0.
 * // minStack.min();   --> 返回 -2.
 * //
 * // 提示：
 * // 各函数的调用总次数不超过 20000 次
 * //
 * // 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 */

package com.offer;

class MinStack_30 {

    /**
     * initialize your data structure here.
     */
    public MinStack_30() {

    }

    public void push(int x) {

    }

    public void pop() {

    }

    public int top() {
        return 0;
    }

    public int min() {
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

public class _30_MinStack {
    public static void main(String[] args) {
        // ["MinStack","push","push","push","min","pop","top","min"]
        // [[],[-2],[0],[-3],[],[],[],[]]
    }
}
