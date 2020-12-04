/**
 * // 25. 合并两个排序的链表
 * // 难度：简单
 * // 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * //
 * // 示例1：
 * // 输入：1->2->4, 1->3->4
 * // 输出：1->1->2->3->4->4
 * //
 * // 限制：
 * // 0 <= 链表长度 <= 1000
 * //
 * // 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
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
class Solution_25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null && l2 != null)
            return l2;
        if (l1 != null && l2 == null)
            return l1;
        ListNode head;  // 新链表的表头
        ListNode cur;   // 新链表的尾节点
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
            cur = head;
        } else {
            head = l2;
            l2 = l2.next;
            cur = head;
        }
        while (l1 != null && l2 != null) {  // 遍历
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = cur.next.next;
            } else {
                cur.next = l2;
                l2 = cur.next.next;
            }
            cur = cur.next;
        }
        if (l1 != null)
            cur.next = l1;
        if (l2 != null)
            cur.next = l2;
        return head;
    }
}

public class _25_mergeTwoLists {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode c1 = new ListNode(4);
        ListNode d1 = new ListNode(5);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;

        ListNode a2 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode c2 = new ListNode(4);
        a2.next = b2;
        b2.next = c2;

        Solution_25 solution = new Solution_25();
        ListNode head = solution.mergeTwoLists(a1, a2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
