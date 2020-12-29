package com.he.堆栈and队列.包含min函数的栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    Stack<Integer> A,B;
    Deque deque = new LinkedList();
    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();

    }

    public void push(int x) {
        A.add(x);
        if(B.isEmpty() || B.peek() >= x){
            B.add(x);
        }
    }

    public void pop() {
        if( A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-3);
        minStack.push(2);
        minStack.push(0);
        minStack.push(-4);
        System.out.println(minStack.min());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());
        System.out.println(minStack.top());
    }
}
