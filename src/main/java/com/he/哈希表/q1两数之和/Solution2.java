package com.he.哈希表.q1两数之和;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,8,9};
        int target = 17;
        int[] ints = twoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /*
    使用一个HashMap进行遍历，算出差值，在Map中查找是否符合条件的值，如果有说明两数相加就等于目标值。
     */
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tempMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(tempMap.containsKey(temp)){
                return new int[]{tempMap.get(temp),i};
            }
            tempMap.put(nums[i],i);
        }
        return new int[]{};
    }
}
