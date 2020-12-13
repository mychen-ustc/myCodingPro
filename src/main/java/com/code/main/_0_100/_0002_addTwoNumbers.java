/**
 * // 2. 两数相加
 * // 难度：中等
 * // 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * //
 * // 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * //
 * // 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * //
 * // 示例：
 * // 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * // 输出：7 -> 0 -> 8
 * // 原因：342 + 465 = 807
 * //
 * // 思路：用链表实现大数求和，要注意进位的处理，考虑周全
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
class Solution_0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);    // 新的头结点:这个结点实际上不存储数字，作用是指向真正的头结点
        ListNode tail = root;    // 尾部结点
        int carry = 0;  // 进位
        // 第一部分：处理链表公共的部分
        while (l1 != null && l2 != null) {  // 同步遍历两个链表
            int sum = l1.val + l2.val + carry;  // 要加上低位传递过来的进位
            carry = sum / 10;
            sum = sum % 10;
            tail.next = new ListNode(sum);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 第二部分：处理较长的链表剩余的部分
        if (l2 != null) l1 = l2;    // 处理单个链表多余的数字，统一接到l1处理。要注意进位
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            l1.val = sum;
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }
        // 第三部分：可能有进位还需要新的结点存储
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return root.next;
    }
}

public class _0002_addTwoNumbers {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode b1 = new ListNode(4);
        ListNode c1 = new ListNode(3);
        ListNode d1 = new ListNode(5);
        ListNode e1 = new ListNode(9);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;

        ListNode a2 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        a2.next = b2;
        b2.next = c2;

        Solution_0002 solution = new Solution_0002();
        ListNode node = solution.addTwoNumbers(a1, a2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
