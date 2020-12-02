/**
 * // 18. 删除链表的节点
 * // 难度：简单
 * // 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * //
 * // 返回删除后的链表的头节点。
 * //
 * // 注意：此题对比原题有改动
 * //
 * // 示例 1:
 * //
 * // 输入: head = [4,5,1,9], val = 5
 * // 输出: [4,1,9]
 * // 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * // 示例 2:
 * //
 * // 输入: head = [4,5,1,9], val = 1
 * // 输出: [4,5,9]
 * // 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * //
 * // 说明：
 * // 题目保证链表中节点的值互不相同
 * // 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
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
class Solution_18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode pre = head;
        while (pre != null && pre.next != null) {
            if (pre.next.val == val) {  // 如果pre.next所指向的节点为要删除的节点
                pre.next = pre.next.next;   // 将pre.next节点断开
            }
            pre = pre.next;     // next往后遍历
        }

        return head;
    }
}

public class _18_deleteNode {
    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;

        Solution_18 solution = new Solution_18();
        ListNode head = solution.deleteNode(a, 9);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
