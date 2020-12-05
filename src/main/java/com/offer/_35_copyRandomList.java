/**
 * // 35. 复杂链表的复制
 * // 难度：中等
 * // 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * //
 * // 示意图见 _35_copyRandomList.jpeg
 * // 示例 1：
 * // 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * // 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * //
 * // 示例 2：
 * // 输入：head = [[1,1],[2,1]]
 * // 输出：[[1,1],[2,1]]
 * //
 * // 示例 3：
 * // 输入：head = [[3,null],[3,0],[3,null]]
 * // 输出：[[3,null],[3,0],[3,null]]
 * //
 * // 示例 4：
 * // 输入：head = []
 * // 输出：[]
 * // 解释：给定的链表为空（空指针），因此返回 null。
 * //
 * // 提示：
 * // -10000 <= Node_35.val <= 10000
 * // Node_35.random 为空（null）或指向链表中的节点。
 * // 节点数目不超过 1000 。
 * //
 * // 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * //
 * // 分析：next指针的复制没什么问题，主要是考虑random指针的复制，关键是要记录random指向的是第几个节点
 */

package com.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for a Node_35.
class Node_35 {
    int val;
    Node_35 next;
    Node_35 random;

    public Node_35(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution_35 {
    public Node_35 copyRandomList(Node_35 head) {
        Node_35 tmp = head;    // 用一个临时节点拷贝head
        if (head == null) return null;
        // 定义链表，按顺序存储节点，便于索引节点，给random指针赋值。结点的next指向后一个节点即可
        List<Node_35> newNodes = new ArrayList<>();
        List<Node_35> oldNodes = new ArrayList<>();
        // 定义hashmap，存储原始节点的hashcode和节点索引序号
        Map<Integer, Integer> map = new HashMap<>();
        // 定义一个数组，记录random的索引，索引的结点在newNodes链表中
        List<Integer> indexs = new ArrayList<>();
        // 第一次遍历：创建所有新结点
        int cnt = 0;
        while (tmp != null) {
            Node_35 node = new Node_35(tmp.val);
            newNodes.add(node); // 把新节点存储到链表中
            oldNodes.add(tmp);  // 把旧节点存储到链表中
            map.put(tmp.hashCode(), cnt);
            cnt++;
            tmp = tmp.next;
        }
        // 处理新节点的next和random指针
        for (int i = 0; i < newNodes.size(); i++) {
            Node_35 node = newNodes.get(i);
            // 处理next指针
            if (i < newNodes.size() - 1) {
                node.next = newNodes.get(i + 1);
            } else {
                node.next = null;   // 这个赋值其实可以省略，因为节点next指针已被初始化为null
            }
            // 处理random指针
            Node_35 oldNode = oldNodes.get(i);     // 取旧节点
            if (oldNode.random != null) {
                int oldHashCode = oldNode.random.hashCode();
                int index = map.get(oldHashCode);
                node.random = newNodes.get(index);
            }
        }
        return newNodes.get(0);     // 返回新的头结点
    }
}

public class _35_copyRandomList {
    public static void main(String[] args) {
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node_35 a = new Node_35(7);
        Node_35 b = new Node_35(13);
        Node_35 c = new Node_35(11);
        Node_35 d = new Node_35(10);
        Node_35 e = new Node_35(1);
        a.next = b;
        b.next = c;
        b.random = a;
        c.next = d;
        c.random = e;
        d.next = e;
        d.random = c;
        e.random = a;

        Solution_35 solution = new Solution_35();
        Node_35 ans = solution.copyRandomList(a);
        System.out.println(ans);
    }
}
