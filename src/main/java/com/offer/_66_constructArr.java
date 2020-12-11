/***
 // 66. 构建乘积数组
 // 难度：中等
 // 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 //
 // 示例:
 // 输入: [1,2,3,4,5]
 // 输出: [120,60,40,30,24]
 //
 // 提示：
 // 所有元素乘积之和不会溢出 32 位整数
 // a.length <= 100000
 */

package com.offer;

class Solution_66 {
    public int[] constructArr(int[] a) {
        // 解读：B[i]中的因子不包含A[i],不用考虑溢出
        // 设想有一个表格，可以分为下三角和上三角，对角线为1（对应A[i]），分别计算两部分的乘积
        int len = a.length;
        if (len == 0) return new int[0];   // 空数组
        int[] b = new int[len];
        b[0] = 1;
        // 先计算下三角乘积 从b[1]递推到b[n-1]
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];     // 将前一项乘以a[i-1]即可
        }
        // 计算上三角的乘积，从b[n-2]递推到b[0]
        // 用tmp记录从b[n-1]到b[1]的乘积
        int tmp = 1;
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}

public class _66_constructArr {
    public static void main(String[] args) {
        // [1, 2, 3, 4, 5]
        int[] nums = {1, 2, 3, 4, 5};
        Solution_66 solution = new Solution_66();
        int[] ans = solution.constructArr(nums);
        for (int num : ans)
            System.out.println(num);
    }
}
