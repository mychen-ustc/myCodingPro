/**
 * // 1578. 避免重复字母的最小删除成本
 * // 难度：中等
 * // 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
 * //
 * // 返回使字符串任意相邻两个字母不相同的最小删除成本。
 * //
 * // 请注意，删除一个字符后，删除其他字符的成本不会改变。
 * //
 * // 示例 1：
 * // 输入：s = "abaac", cost = [1,2,3,4,5]
 * // 输出：3
 * // 解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。
 * //
 * // 示例 2：
 * // 输入：s = "abc", cost = [1,2,3]
 * // 输出：0
 * // 解释：无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
 * //
 * // 示例 3：
 * // 输入：s = "aabaa", cost = [1,2,3,4,1]
 * // 输出：2
 * // 解释：删除第一个和最后一个字母，得到字符串 ("aba") 。
 * //  
 * //
 * // 提示：
 * // s.length == cost.length
 * // 1 <= s.length, cost.length <= 10^5
 * // 1 <= cost[i] <= 10^4
 * // s 中只含有小写英文字母
 * //
 * // 思路与算法
 * // 根据题意可以知道，如果字符串中有若干相邻的重复字母，则这些字母中最多只能保留一个。
 * // 因此，我们可以采取贪心的策略：在这一系列重复字母中，我们保留删除成本最高的字母，并删除其他字母。这样得到的删除成本一定是最低的。
 */

package com.code.main._1501_1600;

class Solution_1578 {
    public int minCost(String s, int[] cost) {
        // 贪心解法：对连续相同的字符，保留成本最大的
        int len = s.length();
        int ans = 0;
        int i = 0;
        while (i < len) {
            char ch = s.charAt(i);  // 当前字符
            int maxCost = 0;
            int sum = 0;    // 累计当前字符的总成本
            while (i < len && s.charAt(i) == ch) {
                maxCost = Math.max(maxCost, cost[i]);   // 更新最大成本
                sum += cost[i];
                i++;
            }
            ans += sum - maxCost;
        }
        return ans;
    }
}

public class _1578_minCost {
    public static void main(String[] args) {
        // "abaac"
        // [1,2,3,4,5]
        String s = "abaaccdd";
        int[] cost = {1, 2, 3, 4, 5, 6, 7, 8};
        Solution_1578 solution = new Solution_1578();
        int ans = solution.minCost(s, cost);
        System.out.println(ans);
    }
}
