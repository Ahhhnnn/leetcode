package com.he.堆栈and队列.q232用栈实现队列;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {

    }
    class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inStack.push(x);
        }

        private void transfer() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (outStack.isEmpty()) {
                transfer();
            }
            return outStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (outStack.isEmpty()) {
                transfer();
            }
            return outStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

}
