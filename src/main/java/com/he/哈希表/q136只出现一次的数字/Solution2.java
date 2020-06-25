package com.he.哈希表.q136只出现一次的数字;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {4,1,15,2,1,2,4,5,5};
        int i = singleNumber(nums);
        System.out.println(i);
    }

    /*
    思路：
    使用位运算。对于这道题，可使用异或运算 ⊕。异或运算有以下三个性质。
    1、任何数和 00 做异或运算，结果仍然是原来的数，即 a⊕0=a。
    2、任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
    3、异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
    任何数与自己异或操作都等于0，因此将所有的数字依次进行异或操作，最后只出现一次的数字与0进行异或，返回的仍然是自己
     */
    private static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single^=num;
        }
        return single;
    }
}
