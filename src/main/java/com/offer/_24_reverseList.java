/**
 * // 24. 反转链表
 * // 难度：简单
 * // 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * //
 * // 示例:
 * // 输入: 1->2->3->4->5->NULL
 * // 输出: 5->4->3->2->1->NULL
 * //
 * // 限制：
 * // 0 <= 节点个数 <= 5000
 * //
 * // 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
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
class Solution_24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 需要用到3个临时节点：pre记录已反转的链表的表头，cur记录当前要反转的结点, next记录待处理结点的下一个结点
        ListNode pre = head, cur = pre.next, next;
        pre.next = null;    // 头结点变成尾结点，需要将next设置为null
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}

public class _24_reverseList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        Solution_24 solution = new Solution_24();
        ListNode head = solution.reverseList(a);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
