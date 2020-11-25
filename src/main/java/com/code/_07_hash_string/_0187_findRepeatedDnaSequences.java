/**
 * // 187. 重复的DNA序列
 * // 难度：中等
 * //
 * // 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * //
 * // 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * //
 * //  
 * //
 * // 示例 1：
 * //
 * // 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * // 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * // 示例 2：
 * //
 * // 输入：s = "AAAAAAAAAAAAA"
 * // 输出：["AAAAAAAAAA"]
 * //  
 * //
 * // 提示：
 * //
 * // 0 <= s.length <= 10^5
 * // s[i] 为 'A'、'C'、'G' 或 'T'
 * //
 * // 来源：力扣（LeetCode）
 * // 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package com.code._07_hash_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_0187 {
    public List<String> findRepeatedDnaSequences(String s) {
        final int SUB_STR_LEN = 10;
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - SUB_STR_LEN + 1; i++) {
            String substr = s.substring(i, i + SUB_STR_LEN);    // 提取子串
            if (map.containsKey(substr)) {
                map.put(substr, map.get(substr) + 1);
            } else {
                map.put(substr, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                result.add(entry.getKey());
        }
        return result;
    }
}

public class _0187_findRepeatedDnaSequences {
    public static void main(String[] args) {
        String str = "AAAAAAAAAAA";
        Solution_0187 solution = new Solution_0187();
        List<String> result = solution.findRepeatedDnaSequences(str);
        System.out.println(result);
    }
}
