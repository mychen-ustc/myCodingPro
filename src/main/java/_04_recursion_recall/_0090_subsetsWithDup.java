/**
 * 90. 子集 II
 * 难度：中等
 * <p>
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 */

package _04_recursion_recall;

import java.util.List;

class Solution0090 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return null;
    }
}

public class _0090_subsetsWithDup {
    public static void main(String[] args) {
        Solution0090 solution = new Solution0090();
        int nums[] = {1, 2, 3};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        System.out.println(result);
    }

}
