interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
}

class myQueue<T> implements Queue<T> {
    private T[] array;
    private int front;
    private int rear;
    private int size;
    
    public myQueue(int capacity) {
        array = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    @Override
    public void enqueue(T item) {
        if (size == array.length) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % array.length;
        array[rear] = item;
        size++;
    }
    
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = array[front];
        front = (front + 1) % array.length;
        size--;
        return item;
    }
    
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[front];
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public int size() {
        return size;
    }
}

public class QueueEx {
    public static void main(String[] args) {
        Queue<Integer> queue = new myQueue<>(10);
        
        queue.enqueue(10);
        queue.enqueue(40);
        queue.enqueue(90);
        queue.enqueue(20);
        queue.enqueue(70);
        System.out.println("Dequeued Element: " + queue.dequeue());
        System.out.println("Peeked Element: " + queue.peek());       
        System.out.println("Queue size: " + queue.size());        
    }
}
