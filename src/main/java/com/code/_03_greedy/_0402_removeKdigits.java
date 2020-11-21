/**
 * 402. 移掉K位数字
 * 难度：中等
 * <p>
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路：定义一个栈，每次能够加进栈的条件需要满足当前元素的值小于栈顶，使得栈顶的元素弹出，将当前元素加入，
 * 这种做法一定能够保证最后的字典序最小，当然如果操作到最后还剩下一些操作次数的话，因为最后我们留下的串是递增的，则删除最后若干个字符就OK了。
 */

package com.code._03_greedy;

import java.util.Stack;

public class _0402_removeKdigits {
    static public String removeKdigits(String num, int k) {
        int cnt = 0;
        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> st1 = new Stack<Integer>();

        // 扫描一遍数字：将元素添加到栈里面（添加的时候不断用更小的数字替换栈顶）
        for (int i = 0; i < num.length(); i++) {
            int tmp = num.charAt(i) - '0';
            while (!st.isEmpty() && st.peek() > tmp && cnt < k) {   // 如果当前数字小于栈顶，就替换掉栈顶
                st.pop();
                cnt++;
            }
            st.add(tmp);    // 将元素压栈
        }

        // 由于已删除的额数字可能少于k个，需要从栈里面继续删除，直到删除的个数达到k
        while (cnt < k && !st.isEmpty()) {
            cnt++;
            st.pop();
        }

        StringBuilder ans = new StringBuilder();    // 用于存储结果

        // 将栈元素逆序存入另一个栈
        while (!st.isEmpty())
            st1.add(st.pop());

        // 删除栈顶的0：保证不会有前导的0
        while (!st1.isEmpty() && st1.peek() == 0)
            st1.pop();

        // 提取字符拼接到结果中
        while (!st1.isEmpty())
            ans.append(st1.pop());
        if (ans.length() == 0)  // 如果最后没有字符了，就返回0
            ans.append("0");

        return ans.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.printf("removeKdigits: %s", removeKdigits(num, k));
    }
}
