package com.he.剑指offer.q50第一个只出现一次的字符;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        String s = "abbaccdeff";
        char c = firstUniqChar(s);
        System.out.println(c);
    }

    private static char firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<Character, Boolean>();
        for (char c : s.toCharArray()) {
            map.put(c,map.containsKey(c));
        }
        for (char c : s.toCharArray()) {
            if(!map.get(c)){
                return c;
            }
        }
        return ' ';
    }
}
