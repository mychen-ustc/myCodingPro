/**
 * // 394. 字符串解码
 * // 难度：中等
 * // 给定一个经过编码的字符串，返回它解码后的字符串。
 * //
 * // 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * //
 * // 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * //
 * // 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * //
 * // 示例 1：
 * // 输入：s = "3[a]2[bc]"
 * // 输出："aaabcbc"
 * //
 * // 示例 2：
 * // 输入：s = "3[a2[c]]"
 * // 输出："accaccacc"
 * //
 * // 示例 3：
 * // 输入：s = "2[abc]3[cd]ef"
 * // 输出："abcabccdcdcdef"
 * //
 * // 示例 4：
 * // 输入：s = "abc3[cd]xyz"
 * // 输出："abccdcdcdxyz"
 */

package com.code.main._301_400;

import java.util.Collections;
import java.util.LinkedList;

class Solution_0394 {
    int ptr;

    public String decodeString(String s) {
        // 设计括号匹配的问题，用栈存储待处理的数字和字符串
        LinkedList<String> stk = new LinkedList<>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}

public class _0394_decodeString {
    public static void main(String[] args) {
        // "3[a]2[bc]",输出 aaabcbc
        // "3[a2[c]]",输出 accaccacc
        // "2[abc]3[cd]ef",输出 abcabccdcdcdef
        // "abc3[cd]xyz", 输出 abccdcdcdxyz
        String s = "3[a2[c]]";
        Solution_0394 solution = new Solution_0394();
        String ans = solution.decodeString(s);
        System.out.println(ans);
    }
}
