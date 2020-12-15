/**
 * // 75. 颜色分类
 * // 难度：中等
 * // 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * //
 * // 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * //
 * // 进阶：
 * //
 * // 你可以不使用代码库中的排序函数来解决这道题吗？
 * // 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * //
 * // 示例 1：
 * // 输入：nums = [2,0,2,1,1,0]
 * // 输出：[0,0,1,1,2,2]
 * //
 * // 示例 2：
 * // 输入：nums = [2,0,1]
 * // 输出：[0,1,2]
 * //
 * // 示例 3：
 * // 输入：nums = [0]
 * // 输出：[0]
 * //
 * // 示例 4：
 * // 输入：nums = [1]
 * // 输出：[1]
 * //
 * // 提示：
 * // n == nums.length
 * // 1 <= n <= 300
 * // nums[i] 为 0、1 或 2
 */

package com.code.main._0_100;

class Solution_0075 {
    public void sortColors(int[] nums) {
        // 用2个指针p0和p2维护0/2的位置
        int len = nums.length;
        int p0 = 0, p2 = len - 1;
        for (int i = 0; i <= p2; i++) {
            if (nums[i] == 0 && i >= p0) {    // 找到1个0，交换
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                p0++;
            }
            if (nums[i] == 2 && i <= p2) {
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                p2--;
            }
        }
    }
}

public class _0075_sortColors {
    public static void main(String[] args) {
//        [2,0,2,1,1,0]
        int[] nums = {2, 1, 0, 0, 1, 2};
        Solution_0075 solution = new Solution_0075();
        solution.sortColors(nums);
        for (int num : nums)
            System.out.print(" " + num);
    }
}
