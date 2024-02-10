package org.ps.algorithm;

import java.util.Stack;

public class QueueUsingStack {

    private final Stack<Integer> stack = new Stack<>() ;
    private final Stack<Integer> temp = new Stack<>();

    public QueueUsingStack() {

    }

    public void push(int x) {
        this.temp.push(x);
    }

    public int pop() {
        while (!this.temp.isEmpty()) {
            this.stack.push(this.temp.pop());
        }
        return this.stack.pop();
    }

    public int peek() {

            while (!this.temp.isEmpty()) {
                this.stack.push(temp.pop());
            }
        return this.stack.peek();
    }

    public boolean empty() {
        return this.temp.isEmpty() && this.stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
