/**
 * // 49. 字母异位词分组
 * // 难度：中等
 * //
 * // 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * //
 * // 示例:
 * //
 * // 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * // 输出:
 * // [
 * // ["ate","eat","tea"],
 * // ["nat","tan"],
 * // ["bat"]
 * // ]
 * // 说明：
 * //
 * // 所有输入均为小写字母。
 * // 不考虑答案输出的顺序。
 * <p>
 * 思路：
 * 对字符串内的字符排序后，用hashmap存储排序后的字符串到相关联的字符串列表的映射
 */

package com.code.subject._07_hash_string;

import java.util.*;

class Solution_0049 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();    // 以内部字符排序后的字符串为key，以相关联的所有字符串构成的列表为value
        for (String str : strs) {
            String sortedStr = strSort(str);
            if (map.containsKey(sortedStr)) {   // 在Map中已有映射
                map.get(sortedStr).add(str);
            } else {    // 还没有映射
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);   // 添加映射
            }
        }
        // 遍历Map，存入结果
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    /**
     * 将字符串内的字符排序
     *
     * @param str 输入的字符串
     * @return 字符排序后的字符串
     */
    public String strSort(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}

public class _0049_groupAnagrams {
    public static void main(String[] args) {
        Solution_0049 solution = new Solution_0049();
        System.out.println(solution.strSort("tea"));

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = solution.groupAnagrams(strs);
        System.out.println(list);

    }
}
