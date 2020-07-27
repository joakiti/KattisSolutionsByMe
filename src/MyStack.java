import java.util.Stack;

class MyQueue {

    Stack<Integer> stackFront;
    Stack<Integer> stackBehind;
    int elements;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackFront = new Stack<>();
        stackBehind = new Stack<>();
        elements = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackFront.push(x);
        elements++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackBehind.isEmpty()) {
            for (Integer i : stackFront) {
                stackBehind.push(stackFront.pop());
            }
        }
        elements--;
        return stackBehind.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stackBehind.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return elements == 0;
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