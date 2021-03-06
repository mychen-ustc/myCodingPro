/**
 * 315. 计算右侧小于当前元素的个数
 * 难度：困难
 * <p>
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * <p>
 * 思路：
 * 最暴力的方法，对每个元素扫描右侧壁它小的个数累加。算法复杂度0(N^2)
 *
 */

package com.code.subject._04_recursion_backtrack_division;

import java.util.ArrayList;
import java.util.List;

class Solution_0351_2 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();

        return result;
    }
}

public class _0351_countSmaller2 {

    public static void main(String[] args) {
        Solution_0351_2 solution = new Solution_0351_2();
        int nums[] = {5, -7, 9, 1, 3, 5, -2, 1};
        System.out.println(solution.countSmaller(nums));
    }
}
