/**
 * // 6. Z 字形变换
 * // 难度：中等
 * // 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * //
 * // 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * //
 * // L   C   I   R
 * // E T O E S I I G
 * // E   D   H   N
 * // 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * //
 * // 请你实现这个将字符串进行指定行数变换的函数：
 * //
 * // string convert(string s, int numRows);
 * // 示例 1:
 * //
 * // 输入: s = "LEETCODEISHIRING", numRows = 3
 * // 输出: "LCIRETOESIIGEDHN"
 * // 示例 2:
 * //
 * // 输入: s = "LEETCODEISHIRING", numRows = 4
 * // 输出: "LDREOEIIECIHNTSG"
 * // 解释:
 * //
 * // L     D     R
 * // E   O E   I I
 * // E C   I H   N
 * // T     S     G
 */

package com.code.main._0_100;

import java.util.ArrayList;
import java.util.List;

class Solution_0006 {
    public String convert(String s, int numRows) {
        // 按行排序，用一个行指针和方向标识，控制字符应该放到哪一行
        if (numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows && i < s.length(); i++) {   // 初始化行列表
            list.add(new StringBuilder());
        }
        int row = 0;    // 当前行
        boolean goDown = false;  // 往下走？根据下面的方向变更条件，需要将初始值设为false
        for (char c : s.toCharArray()) {
            list.get(row).append(c);
            if (row == 0 || row == numRows - 1)     // 到达上顶部或者底部，反向
                goDown = !goDown;
            row += goDown ? 1 : -1;  // 更新行（要判断方向）
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder builder : list) {
            ans.append(builder);
        }
        return ans.toString();
    }
}

public class _0006_convert {
    public static void main(String[] args) {
        // "PAYPALISHIRING" 3
        Solution_0006 solution = new Solution_0006();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
}
