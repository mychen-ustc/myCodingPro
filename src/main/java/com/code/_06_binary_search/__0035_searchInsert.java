package com.code._06_binary_search;

class Solution_0035 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;  // 左右指针
        int index = -1;
        while (index == -1) {
            int mid = (left + right) / 2;   // 中间指针
            if (nums[mid] == target) {
                index = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
                if (mid == 0 || nums[mid - 1] < target)
                    index = mid;
            } else {
                left = mid + 1;
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    index = mid + 1;
                }
            }
        }
        return index;
    }
}

public class __0035_searchInsert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 1;
        Solution_0035 solution = new Solution_0035();
        int res = solution.searchInsert(nums, target);
        System.out.println(res);
    }
}
