/**
 * // 287. 寻找重复数
 * // 难度：中等
 * // 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * //
 * // 示例 1:
 * // 输入: [1,3,4,2,2]
 * // 输出: 2
 * //
 * // 示例 2:
 * // 输入: [3,1,3,4,2]
 * // 输出: 3
 * // 说明：
 * //
 * // 不能更改原数组（假设数组是只读的）。
 * // 只能使用额外的 O(1) 的空间。
 * // 时间复杂度小于 O(n2) 。
 * // 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */

package com.code.main._201_300;

class Solution_0287 {
    public int findDuplicate(int[] nums) {
        // 分析：按题目要求，不能对数组排序（会改变数组）。如果只重复1次，可以求和后减去n*(n+1)/2。但是本题提示可能重复不止1次。

        // 解法1: 用hashmap判断是否重复（时间不满足要求）性能12.84%
//        Set<Integer> set = new HashSet<>();
//        int ans = 0;
//        for (int num : nums) {
//            if (set.contains(num))
//                ans = num;
//            set.add(num);
//        }
//        return ans;

        // 解法2: 快慢指针，将数组看成环形链表，参考141/142。此方法时间性能最佳 (100%)
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

        // 解法3: 二分查找，cnt[i]为小于等于的整数的个数，对cnt数组进行二分查找，寻找第一个cnt[k] > num[k]的数 (58.69%)
//        int n = nums.length;
//        int l = 1, r = n - 1, ans = -1;
//        while (l <= r) {
//            int mid = (l + r) >> 1;
//            int cnt = 0;
//            for (int i = 0; i < n; ++i) {
//                if (nums[i] <= mid) {
//                    cnt++;
//                }
//            }
//            if (cnt <= mid) {
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//                ans = mid;  // 寻找第一个cnt[k] > num[k]的数即为所求
//            }
//        }
//        return ans;

        // 解法4: 位运算（参考_0287.png）,性能也比较差(12.84%)
//        int n = nums.length, ans = 0;
//        int bit_max = 31;
//        while (((n - 1) >> bit_max) == 0) {
//            bit_max -= 1;
//        }
//        for (int bit = 0; bit <= bit_max; bit++) {
//            int x = 0, y = 0;
//            for (int i = 0; i < n; i++) {
//                if ((nums[i] & (1 << bit)) != 0) {
//                    x += 1;
//                }
//                if (i >= 1 && ((i & (1 << bit)) != 0)) {
//                    y += 1;
//                }
//            }
//            if (x > y) {
//                ans |= 1 << bit;
//            }
//        }
//        return ans;
    }
}

public class _0287_findDuplicate {
    public static void main(String[] args) {
        // [1,3,4,2,2]
        int[] nums = {1, 3, 4, 2, 2};
        Solution_0287 solution = new Solution_0287();
        int ans = solution.findDuplicate(nums);
        System.out.println(ans);
    }
}
