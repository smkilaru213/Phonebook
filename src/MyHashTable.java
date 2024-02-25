
public class MyHashTable<K, V> {

    private Object[] array;
    private int size;
    
    public MyHashTable() {
        array = new Object[11];
        size = 0;
    }

    public MyHashTable(int capacity) {
        array = new Object[capacity];
        size = 0;
    }

    @SuppressWarnings("unchecked")
	public V put(K key, V value) {
        int hash = Math.abs(key.hashCode() % array.length);
        Entry entry = (Entry) array[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
            entry = entry.next;
        }
        Entry newEntry = new Entry(key, value);
        newEntry.next = (Entry) array[hash];
        array[hash] = newEntry;
        size++;
        return null;
    }
    
    @SuppressWarnings("unchecked")
	public V get(K key) {
        int hash = Math.abs(key.hashCode() % array.length);
        Entry entry = (Entry) array[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
	public V remove(K key) {
        int hash = Math.abs(key.hashCode() % array.length);
        Entry prev = null;
        Entry entry = (Entry) array[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                if (prev == null) {
                    array[hash] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return entry.value;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }

    public int size() {
        return size;
    }
    
    private class Entry {
        public K key;
        public V value;
        public Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return this.key + " " + this.value;
        }
    }
}