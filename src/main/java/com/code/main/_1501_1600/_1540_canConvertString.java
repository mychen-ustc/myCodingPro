/**
 * // 1540. K 次操作转变字符串
 * // 难度：中等
 * // 给你两个字符串 s 和 t ，你的目标是在 k 次操作以内把字符串 s 转变成 t 。
 * //
 * // 在第 i 次操作时（1 <= i <= k），你可以选择进行如下操作：
 * //
 * // 选择字符串 s 中满足 1 <= j <= s.length 且之前未被选过的任意下标 j （下标从 1 开始），并将此位置的字符切换 i 次。
 * // 不进行任何操作。
 * // 切换 1 次字符的意思是用字母表中该字母的下一个字母替换它（字母表环状接起来，所以 'z' 切换后会变成 'a'）。
 * //
 * // 请记住任意一个下标 j 最多只能被操作 1 次。
 * //
 * // 如果在不超过 k 次操作内可以把字符串 s 转变成 t ，那么请你返回 true ，否则请你返回 false 。
 * //
 * // 示例 1：
 * // 输入：s = "input", t = "ouput", k = 9
 * // 输出：true
 * // 解释：第 6 次操作时，我们将 'i' 切换 6 次得到 'o' 。第 7 次操作时，我们将 'n' 切换 7 次得到 'u' 。
 * //
 * // 示例 2：
 * // 输入：s = "abc", t = "bcd", k = 10
 * // 输出：false
 * // 解释：我们需要将每个字符切换 1 次才能得到 t 。我们可以在第 1 次操作时将 'a' 切换成 'b' ，但另外 2 个字母在剩余操作中无法再转变为 t 中对应字母。
 * //
 * // 示例 3：
 * // 输入：s = "aab", t = "bbb", k = 27
 * // 输出：true
 * // 解释：第 1 次操作时，我们将第一个 'a' 切换 1 次得到 'b' 。在第 27 次操作时，我们将第二个字母 'a' 切换 27 次得到 'b' 。
 * //  
 * // 提示：
 * // 1 <= s.length, t.length <= 10^5
 * // 0 <= k <= 10^9
 * // s 和 t 只包含小写英文字母。
 * //
 * // 思路：这个题目理解起来有点费劲
 * // 这题目的意思是，第 i 次操作时，只能操作改变一个之前没改变过的字母，把这个字母像圆盘一样向后转 i 个字母
 * // 如果有两个字母都要向后转 j 个字母才能转对，那另一个就要等到下一圈，即多转 26 个
 * // 模拟操作即可
 * // 使用一个转动次数记录，如果多个字母刚好都是转 j 次，那就每多一个多 + 26
 * // 然后将所有字母依次都转了，取最大需要转的次数
 * // 开始的时候要判断字符串长度是否相等
 */

package com.code.main._1501_1600;

class Solution_1540 {
    public boolean canConvertString(String s, String t, int k) {
        // 要用转盘的思维去模拟操作，第i次操作可以选一个字母往后转i个字母。接下来的操作就是转i+1个字母...
        if (s.length() != t.length()) return false;
        int len = s.length();
        int[] counts = new int[26];
        for (int i = 0; i < len; i++) {     // 统计每个字母最少需要的切换次数
            int diff = t.charAt(i) - s.charAt(i);
            if (diff < 0)
                diff += 26;
            counts[diff]++;
        }
        for (int i = 1; i < 26; i++) {
            int maxConv = i + 26 * (counts[i] - 1);     // 如果多个字母需要相同的切换次数，需要多等1圈
            if (maxConv > k)
                return false;
        }
        return true;
    }
}

public class _1540_canConvertString {
    public static void main(String[] args) {
        // "input" "ouput" 9
        Solution_1540 solution = new Solution_1540();
        System.out.println(solution.canConvertString("input", "ouput", 9));
        System.out.println(solution.canConvertString("abc", "bcd", 10));
        System.out.println(solution.canConvertString("aab", "bbb", 27));

    }
}
