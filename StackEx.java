interface Stack {
    void push(int item);
    int pop();
    int peek();
    boolean isEmpty();
}

class myStack implements Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public myStack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    @Override
    public void push(int item) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = item;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stackArray[top--];
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top];
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }
}

public class StackEx {
    public static void main(String[] args) {
        Stack stack = new myStack(10);

        stack.push(85);
        stack.push(20);
        stack.push(35);
        stack.push(10);
        stack.push(40);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
