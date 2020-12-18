/**
 * // 请判断一个链表是否为回文链表。
 * //
 * // 示例 1:
 * // 输入: 1->2
 * // 输出: false
 * //
 * // 示例 2:
 * // 输入: 1->2->2->1
 * // 输出: true
 * // 进阶：
 * // 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */

package com.code.main._201_300;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution_0234 {
    public boolean isPalindrome(ListNode head) {
        // 思路：统计节点个数，将后半段翻转后，用双指针同步比较前半段和后半段是否相同
        int totalCnt = 0;
        ListNode ptr1 = head;
        while (ptr1 != null) {
            totalCnt++;
            ptr1 = ptr1.next;
        }
        // 计算后半段的起点（要注意判断链表节点个数为奇数还是偶数）
        int halfStart = totalCnt % 2 == 0 ? totalCnt / 2 : totalCnt / 2 + 1;    // 节点个数为奇数，需要跳过中心节点
        ListNode halfHead = head;
        // 找到后半段的头节点并翻转后半段
        int cnt = 0;
        while (cnt < totalCnt - halfStart) {
            cnt++;
            halfHead = halfHead.next;
        }
        ListNode ptr2 = reverse(halfHead);  // 翻转后半段
        // 双指针同步比较
        ptr1 = head;
        while (ptr2 != null) {
            if (ptr1.val != ptr2.val)
                return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;
    }

    // 翻转链表
    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, cur = head;    // 记录前驱和当前处理节点
        while (cur != null) {
            ListNode next = cur.next;   // 记住后继节点
            cur.next = pre;
            pre = cur;  // pre后移一位，指向下一步处理的结点
            cur = next; // cur后移一位
        }
        return pre; // cur指向null，pre指向最终的头结点（原来的尾节点）
    }
}

public class _0234_isPalindrome {
    public static void main(String[] args) {
        // [1,2]
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Solution_0234 solution = new Solution_0234();
        ListNode ptr = a;
        while (ptr != null) {
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
        // 测试翻转链表
//        ptr = solution.reverse(a);
//        while (ptr != null) {
//            System.out.println(ptr.val);
//            ptr = ptr.next;
//        }
        Boolean ans = solution.isPalindrome(a);
        System.out.println(ans);
    }
}
