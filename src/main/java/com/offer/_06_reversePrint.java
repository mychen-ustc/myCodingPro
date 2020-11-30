/**
 * // 06. 从尾到头打印链表
 * // 难度：简单
 * // 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * //
 * // 示例 1：
 * //
 * // 输入：head = [1,3,2]
 * // 输出：[2,3,1]
 * //
 * // 限制：
 * //
 * // 0 <= 链表长度 <= 10000
 */

package com.offer;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution_06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        int cnt = stack.size();
        for (int i = 0; i < cnt; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}

public class _06_reversePrint {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        a.next = b;
        b.next = c;
        Solution_06 solution = new Solution_06();
        int[] ans = solution.reversePrint(a);
        System.out.println(ans);
    }
}
