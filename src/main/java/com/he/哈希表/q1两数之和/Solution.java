package com.he.哈希表.q1两数之和;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,8,9};
        int target = 5;
        int[] ints = twoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //如果这里不同i+1，那么需要判断 i == j的情况
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    /*if(i == j){
                        continue;
                    }*/
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

}
