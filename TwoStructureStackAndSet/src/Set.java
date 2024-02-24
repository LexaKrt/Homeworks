public class Set<T> implements InterfaceForSet<T>{

    private final int CAPACITY;
    private T[] array;
    private int size;
    public Set(T[] array, int size) {
        this.array = array;
        this.size = size;
        this.CAPACITY = array.length;
    }
    @Override
    public void add(T value) throws EmptyElementException, ArrayOverflowException {
        if (value == null) throw new EmptyElementException("Given a void value");
        if (size - 1 == CAPACITY) throw new ArrayOverflowException("Array is full");
        if (contains(value)) {
            System.out.println("This element value is already set!");
        } else {
            array[size++] = value; // index starts with zero
        }
    }

    @Override
    public T[] asList() {
        return array;
    }

    @Override
    public void delete(T value) {
        boolean done = false;
        for (int j = 0; j < size && !done; j++) {
            if (array[j].equals(value)) {
                done = true;
                for (int i = j; i < size; i++) {
                    if (i == CAPACITY - 1) {
                        array[i] = null;
                    } else {
                        array[i] = array[i + 1];
                    }
                }
                array[size - 1] = null;
                size--;
            }
        }
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
}
