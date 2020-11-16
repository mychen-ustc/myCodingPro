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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 思路：
 * 最暴力的方法，对每个元素扫描右侧壁它小的个数累加。算法复杂度0(N^2)
 * <p>
 * 归并排序计算逆序数 + 索引数组
 * 使用「归并排序」求解这道问题，需要有求解「逆序对」的经验。可以先做一下「力扣」剑指 Offer 51. 数组中的逆序对；
 * <p>
 * 求解「逆序对」的思想：当其中一个数字放进最终归并以后的有序数组中的时候，这个数字与之前看过的数字个数（或者是未看过的数字个数）可以直接统计出来，而不必一个一个数。这样排序完成以后，原数组的逆序数也就计算出来了；
 * 具体来说，本题让我们求「在一个数组的某个元素的右边，比自己小的元素的个数」，因此，需要在「前有序数组」的元素归并的时候，数一数「后有序数组」已经归并回去的元素的个数，因为这些已经出列的元素都比当前出列的元素要（严格）小；
 * 但是在「归并」的过程中，元素的位置会发生变化，因此下一步需要思考如何定位元素；根据「索引堆」的学习经验，一个元素在算法的执行过程中位置发生变化，我们还想定位它，可以使用「索引数组」，技巧在于：「原始数组」不变，用于比较两个元素的大小，真正位置变化的是「索引数组」的位置；
 * 「索引数组」技巧建立了一个一一对应的关系，记录了当前操作的数对应的「原始数组」的下标，「索引数组」技巧想法的来源是「索引堆」（《算法（第 4 版）》第 2.4 节 练习）；
 * 「归并排序」还需要一个用于归并的辅助数组，这个时候拷贝的就是索引数组的值了。
 * <p>
 * 作者：liweiwei1419
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/gui-bing-pai-xu-suo-yin-shu-zu-python-dai-ma-java-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package _04_recursion_backtrack_division;

import java.util.ArrayList;
import java.util.List;

class Solution_0351 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return result;
        }

        int[] res = new int[len];

        // 索引数组，作用：归并回去的时候，方便知道是哪个下标的元素
        int[] indexes = new int[len];
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        mergeAndCountSmaller(nums, 0, len - 1, indexes, res);

        // 把 int[] 转换成为 List<Integer>，没有业务逻辑
        for (int i = 0; i < len; i++) {
            result.add(res[i]);
        }
        return result;
    }

    /**
     * 针对数组 nums 指定的区间 [left, right] 进行归并排序，在排序的过程中完成统计任务
     *
     * @param nums
     * @param left
     * @param right
     */
    private void mergeAndCountSmaller(int[] nums, int left, int right, int[] indexes, int[] res) {
        if (left == right) {    // 递归终止条件
            return;
        }
        int mid = left + (right - left) / 2;
        mergeAndCountSmaller(nums, left, mid, indexes, res);
        mergeAndCountSmaller(nums, mid + 1, right, indexes, res);

        // 归并排序的优化，如果索引数组有序，则不存在逆序关系，没有必要合并
        if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {     // 右半边都比左半边大，已经整体有序
            return;
        }
        mergeOfTwoSortedArrAndCountSmaller(nums, left, mid, right, indexes, res);
    }

    /**
     * [left, mid] 是排好序的，[mid + 1, right] 是排好序的
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param indexes
     * @param res
     */
    private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int left, int mid, int right, int[] indexes, int[] res) {
        int[] temp = new int[nums.length];  // 临时数组，备份索引数组
        for (int i = left; i <= right; i++) {
            temp[i] = indexes[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {  // 左半边完成排序
                indexes[k] = temp[j];
                j++;
            } else if (j > right) { // 右半边完成排序
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (right - mid);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                // 注意：这里是 <= ，保证稳定性
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (j - mid - 1);
            } else {
                indexes[k] = temp[j];
                j++;
            }
        }
    }
}

public class _0351_countSmaller {

    public static void main(String[] args) {
        Solution_0351 solution = new Solution_0351();
        int nums[] = {5, -7, 9, 1, 3, 5, -2, 1};
        System.out.println(solution.countSmaller(nums));
    }
}
