public class Stack<T> implements InterfaceForStack<T> {
    private int size = 0;

    Node<T> top;
    @Override
    public T pop() {
        Node<T> tempNode = top;

        top = top.previous;
        size--;

        return (T) tempNode.value;
    }

    @Override
    public void push(T instance) throws EmptyElementException {
        if (instance == null) throw new EmptyElementException("Given a null element");
        top = new Node<>(top, instance);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<T> {
        private final Node<T> previous;
        private final T value;
        Node (Node<T> previous, T value) {
            this.previous = previous;
            this.value = value;
        }
    }
}
