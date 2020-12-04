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
 * //
 * // 解题思路：
 * // 普通栈的 push() 和 pop() 函数的复杂度为 O(1) ；而获取栈最小值 min() 函数需要遍历整个栈，复杂度为 O(N) 。
 * // 本题难点： 将 min() 函数复杂度降为 O(1)O(1) ，可通过建立辅助栈实现；
 * // 数据栈 A ： 栈 A 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
 * // 辅助栈 B ： 栈 B 中存储栈 AA 中所有 非严格降序 的元素，则栈 A 中的最小元素始终对应栈 B 的栈顶元素，即 min() 函数只需返回栈 B 的栈顶元素即可。
 * // 因此，只需设法维护好 栈 B 的元素，使其保持非严格降序，即可实现 min() 函数的 O(1) 复杂度。
 * // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package com.offer;

import java.util.Stack;

class MinStack_30 {
    Stack<Integer> stackA;  // 主栈：存储所有元素
    Stack<Integer> stackB;  // 辅助栈，用于按非严格降序存储元素，提供最小值

    /**
     * initialize your data structure here.
     */
    public MinStack_30() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.add(x);
        if (stackB.isEmpty() || x <= stackB.peek()) {   // 如果栈B为空或者当前元素小于B的栈顶，则压入栈B
            stackB.add(x);
        }
    }

    public void pop() {
        int top = stackA.pop();   // 弹出A的栈顶
        if (top == stackB.peek()) {
            stackB.pop();   // 如果A栈顶等于B栈顶，则同时需要弹出B的栈顶
        }
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.peek();   // B的栈顶即为最小值
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
        MinStack_30 minStack = new MinStack_30();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());     //   --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());     // --> 返回 0.
        System.out.println(minStack.min());   // --> 返回 -2.
    }
}
