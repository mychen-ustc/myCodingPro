/**
 * // 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * // 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * //
 * // 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * //
 * // 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */

package com.code.main._701_800;

import java.util.Deque;
import java.util.LinkedList;

class Solution_0739 {
    public int[] dailyTemperatures(int[] T) {
        // 朴素做法: 暴力求解，2层循环 16%
//        int len = T.length;
//        int[] ans = new int[len];
//        for (int i = 0; i < len; i++) {
//            int j = i + 1;
//            while (j < len && T[j] <= T[i])
//                j++;
//            if (j < len)
//                ans[i] = j - i;
//        }
//        return ans;


        // 解法2: 暴力求解优化，由于温度范围是30~100，可以用长度100的数组维护每个温度第一次出现的位置，提高内层循环效率
        // O(mn) & O(m) 84.6% (16ms vs 1160ms)
//        int length = T.length;
//        int[] ans = new int[length];
//        int[] next = new int[101];
//        Arrays.fill(next, Integer.MAX_VALUE);
//        for (int i = length - 1; i >= 0; --i) {
//            int warmerIndex = Integer.MAX_VALUE;
//            for (int t = T[i] + 1; t <= 100; ++t) {
//                if (next[t] < warmerIndex) {
//                    warmerIndex = next[t];
//                }
//            }
//            if (warmerIndex < Integer.MAX_VALUE) {
//                ans[i] = warmerIndex - i;
//            }
//            next[T[i]] = i;
//        }
//        return ans;


        // 解法3: 单调栈 O(n) & O(n) 84.6%
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}

public class _0739_dailyTemperatures {
    public static void main(String[] args) {
        // [73,74,75,71,69,72,76,73]
        Solution_0739 solution = new Solution_0739();
        int[] ans = solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int num : ans)
            System.out.println(num);
    }
}
