package com.he.哈希表.q739每日温度;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(T);
        //预期结果 [1, 1, 4, 2, 1, 1, 0, 0]
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            /*for (int j = i+1; j < T.length; j++) {
                if(T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }*/
            int j = i+1;
            while (j < T.length && T[i] > T[j]){
                j++;
            }
            result [i] = j<T.length && T[j]>T[i]? j-i : 0;
        }
        return result;
    }
}
