package com.he.堆栈and队列.q40最小的k个数;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        int [] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.offer(i);
        }
        System.out.println(queue);
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5,2,4,1};
        int k =2;
        System.out.println(Arrays.toString(solution.getLeastNumbers(arr, k)));
    }
}
