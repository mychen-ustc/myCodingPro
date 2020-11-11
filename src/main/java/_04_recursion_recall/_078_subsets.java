/**
 * 78. 子集
 * 难度：中等
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package _04_recursion_recall;

import java.util.ArrayList;
import java.util.List;

class Solution078 {
    //
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public void generate(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            generate(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        generate(nums, 0);
        return res;
    }
}

public class _078_subsets {

    public static void main(String[] args) {
        Solution078 solution = new Solution078();
        int nums[] = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}
