/**
 * // 142. 环形链表
 * // 难度：简单
 * // 给定一个链表，判断链表中是否有环。
 * //
 * // 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * // 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * // 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * //
 * // 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * //
 * // 进阶：
 * // 你能用 O(1)（即，常量）内存解决此问题吗？
 * //
 * // 示例 1：
 * // 输入：head = [3,2,0,-4], pos = 1
 * // 输出：true
 * // 解释：链表中有一个环，其尾部连接到第二个节点。
 * //
 * // 示例 2：
 * // 输入：head = [1,2], pos = 0
 * // 输出：true
 * // 解释：链表中有一个环，其尾部连接到第一个节点。
 * //
 * // 示例 3：
 * // 输入：head = [1], pos = -1
 * // 输出：false
 * // 解释：链表中没有环。
 * //  
 * // 提示：
 * // 链表中节点的数目范围是 [0, 104]
 * // -105 <= Node.val <= 105
 * // pos 为 -1 或者链表中的一个 有效索引 。
 */

package com.code.main._101_200;

class Solution_0141 {
    public boolean hasCycle(ListNode head) {
        // 思路1: 用hashmap记住每个节点，对链表做遍历。空间复杂度O(n)
        // 思路2: 快慢指针，快指针每次走2步，如果有环一定会追上慢指针。如果没有环，则会走到NULL
//        if (head == null || head.next == null)
//            return false;
//        ListNode slow = head, fast = head.next;
//        while (fast != slow) {
//            if (fast == null || fast.next == null) return false;
//            fast = fast.next.next;  // 快指针走2步
//            slow = slow.next;
//        }
//        return true;

        // 第二种写法，跟142题一致
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            if (fast == slow) return true;
        }
        return false;
    }
}

public class _0141_hasCycle {
    public static void main(String[] args) {
        // [3,2,0,-4] 1
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        // [1,2] -1
//        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(2);
//        a.next = b;
        Solution_0141 solution = new Solution_0141();
        Boolean ans = solution.hasCycle(a);
        System.out.println(ans);
    }
}
