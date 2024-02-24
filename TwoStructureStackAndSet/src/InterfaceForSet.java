public interface InterfaceForSet<T> {
    public void add(T instance) throws EmptyElementException, ArrayOverflowException;
//  add an element
    public T[] asList();
//    return an array of elements
    public void delete(T value);
//    delete an element according its value

    public boolean contains(T value);
//     return boolean according its value
}
