/**
 * // 16.15. 珠玑妙算
 * // 难度：简单
 * // 珠玑妙算游戏（the game of master mind）的玩法如下。
 * //
 * // 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * //
 * // 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 * //
 * // 示例：
 * // 输入： solution="RGBY",guess="GGRR"
 * // 输出： [1,1]
 * // 解释： 猜中1次，伪猜中1次。
 * // 提示：
 * //
 * // len(solution) = len(guess) = 4
 * // solution和guess仅包含"R","G","B","Y"这4种字符
 */

package com.interview;

import java.util.HashMap;
import java.util.Map;

class Solution_16_15 {
    public int[] masterMind(String solution, String guess) {
        Map<Character, Integer> mapSolution = new HashMap<>();    // 统计solution中的字符频率:猜中的不放进去
        Map<Character, Integer> mapGuess = new HashMap<>();    // 统计guess中的字符频率:猜中的不放进去
        int right = 0;    // 猜中次数
        int falseRight = 0;     // 伪猜中次数
        for (int i = 0; i < 4; i++) {
            char ch1 = solution.charAt(i);
            char ch2 = guess.charAt(i);
            if (ch1 == ch2) {   // 猜中: 不更新map中的频率
                right++;
            } else {    // 没有猜中，更新频率
                mapSolution.put(ch1, mapSolution.getOrDefault(ch1, 0) + 1);     // 更新频率
                mapGuess.put(ch2, mapGuess.getOrDefault(ch2, 0) + 1);     // 更新频率
            }
        }
        // 遍历完后再计算伪猜中次数
        for (char ch : mapGuess.keySet()) {
            falseRight += Math.min(mapSolution.getOrDefault(ch, 0), mapGuess.get(ch));
        }
        return new int[]{right, falseRight};
    }
}

public class _16_15_masterMind {
    public static void main(String[] args) {
        String solution = "RGBG";
        String guess = "GGRR";
        Solution_16_15 s = new Solution_16_15();
        int[] ans = s.masterMind(solution, guess);
        for (int num : ans)
            System.out.println(num);
    }
}
