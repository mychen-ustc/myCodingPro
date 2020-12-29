/**
 * // 8. 字符串转换整数 (atoi)
 * // 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * //
 * // 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * //
 * // 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * // 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * // 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * // 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * //
 * // 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * //
 * // 提示：
 * // 本题中的空白字符只包括空格字符 ' ' 。
 * // 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * //  
 * // 示例 1:
 * // 输入: "42"
 * // 输出: 42
 * //
 * // 示例 2:
 * // 输入: "   -42"
 * // 输出: -42
 * // 解释: 第一个非空白字符为 '-', 它是一个负号。
 * //      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * //
 * // 示例 3:
 * // 输入: "4193 with words"
 * // 输出: 4193
 * // 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * //
 * // 示例 4:
 * // 输入: "words and 987"
 * // 输出: 0
 * // 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * // 因此无法执行有效的转换。
 * //
 * // 示例 5:
 * // 输入: "-91283472332"
 * // 输出: -2147483648
 * // 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * //      因此返回 INT_MIN (−231) 。
 */

package com.code.main._0_100;

class Solution_0008 {
    public int myAtoi(String s) {
//        if (s.length() == 0) return 0;
//        int flag = 1;
//        int ans = 0;
//        int i = 0;
//        int INT_MAX = Integer.MAX_VALUE;
//        while (i < s.length() && s.charAt(i) == ' ') i++;    // 跳过初始的空格
//        if (i == s.length()) return 0;  // 对于极端情况：字符串只包含空格
//        char ch = s.charAt(i);
//        if (ch == '-') {
//            flag = -1;
//            i++;
//        } else if (ch == '+') {
//            flag = 1;
//            i++;
//        } else if (ch < '0' && ch > '9') {    // 不能进行有效转换
//            return 0;
//        }
//        // 可以进行有效转换
//        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {  // 遍历连续的数字
//            int digit = s.charAt(i) - '0';
//            if (ans < INT_MAX / 10 || (ans == INT_MAX / 10 && flag == 1 && digit < 7)
//                    || (ans == INT_MAX / 10 && flag == -1 && digit < 8)) { // 还没有溢出
//                ans = ans * 10 + digit;
//            } else {
//                ans = flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//                return ans;
//            }
//            i++;
//        }
//
//        return ans * flag;


        // 参考写法
        int index = 0;
        int sign = 1;
        int total = 0;
        if (s.length() == 0) {
            return 0;
        }
        // 移除左侧的空格
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index >= s.length()) {  // 只包含空格
            return 0;
        }
        // 找到正负号
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }

            if (Integer.MAX_VALUE / 10 < total
                    || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }
}

public class _0008_myAtoi {
    public static void main(String[] args) {
        // "42"
        Solution_0008 solution = new Solution_0008();
//        System.out.println(solution.myAtoi(""));
//        System.out.println(solution.myAtoi("    "));
//        System.out.println(solution.myAtoi("  42"));
//        System.out.println(solution.myAtoi("  -42"));
//        System.out.println(solution.myAtoi("  -+42"));
//        System.out.println(solution.myAtoi("  4193 with words"));
//        System.out.println(solution.myAtoi("  words and 987"));
//        System.out.println(solution.myAtoi("  -91283472332"));
//        System.out.println(solution.myAtoi("2147483648"));
        System.out.println(solution.myAtoi("2147483646"));
        System.out.println(solution.myAtoi("2147483647"));
        System.out.println(solution.myAtoi("-2147483647"));
        System.out.println(solution.myAtoi("-2147483648"));

    }
}
