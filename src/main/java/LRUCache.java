import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K,V> {
    private final int capacity;
    private final Deque<K> queue;
    private final Map<K, V> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.map = new HashMap<K, V>();
    }

    public V get(K val) {
        if (map.containsKey(val)) {
            V result = map.get(val);
            queue.remove(val);
            queue.addFirst(val);
            return result;
        } else {
            return null;
        }
    }

    public void put(K key, V value) {
        //if the key exist in the map, just update it.
        if (get(key) != null) {
            //update it
            map.put(key, value);
        } else {
            if (queue.size() == capacity) {
                //remove the least recently used
                K last = queue.removeLast();
                map.remove(last);
            }
            map.put(key, value);
            queue.addFirst(key);
        }
    }

    public void deleteKey(K key) {
        if (map.containsKey(key)) {
            map.remove(key);
            queue.remove(key);
        }
    }

}
