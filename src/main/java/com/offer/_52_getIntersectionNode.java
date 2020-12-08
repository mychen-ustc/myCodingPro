/**
 * // 52. 两个链表的第一个公共节点
 * // 难度：简单
 * // 输入两个链表，找出它们的第一个公共节点。
 * //
 * // 如下面的两个链表：（见图 _52_getIntersectionNode_1.jpeg）
 * // 在节点 c1 开始相交。
 * //
 * // 示例 1：
 * // 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * // 输出：Reference of the node with value = 8
 * // 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * //
 * // 示例 2：
 * // 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * // 输出：Reference of the node with value = 2
 * // 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * //
 * // 示例 3：
 * // 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * // 输出：null
 * // 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * // 解释：这两个链表不相交，因此返回 null。
 * //
 * // 注意：
 * // 如果两个链表没有交点，返回 null.
 * // 在返回结果后，两个链表仍须保持原有的结构。
 * // 可假定整个链表结构中没有循环。
 * // 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * // 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */

package com.offer;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 有三种思路：
        // 1.用集合记录已访问的节点，如果发现某个节点已经在集合中，则该节点为相交节点，第一个相交节点即为所求。
        // 2.先统计两个链表的长度，假设差值为diff，然后让长链表的指针先走diff步，之后两个指针同步走，第一个相同的节点即为所求
        // 3.参照赛跑（先跑完的，从另一个链表头部接着跑），跑的快的和跑的慢的最终一定会在某个点相遇。这里用思路3
        if (headA == null || headB == null) return null;
        ListNode pointerA = headA, pointerB = headB;
        while (pointerA != pointerB) {
            if (pointerA == null) {
                pointerA = headB;
            } else {
                pointerA = pointerA.next;
            }
            if (pointerB == null) {
                pointerB = headA;
            } else {
                pointerB = pointerB.next;
            }
        }
        return pointerA;
    }
}

public class _52_getIntersectionNode {
    public static void main(String[] args) {
        // 8
        // [4,1,8,4,5]
        // [5,0,1,8,4,5]
        // 2
        // 3
        ListNode x = new ListNode(8);
        ListNode y = new ListNode(4);
        ListNode z = new ListNode(5);
        x.next = y;
        y.next = z;

        ListNode a1 = new ListNode(4);
        ListNode b1 = new ListNode(1);
        a1.next = b1;
        b1.next = x;

        ListNode a2 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode c2 = new ListNode(1);
        a2.next = b2;
        b2.next = c2;
        c2.next = x;

        Solution_52 solution = new Solution_52();
        ListNode ans = solution.getIntersectionNode(a1, a2);
        System.out.println(ans.val);
    }
}
