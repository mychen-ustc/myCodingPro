/**
 * // 42. 接雨水
 * // 难度：困难
 * //
 * // 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * //
 * // 示例 1：
 * // （见图1:  _0042_rainwatertrap.png）
 * // 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * // 输出：6
 * // 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * // 示例 2：
 * //
 * // 输入：height = [4,2,0,3,2,5]
 * // 输出：9
 * //
 * // 提示：
 * //
 * // n == height.length
 * // 0 <= n <= 3 * 10^4
 * // 0 <= height[i] <= 10^5
 * <p>
 * //  思路：4
 * // 从动态编程方法的示意图中我们注意到，只要 \text{right\_max}[i]>\text{left\_max}[i]right_max[i]>left_max[i] （元素 0 到元素 6），积水高度将由 left_max 决定，类似地 \text{left\_max}[i]>\text{right\_max}[i]left_max[i]>right_max[i]（元素 8 到元素 11）。
 * // 所以我们可以认为如果一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。当我们发现另一侧（右侧）的条形块高度不是最高的，我们则开始从相反的方向遍历（从右到左）。
 * // 我们必须在遍历时维护 \text{left\_max}left_max 和 \text{right\_max}right_max ，但是我们现在可以使用两个指针交替进行，实现 1 次遍历即可完成。
 * //
 * // 算法：
 * // 1 初始化left指针为0，并且right指针为size-1
 * // 2 while left < right, do:
 * //   2.1 if height[left] < height[right]
 * //     2.1.1 if height[left] >= left_max, 更新left_max=height[left]
 * //     2.1.2 else 累加 left_max - height[left]到 sum
 * //     2.1.3 left = left+1
 * //   2.2 else:
 * //     2.2.1 if height[right] >= right_max, 更新right_max
 * //     2.2.2 else 累加 right_max-height[right] 到sum
 * //     2.2.3 right = right + 1
 */

package com.code.other;

class Solution_0042 {
    public int trap(int[] height) {
        int sum = 0;    // 雨水总量
        int left = 0;   // 左指针
        int right = height.length - 1;
        int left_max = 0, right_max = 0;    // 左右两侧已扫描的最大高度
        while (left < right) {
            if (height[left] < height[right]) {     // 左边的高度小于右边，处理和移动左指针
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    sum += (left_max - height[left]);   // 累加雨水
                }
                left++;
            } else {    // 右边的高度小于左边，处理和移动右指针
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    sum += (right_max - height[right]);     // 累加雨水
                }
                right--;
            }
        }
        return sum;
    }
}

public class _0042_trap4 {
    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = {4, 2, 0, 3, 2, 5};
        Solution_0042 solution = new Solution_0042();
        int water = solution.trap(height);
        System.out.println(water);
    }
}
