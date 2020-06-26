package com.he.哈希表.q739每日温度;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(T);
        //预期结果 [1, 1, 4, 2, 1, 1, 0, 0]
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    /*
    采用单调栈实现
    解析：https://leetcode-cn.com/problems/daily-temperatures/solution/mei-ri-wen-du-by-leetcode-solution/
     */
    private static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < T.length ; i++) {
            //如果当前温度，大于栈顶元素对应的温度（一直循环，有可能也大于栈中之前下标对应的问题）
            while (!stack.isEmpty() && T[i]> T[stack.peek()]){
                //栈顶的元素
                Integer pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);
        }
        return result;
    }
}
