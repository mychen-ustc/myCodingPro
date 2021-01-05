/**
 * // 12. 整数转罗马数字
 * // 难度：中等
 * // 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * //
 * // 字符          数值
 * // I             1
 * // V             5
 * // X             10
 * // L             50
 * // C             100
 * // D             500
 * // M             1000
 * // 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * //
 * // 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * //
 * // I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * // X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * // C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * // 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * //
 * // 示例 1:
 * // 输入: 3
 * // 输出: "III"
 * //
 * // 示例 2:
 * // 输入: 4
 * // 输出: "IV"
 * //
 * // 示例 3:
 * // 输入: 9
 * // 输出: "IX"
 * //
 * // 示例 4:
 * // 输入: 58
 * // 输出: "LVIII"
 * // 解释: L = 50, V = 5, III = 3.
 * //
 * // 示例 5:
 * // 输入: 1994
 * // 输出: "MCMXCIV"
 * // 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */

package com.code.main._0_100;

import java.util.HashMap;
import java.util.Map;

class Solution_0012 {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>() {
            {
                put(1, "I");
                put(4, "IV");
                put(5, "V");
                put(9, "IX");
                put(10, "X");
                put(40, "XL");
                put(50, "L");
                put(90, "XC");
                put(100, "C");
                put(400, "CD");
                put(500, "D");
                put(900, "CM");
                put(1000, "M");
            }
        };
        StringBuilder sbuild = new StringBuilder();
        String str = String.valueOf(num);   // 将整数转为字符串
        int power = str.length() - 1;   // 记录整数位10的多少次方
        int i = 0;
        while (i < power) {
            int digit = str.charAt(i);
            int tmp = (int) Math.pow(10, digit);
        }
    }
}

public class _0012_intToRoman {
    public static void main(String[] args) {
        // 3
        Solution_0012 solution = new Solution_0012();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
    }
}
