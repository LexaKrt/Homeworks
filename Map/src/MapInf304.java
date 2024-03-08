import java.util.*;

public class MapInf304<K, V> implements IMapInf304<K, V>{

    List<Node<K, V>> list = new LinkedList<>();

    @Override
    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        V returningValue = null;

        if (!containsKey(key)) {
            list.add(new Node<>(key, value));
            return null;
        }
        for (Node node : list) {
            if (node.key.equals(key)) {
                returningValue = (V) node.getValue();
                node.setValue(value);
                break;
            }
        }
        return returningValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) {
        if (!containsKey(key)) {
            System.out.println("Map doesn't include such key!");
            return null;
        }
        for (Node node : list) {
            if (node.key.equals(key)) {
                return (V) node.getValue();
            }
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V remove(K key) {
        V returningValue = null;

        if (!containsKey(key)) {
            System.out.println("Map doesn't include such key!");
            return null;
        }
        for (Node node : list) {
            if (node.key.equals(key)) {
                returningValue = (V) node.getValue();
            }
        }
        return returningValue;
    }

    @Override
    public boolean containsKey(K key) {
        for (Node node : list) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<V> values() {
        ArrayList<V> array = new ArrayList<>();
        for (Node node : list) {
            array.add((V) node.getValue());
        }
        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Node node : list) {
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

    private class Node<K, V> {
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
