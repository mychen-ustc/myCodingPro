/**
 * // 4. 寻找两个正序数组的中位数
 * // 难度：困难
 * // 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * //
 * // 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * //
 * // 示例 1：
 * // 输入：nums1 = [1,3], nums2 = [2]
 * // 输出：2.00000
 * // 解释：合并数组 = [1,2,3] ，中位数 2
 * //
 * // 示例 2：
 * // 输入：nums1 = [1,2], nums2 = [3,4]
 * // 输出：2.50000
 * // 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * //
 * // 示例 3：
 * // 输入：nums1 = [0,0], nums2 = [0,0]
 * // 输出：0.00000
 * //
 * // 示例 4：
 * // 输入：nums1 = [], nums2 = [1]
 * // 输出：1.00000
 * //
 * // 示例 5：
 * // 输入：nums1 = [2], nums2 = []
 * // 输出：2.00000
 * //  
 * //
 * // 提示：
 * // nums1.length == m
 * // nums2.length == n
 * // 0 <= m <= 1000
 * // 0 <= n <= 1000
 * // 1 <= m + n <= 2000
 * // -10^6 <= nums1[i], nums2[i] <= 10^6
 */

package com.code.main._0_100;

class Solution_0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 双指针：O(m+n). 时间能击败100%用户。性能没达到hard的要求，但是容易掌握，效率较高
        // 要达到o(log(m+n))则需要用二分查找
        int m = nums1.length, n = nums2.length;
        int midIndex = (m + n) / 2;     // 中间值索引
        int mid1 = 0, mid2 = 0;     // 定义2个临时变量用于求中位数
        int p1 = 0, p2 = 0;     // 用2个指针分别指向2个数组
        while (true) {     // 寻找第mid个数
            if (p1 + p2 == midIndex + 1) break;     // 退出循环
            mid1 = mid2;
            // 某个指针达到边界，只迭代另一个指针
            if (p1 == nums1.length) {
                mid2 = nums2[p2++];
                continue;
            }
            if (p2 == nums2.length) {
                mid2 = nums1[p1++];
                continue;
            }
            mid2 = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];   // 2个指针都没到边界，正常迭代
        }
        return (m + n) % 2 == 0 ? (mid1 + mid2) / 2.0 : mid2;
    }
}

public class _0004_findMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 7, 9};
        int[] nums2 = {4, 5, 6, 8};
        Solution_0004 solution = new Solution_0004();
        double ans = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }
}
