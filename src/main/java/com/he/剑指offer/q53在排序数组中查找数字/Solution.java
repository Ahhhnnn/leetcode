package com.he.剑指offer.q53在排序数组中查找数字;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int search = search(nums, target);
        System.out.println(search);
    }

    private static int search(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if(num == target){
                count ++;
            }
        }
        return count;
    }
    // 两次二分，查找target的左右边界
    private static int search2(int[] nums, int target) {
        int count = 0;

        return count;
    }

}
