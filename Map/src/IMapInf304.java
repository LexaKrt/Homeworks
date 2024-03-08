import java.util.Collection;
import java.util.Set;

public interface IMapInf304<K, V> {
    V put(K key, V value);

    V get(K key);

    V remove(K key);

    boolean containsKey(K key);

    Collection<V> values();

    Set<K> keySet();
}
