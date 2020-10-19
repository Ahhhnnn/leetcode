package com.he.剑指offer.q204计数质数;

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        int n = 10;
        for (int i = 2; i < n; i++)
            if (isPrime(i)) count++;
        System.out.println(count);
    }

    // 判断整数 n 是否是素数
    public static boolean isPrime(int n) {
        // for (int i = 2; i < n; i++)
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                // 有其他整除因子
                return false;
        return true;
    }
}
