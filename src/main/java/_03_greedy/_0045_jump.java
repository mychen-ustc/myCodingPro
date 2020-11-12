/**
 * 45. 跳跃游戏 II
 * 难度：困难
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路：
 * 1.noJumpMaxIndex 如果不增加1次跳跃，能到达的最远的地方
 * 2.jumpMaxIndex 已遍历的位置中，通过增加跳跃能达到的最远的地方
 * 3.jump_min 记录最少跳跃次数
 * 4.用i遍历 nums 数组，如果 i > noJumpMaxIndex，则 jump_min 加 1，noJumpMaxIndex = jumpMaxIndex
 * 5.如果遍历的过程中，nums[i]+i更大，则更新 jumpMaxIndex = nums[i] + i
 */

package _03_greedy;

public class _0045_jump {
    static public int jump(int[] nums) {
        if (nums.length < 2) return 0;  // 少于2步，不需要跳跃
        int noJumpMaxIndex = 0;  // 如果不增加1次跳跃，能到达的最远的地方
        int jumpMaxIndex = nums[0];  // 已遍历的位置中，通过增加跳跃能达到的最远的地方
        int minJump = 0;    // 最小跳跃次数
        for (int i = 1; i < nums.length; i++) {
            if (noJumpMaxIndex < i) {   // 如果不多跳跃1次到不了当前位置，就增加1次跳跃
                minJump++;
                noJumpMaxIndex = jumpMaxIndex;
            }
            if (jumpMaxIndex < nums[i] + i) {   // 更新增加1次跳跃所能到达的最远位置
                jumpMaxIndex = nums[i] + i;
            }
        }

        return minJump;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        System.out.printf("jump: %d", jump(nums));
    }
}
