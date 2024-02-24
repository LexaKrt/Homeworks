
/**
 Список из однотипных элементов Integer
 позиционный (каждый элемент занимает определенную позицию)
 */
public interface List304<T> {
    void add(T e) throws EmptyElementException;

    T get(int index);

    int size();

    void delete(int index);
    /** Возвращаем последний элемент, и удаляем его из списка */
    T pop(int index);
}