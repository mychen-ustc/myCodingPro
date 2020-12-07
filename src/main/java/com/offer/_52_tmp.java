package com.offer;

/**
 * @Author: alstonchen
 * @email: alstonchen@tencent.com
 * @Date: Created in 2020/12/7 12:44
 * @Version: V1.0
 * @Description:
 */

class helper {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 有三种思路：
        // 1.用集合记录已访问的节点，如果发现某个节点已经在集合中，则该节点为相交节点，第一个相交节点即为所求。
        // 2.先统计两个链表的长度，假设差值为diff，然后让长链表的指针先走diff步，之后两个指针同步走，第一个相同的节点即为所求
        // 3.参照赛跑（一直转圈），跑的快的和跑的慢的最终一定会在某个点相遇。这里用思路3
        ListNode pointerA = headA, pointerB = headB;
        while (pointerA != pointerB) {
            if (pointerA.next == null) {
                pointerA = headA;
            } else {
                pointerA = pointerA.next;
            }
            if (pointerB.next == null) {
                pointerB = headB;
            } else {
                pointerB = pointerB.next;
            }
        }
        return pointerA;
    }
}

public class _52_tmp {
    public static void main(String[] args) {
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

        helper solution = new helper();
        ListNode ans = solution.getIntersectionNode(a1, a2);
        System.out.println(ans.val);
    }
}
