

/**
 * Внутренняя структура - связный список
 */
public class List304ImplAsLinkedList<T> implements List304<T> {

    Node<T> first;

    Node<T> last;

    private int size = 0;

    @Override
    public void add(T e) throws EmptyElementException {
        if (e == null) throw new EmptyElementException();

        Node<T> newLast = new Node<>(last, null, e, 0);

        last = newLast;
        if (first == null) {
            first = newLast;
            size = 1;
        } else {
            last.setIndex(last.previous.index + 1);
            last.previous.setNext(last);
            size++;
        }
    }
    @Override
    public T get(int index) throws IndexOutOfBoundsException{
        if (size - 1 < index || index < 0) throw new IndexOutOfBoundsException();
        Node<T> curElem = getElementByIndex(index);
        return (T) curElem.getValue();
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException{
        Node<T> element = getElementByIndex(index);

        if (size - 1 == index) {
            element.previous.setNext(null);
            last = element.previous;
        } else if (index == 0) {
            element.next.setPrevious(null);
            first = element.next;
        } else if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            element.previous.setNext(element.next);
            element.next.setPrevious(element.previous);
        }
        size--;

        for (int i = index + 1; i < size; i++) {
            element = element.next;
            element.setIndex(element.getIndex() - 1);
        }
    }
    @Override
    public T pop(int index) {
        Node<T> element = getElementByIndex(index);
        delete(index);
        return (T) element.getValue();
    }

    public Node<T> getElementByIndex(int index) {
        Node<T> curElem = first;
        for (int i = 0; i < index; i++) {
            curElem = curElem.getNext();
        }
        return curElem;
    }

    public void printList() {
        System.out.print("[");
        Node<T> currentElement = first;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(currentElement.getValue() + ", ");
            currentElement = currentElement.next;
        }

        System.out.println(currentElement.getValue() + "]");
    }

    private static class Node<T> {

        private T value;

        private int index;

        private Node<T> previous;

        private Node<T> next;

        Node(Node<T> previous, Node<T> next, T value, int index) {
            this.value = value;
            this.index = index;
            this.next = next;
            this.previous = previous;
        }

        public int getIndex() {
            return index;
        }

        public Object getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}