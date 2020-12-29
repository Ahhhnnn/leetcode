package com.he.哈希表.q39数组中出现次数超过一半的数字;

import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int n = nums.length / 2;
        for (int num : nums) {
            hash.put(num,hash.getOrDefault(num,0)+1);
            if(hash.get(num) > n){
                return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(solution.majorityElement(nums));
    }
}
