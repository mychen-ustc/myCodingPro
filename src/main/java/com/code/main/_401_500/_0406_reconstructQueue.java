/**
 * // 406. 根据身高重建队列
 * // 难度：中等
 * // 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * // 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * //
 * // 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * // 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * //
 * // 示例 1：
 * // 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * // 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * // 解释：
 * // 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * // 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * // 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * // 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * // 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * // 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * // 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 * //
 * // 示例 2：
 * // 输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * // 输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 * //  
 * //
 * // 提示：
 * // 1 <= people.length <= 2000
 * // 0 <= hi <= 10^6
 * // 0 <= ki < people.length
 * // 题目数据确保队列可以被重建
 * //
 * // 思路: 见 _0406_1.png
 */

package com.code.main._401_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_0406 {
    public int[][] reconstructQueue(int[][] people) {
        // 解法1：将输入数组排序：优先按身高升序，身高相同时按Ki逆序: 从左到右放入第ki+1个空位置
//        Arrays.sort(people, (p1, p2) -> {
//            if (p1[0] != p2[0]) {   // 如果身高不相同，按身高升序排列: 优先选取身高较小的人
//                return p1[0] - p2[0];
//            } else {
//                return p2[1] - p1[1];   // 如果身高相同，按ki逆序排列: 优先选取ki较小的人
//            }
//        });
//        int n = people.length;
//        int[][] ans = new int[n][];
//        for (int[] peo : people) {
//            int spaces = peo[1] + 1;    // 要放入第几个空位
//            for (int i = 0; i < n; i++) {
//                if (ans[i] == null) {
//                    spaces--;
//                    if (spaces == 0) {
//                        ans[i] = peo;   // 将人放入对应的空位
//                        break;
//                    }
//                }
//            }
//        }
//        return ans;

        // 解法2：将输入数组排序：优先按身高逆序，身高相同时按Ki升序。性能优于解法1
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] != p2[0]) {   // 如果身高不相同，按身高升序排列: 优先选取身高较小的人
                return p2[0] - p1[0];
            } else {
                return p1[1] - p2[1];   // 如果身高相同，按ki逆序排列: 优先选取ki较小的人
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] peo : people) {
            ans.add(peo[1], peo);   // 插队，插到第ki个位置。排序规则决定了插进去不会对前后的人有影响
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

public class _0406_reconstructQueue {
    public static void main(String[] args) {
        // [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Solution_0406 solution = new Solution_0406();
        int[][] ans = solution.reconstructQueue(people);
        for (int[] peo : ans) {
            System.out.println(peo[0] + "," + peo[1]);
        }
    }
}
