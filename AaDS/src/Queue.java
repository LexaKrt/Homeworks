public class Queue<T> {

    private final Object[] queue;

    private int size = 0;

    private int firstIndex;

    private int lastIndex;

    private final int capacity;

    Queue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
    }

    public void push(T element) throws EmptyElementException, QueueOverflowException {
        if (element == null) throw new EmptyElementException("Given null element");

        if (isEmpty()) {
            firstIndex = 0;
            lastIndex = -1;
        } else if (lastIndex + 1 == capacity & firstIndex != 0) {
            lastIndex = -1;
        } else if (lastIndex + 1 == firstIndex || lastIndex + 1 == capacity & firstIndex == 0) {
            throw new QueueOverflowException("Queue overflowed");
        }
        queue[++lastIndex] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) queue[firstIndex];
    }

    @SuppressWarnings("unchecked")
    public T pop() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        } else if (firstIndex + 1 == capacity) {
            firstIndex = -1;
        }
        size--;
        return (T) queue[firstIndex++];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) throws EmptyElementException, QueueOverflowException, EmptyQueueException {
        Queue<String> queue = new Queue<>(5);
//      Normal test
        for (int i = 0; i < 5; i++) {
            queue.push("test" + i);
        }

//      Test Empty element exception
//      queue.push(null);


/*      Test Overflow exception
        for (int i = 0; i < 6; i++) {
            queue.push("test" + i);
        }
*/

//        To test Empty queue exception comment first "for" cycle and run code

        System.out.println(queue.pop() + " " + queue.peek() + " " + queue.pop() + " " + queue.peek() + " " + queue.pop());
    }
}
