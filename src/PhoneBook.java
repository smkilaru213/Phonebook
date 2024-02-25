public class PhoneBook implements IMap{

    private Entry[] array;
    private int size;
    
    public PhoneBook() {
        array = new Entry[13];
        size = 0;
    }

    public PhoneBook(int capacity) {
        array = new Entry[capacity];
        size = 0;
    }

    public PhoneNumber put(Person key, PhoneNumber value) {
        int hash = Math.abs(key.hashCode() % array.length);
        Entry entry = array[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                PhoneNumber oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
            entry = entry.next;
        }
        Entry newEntry = new Entry(key, value);
        newEntry.next = array[hash];
        array[hash] = newEntry;
        size++;
        return null;
    }
    
    public PhoneNumber get(Person key) {
        int hash = Math.abs(key.hashCode() % array.length);
        Entry entry = array[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public PhoneNumber remove(Person key) {
        int hash = Math.abs(key.hashCode() % array.length);
        Entry prev = null;
        Entry entry = array[hash];
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

    public int size(){
        return size;
    }

    private class Entry {
        public Person key;
        public PhoneNumber value;
        public Entry next;

        public Entry(Person key, PhoneNumber value) {
            this.value = value;
            this.key = key;
        }

        public String toString() {
            return key + " " + value;
        }
    }
}