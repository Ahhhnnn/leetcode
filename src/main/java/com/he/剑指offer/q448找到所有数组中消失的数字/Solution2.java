package com.he.剑指offer.q448找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> numbers = findDisappearedNumbers(nums);
        System.out.println(numbers);
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 得到索引
            int index = Math.abs(nums[i])-1;
            if(nums[index] >0){
                nums[index] *=-1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}
