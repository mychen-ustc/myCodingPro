/**
 * // 605. 种花问题
 * // 难度：简单
 * // 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * //
 * // 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * //
 * // 示例 1:
 * // 输入: flowerbed = [1,0,0,0,1], n = 1
 * // 输出: True
 * //
 * // 示例 2:
 * // 输入: flowerbed = [1,0,0,0,1], n = 2
 * // 输出: False
 * //
 * // 注意:
 * // 数组内已种好的花不会违反种植规则。
 * // 输入的数组长度范围为 [1, 20000]。
 * // n 是非负整数，且不会超过输入数组的大小。
 * //
 * // 思路：贪心
 * // 我们从左到右扫描数组 flowerbed，如果数组中有一个 0，并且这个 0 的左右两侧都是 0，那么我们就可以在这个位置种花，
 * // 即将这个位置的 0 修改成 1，并将计数器 count 增加 1。对于数组的第一个和最后一个位置，我们只需要考虑一侧是否为 0。
 * //
 * // 在扫描结束之后，我们将 count 与 n 进行比较。如果 count >= n，那么返回 True，否则返回 False。
 */

package com.code.main._601_700;

class Solution_0605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // ****************************** 我自己的解法：有点啰嗦 *********************************
//        int len = flowerbed.length;     // 地块数量
//        // 贪心算法求解：如果某个位置为0，且两侧都是0，就在该位置种花
//        int count = 0;  // 能种多少花
//        int i = 0;
//
//        while (i < len) {  // 遍历每个位置
//            if (flowerbed[i] == 0) {    // 当前位置没有种花
//                if ((i == 0 && i + 1 < len && flowerbed[i + 1] == 0) || (i == 0 && len == 1)) {    // 对第一块地做检查
//                    flowerbed[i] = 1;   // 种花
//                    count++;
//                } else if (i == len - 1 && i - 1 >= 0 && flowerbed[i - 1] == 0) {   // 对第一块地做检查
//                    flowerbed[i] = 1;   // 种花
//                    count++;
//                } else {
//                    if (flowerbed[i] == 0 && i - 1 >= 0 && i + 1 < len && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
//                        flowerbed[i] = 1;
//                        count++;
//                    }
//                }
//            }
//            i++;
//        }
//        return count >= n;

        // ****************************** 参考解法：很简洁 *********************************
//        int i = 0, count = 0;
//        while (i < flowerbed.length) {
//            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
//                flowerbed[i] = 1;
//                count++;
//            }
//            i++;
//        }
//        return count >= n;

        // ****************************** 参考解法：提前返回 *********************************
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if (count >= n)     // 满足要求，提前返回
                return true;
            i++;
        }
        return false;
    }
}

public class _0605_canPlaceFlowers {
    public static void main(String[] args) {
//        int[] flowerbed = {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0};
        int[] flowerbed = {0};
        Solution_0605 solution = new Solution_0605();
        boolean ans = solution.canPlaceFlowers(flowerbed, 1);
        System.out.println(ans);
    }
}
