package com.he.二分查找.q33搜索旋转排序数组;

public class Solution2 {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int search = search(nums, target);
        System.out.println(search);
    }

    // 二分查找
    private static int search(int[] nums, int target) {
        int left =0,right = nums.length -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            // 如果num[mid] < nums[right] 右侧有序  如果 num[mid] > nums[left] 左侧有序
            // 同理可以用 如果中间点大于最左边，那么0-mid 是有序的，否则 mid +1 至right 是有序的
            else if(nums[mid] < nums[right]){
                // 在右侧有序区间内 二分查找
                if(target > nums[mid] && nums[right] > nums[mid]){
                    left = mid + 1;
                }else {
                    right = mid -1;
                }

            }else if(nums[mid] > nums[left] ){
                // 左侧有序区间内  二分查找
                if(nums[left] < target && target < nums[mid]){
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
