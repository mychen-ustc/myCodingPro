/**
 * // 41. 数据流中的中位数
 * // 难度：困难
 * // 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * // 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * //
 * // 例如，
 * // [2,3,4] 的中位数是 3
 * // [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * //
 * // 设计一个支持以下两种操作的数据结构：
 * //
 * // void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * // double findMedian() - 返回目前所有元素的中位数。
 * //
 * // 示例 1：
 * // 输入：
 * // ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * // [[],[1],[2],[],[3],[]]
 * // 输出：[null,null,null,1.50000,null,2.00000]
 * //
 * // 示例 2：
 * // 输入：
 * // ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * // [[],[2],[],[3],[]]
 * // 输出：[null,null,2.00000,null,2.50000]
 * //
 * // 限制：
 * // 最多会对 addNum、findMedian 进行 50000 次调用。
 * // 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/
 * //
 * // 思路：用小顶堆+大顶堆实现
 * //
 */

package com.offer;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> A;   // 定义小顶堆：存储较大的一半
    PriorityQueue<Integer> B;   // 定义大顶堆，存储较小的一半

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        A = new PriorityQueue<>();  // 初始化小顶堆，比较函数用默认的即可
        B = new PriorityQueue<>((x, y) -> y - x);   // 初始化大顶堆，比较函数需要反向
    }

    public void addNum(int num) {
        if (A.size() == B.size()) {     // 之前的个数为偶数
            B.add(num);     // 利用大顶堆，找B堆当前最大的数
            A.add(B.poll());    // 将大顶堆的堆顶取出来，放到A中
        } else {    // 之前的个数为奇数
            A.add(num);     // 利用小顶堆，取A堆当前最小的数
            B.add(A.poll());    // 将小顶堆的堆顶取出来，放到B中
        }
    }

    public double findMedian() {
        // 如果个数为偶数，取两个堆顶的平均值；如果个数为偶数，取A堆顶即可。
        return A.size() == B.size() ? (A.peek() + B.peek()) / 2.0 : A.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

public class _41_MedianFinder {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
