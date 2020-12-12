/**
 * // 409. 最长回文串
 * // 难度：简单
 * //
 * // 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * //
 * // 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * //
 * // 注意:
 * // 假设字符串的长度不会超过 1010。
 * //
 * // 示例 1:
 * //
 * // 输入:
 * // "abccccdd"
 * //
 * // 输出:
 * // 7
 * //
 * // 解释:
 * // 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 思路：使用字符串中的所有字符，任务组合，生成新的字符串。如果生成的字符串为回文字符串，需要除了中心字符，其他字符只要头部出现，尾部就要对应出现。
 * 如果字符数量是偶数，则可以全部用上，只要头尾各放一个即可。
 * 如果字符数量是奇数，可丢掉一个字符，剩余个数为偶数个，可全部用上
 * 如果有多个字符数量为奇数，最后操作后只能取一个放在中心位置。
 */

package com.code.subject._07_hash_string;

class Solution_0409_2 {
    public int longestPalindrome(String s) {
        int[] charMap = new int[128];  // 存储每个字符的数量(这里不用hashmap，直接用数组)，默认初始化为0
        int maxLen = 0; // 最长回文字符串的长度
        int flag = 0;   // 是否存在奇数个字符的情况
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charMap[ch] += 1;   // 字符可当做数字用于数组的索引
        }
        for (int i = 0; i < 128; i++) {
            if (charMap[i] % 2 == 0) {
                maxLen += charMap[i];
            } else {
                maxLen += charMap[i] - 1;
                flag = 1;
            }
        }

        return maxLen + flag;
    }
}

public class _0409_longestPalindrome_2 {
    public static void main(String[] args) {
//        String s = "abccccdd";
        String s = "abccccddaa";
        Solution_0409_2 solution = new Solution_0409_2();
        int max = solution.longestPalindrome(s);
        System.out.println(max);
    }
}
