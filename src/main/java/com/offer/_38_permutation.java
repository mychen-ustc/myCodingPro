/**
 * // 38. 字符串的排列
 * // 难度：中等
 * // 输入一个字符串，打印出该字符串中字符的所有排列。
 * //
 * // 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * //
 * // 示例:
 * // 输入：s = "abc"
 * // 输出：["abc","acb","bac","bca","cab","cba"]
 * //
 * // 限制：
 * // 1 <= s 的长度 <= 8
 */

package com.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_38 {
    public String[] permutation(String s) {
        if (s.length() == 0)
            return new String[0];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        // 先求字符串的所有排列，用一个集合辅助去重
        List<String> ans = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        boolean[] used = new boolean[s.length()];   // 状态数组
        dfs(chars, 0, used, path, ans);
        return ans.toArray(new String[0]);
    }

    /**
     * 递归求解字符排列
     *
     * @param chars 字符数组
     * @param depth 递归深度
     * @param used  状态数组
     * @param path  当前得到的路径
     * @param ans   结果集
     */
    public void dfs(char[] chars, int depth, boolean[] used, StringBuffer path, List<String> ans) {
        int len = chars.length;
        if (depth == len) {
            ans.add(path.toString());
            return;
        }
        for (int i = 0; i < len; i++) {     // 每一轮递归，需要寻找一个可用的数字
            if (!used[i]) {
                if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {  // 首字符重复，会带来重复解，剪枝
                    continue;
                }
                path.append(chars[i]);
                used[i] = true;     // 设置状态为已使用
                dfs(chars, depth + 1, used, path, ans);
                // 回退
                path.deleteCharAt(path.length() - 1);     // 删掉最后加入的字符
                used[i] = false;    // 回退状态
            }
        }
    }
}

public class _38_permutation {
    public static void main(String[] args) {
        Solution_38 solution = new Solution_38();
        String[] ans = solution.permutation("abca");
        System.out.println(ans);
    }
}
