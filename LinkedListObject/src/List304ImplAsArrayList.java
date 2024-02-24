public class List304ImplAsArrayList<T> implements List304<T> {

    private int capacity;
    private int size = 0;
    private Object[] array;

    public List304ImplAsArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }
    @Override
    public void add(T e) throws EmptyElementException {
        if (e == null) throw new EmptyElementException();
        if (size == capacity) {
            Object[] newArray = new Object[(int) (capacity * 1.5)];
            if (capacity >= 0) System.arraycopy(array, 0, newArray, 0, capacity);
            array = newArray;
            capacity *= 2;
        }
        array[size++] = e;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index > capacity) throw new IndexOutOfBoundsException();
        return (T) array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void delete(int index) {
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        array[size - 1] = null;
        size--;
    }

    @Override
    public T pop(int index) {
        T element = (T) array[index];
        delete(index);
        return element;
    }

    public Object[] getArray() {
        return array;
    }
}
