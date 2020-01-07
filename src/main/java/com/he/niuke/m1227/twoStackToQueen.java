package com.he.niuke.m1227;

import java.util.Stack;

public class twoStackToQueen {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.size()==0){
            while(stack1.size()>0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        twoStackToQueen queen = new twoStackToQueen();
        queen.push(2);
        queen.push(3);
        queen.push(7);
        System.out.println(queen.pop());
    }
}
