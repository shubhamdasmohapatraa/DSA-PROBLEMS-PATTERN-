/*
LeetCode 155 - Min Stack

Approach:
Two Stacks (Auxiliary Stack for Minimum)

Key Idea:
- Maintain two stacks:
  1. Main stack to store all values
  2. Min stack to track the minimum value at each state
- Whenever a new value is pushed, also push it to minStack
  if it is smaller than or equal to the current minimum

Algorithm:
1. push(val):
   - Push val into the main stack
   - If minStack is empty OR val <= minStack.peek(),
     push val into minStack
2. pop():
   - Pop the top element from the main stack
   - If the popped value equals minStack.peek(),
     pop from minStack as well
3. top():
   - Return the top element of the main stack
4. getMin():
   - Return the top element of minStack (current minimum)

Time Complexity:
- push: O(1)
- pop: O(1)
- top: O(1)
- getMin: O(1)

Space Complexity: O(n)
*/

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int poppedValue = stack.pop();
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Usage:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int top = obj.top();
 * int min = obj.getMin();
 */
