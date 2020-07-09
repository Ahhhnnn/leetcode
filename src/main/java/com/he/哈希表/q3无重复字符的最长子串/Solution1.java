package com.he.哈希表.q3无重复字符的最长子串;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution1 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
    // 队列先进先出，如果队列有相同元素，则移除队列
    private static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Deque<Character> deque = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            while (deque.contains(c)){
                deque.poll();
            }
            deque.addLast(c);
            max = deque.size() > max ? deque.size():max;
        }
        return max;
    }

}
