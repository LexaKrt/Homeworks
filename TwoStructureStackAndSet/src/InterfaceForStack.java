public interface InterfaceForStack<T> {
    public T pop();

    public void push(T instance) throws EmptyElementException;
//    we put(push) an element in our stack "on the top"

    public int size();
}
