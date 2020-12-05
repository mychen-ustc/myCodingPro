/**
 * // 36. 二叉搜索树与双向链表
 * // 难度：中等
 * // 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * //
 * // 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * //        4
 * //       / \
 * //      2   5
 * //     / \
 * //    1   3
 * //
 * // 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * //
 * // 下图 _36_treeToDoublyList.jpeg 展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * //
 * // 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 * //
 * // 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * // 注意：此题对比原题有改动。
 */

package com.offer;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution_36 {
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        List<Node> list = new ArrayList<>();     // 定义一个队列
        // 遍历二叉搜索树，将所有结点存储到列表中
        recur(root, list);
        // 单独设置头结点和尾结点的双向指针
        list.get(0).right = list.get(1);
        list.get(0).left = list.get(list.size() - 1);
        list.get(list.size() - 1).left = list.get(list.size() - 2);
        list.get(list.size() - 1).right = list.get(0);
        for (int i = 1; i < list.size() - 1; i++) {
            list.get(i).left = list.get(i - 1);     // 设置前驱节点
            list.get(i).right = list.get(i + 1);    // 设置后继节点
        }
        return list.get(0);
    }

    // 递归遍历二叉搜索树
    public void recur(Node node, List<Node> list) {
        if (node == null) return;
        recur(node.left, list);
        list.add(node);
        recur(node.right, list);
    }
}

public class _36_treeToDoublyList {
    public static void main(String[] args) {
//        Node a = new Node(1);
//        Node b = new Node(2);
//        Node c = new Node(3);
//        Node d = new Node(4);
//        Node e = new Node(5);
//        d.left = b;
//        d.right = e;
//        b.left = a;
//        b.right = c;
//
//        Solution_36 solution = new Solution_36();
//        Node ans = solution.treeToDoublyList(d);
//        System.out.println(ans);

        Node a = new Node(1);
        Solution_36 solution = new Solution_36();
        Node ans = solution.treeToDoublyList(a);
    }
}
