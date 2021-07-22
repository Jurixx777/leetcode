class MyCircularQueue {

    final private int[] items;
    private int head; //head of queue
    private int tail; //last item
    private int count; //count of items in queue
    
    public MyCircularQueue(int k) {
        items = new int[k];
        head = 0;
        tail = -1;
        count = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        tail = (tail + 1) % items.length;
        items[tail] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        head = (head + 1) % items.length;  
        count--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : items[head];    
    }
    
    public int Rear() {
        return isEmpty() ? -1 : items[tail];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == items.length;
    }
    
    public int size() {
        return count;
    }
}
