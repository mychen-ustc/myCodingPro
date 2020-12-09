/**
 * // 59 - II. 队列的最大值
 * // 难度：中等
 * // 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * //
 * // 若队列为空，pop_front 和 max_value 需要返回 -1
 * //
 * // 示例 1：
 * // 输入:
 * // ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * // [[],[1],[2],[],[],[]]
 * // 输出: [null,null,null,2,1,2]
 * //
 * // 示例 2：
 * // 输入:
 * // ["MaxQueue","pop_front","max_value"]
 * // [[],[],[]]
 * // 输出: [null,-1,-1]
 * //
 * // 限制：
 * // 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * // 1 <= value <= 10^5
 * //
 * // 用辅助的双端队列维护一个单调递增序列。插入元素value时，从队尾依次弹出比value小的元素，知道遇到第一个比value大的。
 * // 本算法基于问题的一个重要性质：当一个元素进入队列的时候，它前面所有比它小的元素就不会再对答案产生影响。
 */

package com.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {
    Queue<Integer> q;
    Deque<Integer> d;

    public MaxQueue() {
        q = new LinkedList<Integer>();
        d = new LinkedList<Integer>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */

public class _59_II_MaxQueue {
    public static void main(String[] args) {
        // ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
        // [[],[1],[2],[],[],[]]
    }
}
