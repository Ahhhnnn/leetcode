package com.he.niuke.leetcode0212;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findMedianSortedArrays {

    public static void main(String[] args) {
        int[] num1 = {3,2,1};
        int[] num2 = {5,4};
        double result = findMedianNumber(num1,num2);
        System.out.println(result);
    }

    private static double findMedianNumber(int[] num1, int[] num2){
        int length = num1.length+num2.length;
        int[] sum=new int[length];
        for(int i =0;i<num1.length;i++){
            sum[i]=num1[i];
        }
        for(int j=num1.length;j<sum.length;j++){
            sum[j]=num2[j-num1.length];
        }
        //sum 3,2,5,4
        for(int i=0;i<sum.length;i++){
            for (int j = 0; j <sum.length-1-i ; j++) {
                if(sum[j]>sum[j+1]){
                    int temp=sum[j];
                    sum[j]=sum[j+1];
                    sum[j+1]=temp;
                }
            }
        }
        //如果为偶数
        if((sum.length)%2==0){
            int index = (sum.length/2) - 1;
            int index2 = index+1;
            return (sum[index]+sum[index2])/2.0;
        } else {
          return sum[(sum.length+1)/2 -1];
        }
    }
}
