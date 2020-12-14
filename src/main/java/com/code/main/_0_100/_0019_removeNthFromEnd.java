/**
 * // 19. 删除链表的倒数第N个节点
 * // 难度：中等
 * // 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * //
 * // 示例：
 * // 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * //
 * // 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * //
 * // 说明：
 * // 给定的 n 保证是有效的。
 * //
 * // 进阶：
 * // 你能尝试使用一趟扫描实现吗？
 */

package com.code.main._0_100;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 统计链表长度
        ListNode node = head;
        int length = 0;    // 链表节点数
        while (node != null) {
            length++;
            node = node.next;
        }
        if (n == length) return head.next;  // 删除第一个节点：直接返回头结点的next
        // 找到第 length-n 个节点
        int cnt = 0, k = length - n;
        node = head;
        ListNode pre = null;
        while (cnt < k) {
            pre = node;     // 记录前驱
            node = node.next;
            cnt++;
        }
        // 删除节点
        pre.next = node.next;
        return head;
    }
}

public class _0019_removeNthFromEnd {
    public static void main(String[] args) {
        // [1,2,3,4,5] 2
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Solution_0019 solution = new Solution_0019();
        ListNode ans = solution.removeNthFromEnd(a, 4);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
