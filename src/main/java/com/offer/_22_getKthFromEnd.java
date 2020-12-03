/**
 * // 22. 链表中倒数第k个节点
 * // 难度：简单
 * // 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * //
 * // 示例：
 * // 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * //
 * // 返回链表 4->5.
 */

package com.offer;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 统计链表有多少个节点
        ListNode tmp = head;
        int cnt = 0;
        while (tmp != null) {
            cnt++;
            tmp = tmp.next;
        }
        tmp = head;
        // 寻找倒数第K个节点
        int i = 1;
        while (i < cnt - k + 1) {
            tmp = tmp.next;
            i++;
        }
        return tmp;
    }
}

public class _22_getKthFromEnd {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;

        Solution_22 solution = new Solution_22();
        ListNode ans = solution.getKthFromEnd(a, 2);
        System.out.println(ans.val);
    }
}
