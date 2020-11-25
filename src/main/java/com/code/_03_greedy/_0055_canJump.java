/**
 * 55. 跳跃游戏
 * 难度：中等
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */


package com.code._03_greedy;

public class _0055_canJump {
    static public boolean canJump(int[] nums) {
        int index[] = new int[nums.length];
        // 初始化每个位置能跳到的最远位置
        for (int i = 0; i < nums.length; i++) {
            index[i] = i + nums[i];
        }

        int jump = 0;   // 用jump扫描数组:代表当前跳到的位置
        int maxIndex = index[0];    // 最远能跳到的位置
        while (jump < index.length && jump <= maxIndex) {
            if (maxIndex < index[jump]) {
                maxIndex = index[jump];
            }
            jump++;
        }
        if (jump == index.length)
            return true;
        return false;
    }

    public static void main(String[] args) {
//        int nums[] = {3, 2, 1, 0, 4};
        int nums[] = {2, 3, 1, 1, 4};
        System.out.printf("canJump: %b", canJump(nums));
    }
}
