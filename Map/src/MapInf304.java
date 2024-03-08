import java.util.*;

public class MapInf304<K, V> implements IMapInf304<K, V>{

    List<Node<K, V>> list = new LinkedList<>();

    @Override
    public V put(K key, V value) {
        V returningValue = null;

        if (!containsKey(key)) {
            list.add(new Node<>(key, value));
            return null;
        }
        for (Node<K, V> node : list) {
            if (node.key.equals(key)) {
                returningValue = (V) node.getValue();
                node.setValue(value);
                break;
            }
        }
        return returningValue;
    }

    @Override
    public V get(K key) {
        if (!containsKey(key)) {
            System.out.println("Map doesn't include such key!");
            return null;
        }
        for (Node<K, V> node : list) {
            if (node.key.equals(key)) {
                return (V) node.getValue();
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        V returningValue = null;

        if (!containsKey(key)) {
            System.out.println("Map doesn't include such key!");
            return null;
        }
        for (Node<K, V> node : list) {
            if (node.key.equals(key)) {
                returningValue = (V) node.getValue();
            }
        }
        return returningValue;
    }

    @Override
    public boolean containsKey(K key) {
        for (Node<K, V> node : list) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> array = new ArrayList<>();
        for (Node<K, V> node : list) {
            array.add((V) node.getValue());
        }
        return array;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Node<K, V> node : list) {
            set.add((K) node.getKey());
        }
        return set;
    }

    public static void main(String[] args) {
        MapInf304<String, Integer> map = new MapInf304<>();

        map.put("Lexa", 5);
        map.put("Artem", 8);
        map.put("Dima", 6);

        System.out.println(map.get("Lexa") + "\n" + map.get("Dima"));

        map.put("Lexa", 70);

        System.out.println(map.get("Lexa"));
    }

    private class Node<Key, Val> {
        private Key key;
        private Val value;

        Node(Key key, Val value) {
            this.key = key;
            this.value = value;
        }

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public Val getValue() {
            return value;
        }

        public void setValue(Val value) {
            this.value = value;
        }
    }
}
