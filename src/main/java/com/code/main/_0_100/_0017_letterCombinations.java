/**
 * // 17. 电话号码的字母组合
 * // 难度：中等
 * // 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * //
 * // 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 参考图 _0017_telephone_keypad.png
 * //
 * // 示例:
 * // 输入："23"
 * // 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * //
 * // 说明:
 * // 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */

package com.code.main._0_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_0017 {
    public List<String> letterCombinations(String digits) {
        // 思路：递归回溯
        if (digits.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        Map<Character, String> map = new HashMap<Character, String>() {{    // 创建映射
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrace(digits, 0, ans, new StringBuffer(), map);
        return ans;
    }

    // 回溯处理后续字符
    public void backtrace(String digits, int index, List<String> combinations, StringBuffer combination, Map<Character, String> map) {
        if (combination.length() == digits.length()) {  // 找到一种组合
            combinations.add(combination.toString());
            return;
        }
        char digit = digits.charAt(index);  // 当前的输入字符
        char[] chars = map.get(digit).toCharArray();  // 获取字符对应的字母映射
        for (int i = 0; i < chars.length; i++) {    // 遍历字母映射
            char ch = chars[i];
            combination.append(ch);     // 追加字母
            backtrace(digits, index + 1, combinations, combination, map);   // 处理后续字符
            combination.deleteCharAt(combination.length() - 1);     // 删除最后一个字母，回溯
        }
    }
}

public class _0017_letterCombinations {
    public static void main(String[] args) {
        // 输入："23"
        // 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
        Solution_0017 solution = new Solution_0017();
        System.out.println(solution.letterCombinations("2"));
        System.out.println(solution.letterCombinations("3"));
        System.out.println(solution.letterCombinations("4"));
        System.out.println(solution.letterCombinations("5"));
        System.out.println(solution.letterCombinations("6"));
        System.out.println(solution.letterCombinations("7"));
        System.out.println(solution.letterCombinations("8"));
        System.out.println(solution.letterCombinations("9"));
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("234"));
    }
}
