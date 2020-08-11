package com.he.剑指offer.q53缺失的数字;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0};
        int i = missingNumber2(nums);
        System.out.println(i);
    }
    private static int missingNumber(int[] nums) {
        int left = 0,right = nums.length -1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid] >mid){
                right =mid-1;
            }else if(nums[mid] == mid){
                left = mid +1;
            }
        }
        return left;
    }

    private static int missingNumber2(int[] nums){
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

}
