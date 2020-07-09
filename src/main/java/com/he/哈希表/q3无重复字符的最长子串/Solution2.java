package com.he.哈希表.q3无重复字符的最长子串;


import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {
        String s = "abceabcbbcdefg";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    //双指针
    private static int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j=0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
                //移动 j 指针的位置
                j = j > map.get(chars[i]) +1 ? j : map.get(chars[i]) +1;
            }
            map.put(chars[i],i);
            max = max > i-j +1 ? max:i-j +1;
        }
        return max;
    }
}
