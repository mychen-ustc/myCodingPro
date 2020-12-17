/**
 * // 148. 排序链表
 * // 难度：中等
 * // 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * //
 * // 进阶：
 * // 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * //
 * // 示例 1：
 * // 输入：head = [4,2,1,3]
 * // 输出：[1,2,3,4]
 * //
 * // 示例 2：
 * // 输入：head = [-1,5,3,4,0]
 * // 输出：[-1,0,3,4,5]
 * //
 * // 示例 3：
 * // 输入：head = []
 * // 输出：[]
 * //
 * // 提示：
 * // 链表中节点的数目在范围 [0, 5 * 10^4] 内
 * // -10^5 <= Node.val <= 10^5
 */

package com.code.main._101_200;

import java.util.ArrayList;
import java.util.List;

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
class Solution_0148 {
    public ListNode sortList(ListNode head) {
        // 解法1：将所有节点存到数组中，对数组排序，然后建立连接 时间O(nlogn),空间O(n)
        if (head == null) return null;
        List<ListNode> list = new ArrayList<>();
        ListNode ptr = head;
        while (ptr != null) {
            list.add(new ListNode(ptr.val));
            ptr = ptr.next;
        }
        // 排序
        list.sort((node1, node2) -> (node1.val - node2.val));
        head = list.get(0);
        int i = 1;
        ptr = head;
        // 建立连接
        while (ptr != null && i < list.size()) {
            ptr.next = list.get(i);
            i++;
            ptr = ptr.next;
        }
        return head;

    }

}

public class _0148_sortList {
    public static void main(String[] args) {
        // [4,2,1,3]
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        Solution_0148 solution = new Solution_0148();
        ListNode head = solution.sortList(a);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
