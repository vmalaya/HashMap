import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

public class HashMap<K,V> {
    private final static int CAPACITY = 16;
    private final static double DEFAULT_LOAD_FACTOR = 0.75;

    private int defaultSize;
    private int size;
    private LinkedList[] table;

    public HashMap() {
        this.size = 0;
        this.table = new LinkedList[CAPACITY];
        defaultSize = CAPACITY;
    }

    private HashMap(int defaultSize) {
        this.size = 0;
        this.table = new LinkedList[defaultSize];
        this.defaultSize = defaultSize;
    }

    public static class Entry<K,V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry entry = (Entry) o;

            if (key != null ? !key.equals(entry.key) : entry.key != null) return false;
            return value != null ? value.equals(entry.value) : entry.value == null;
        }

        @Override
        public int hashCode() {
            return key != null ? key.hashCode() : 0;
        }
    }
    public V put(K key, V value){
        if( key == null){
            throw new IllegalArgumentException("Illegal key value!");
        }
        if(this.size >= this.getThreshold()){
            this.resize();
        }
        V result = null;
        Entry entry = new Entry(key, value);
        int index = Math.abs(key.hashCode())% defaultSize;
        LinkedList list = table[index];
        if(list == null){
            list = new LinkedList();
        }
        if(list.contains(key) == false){
            list.add(entry);
            size++;
        } else {
            int tempIndex = list.indexOf(key);
             Entry tempEntry =(Entry)list.get(tempIndex);
             result = (V) tempEntry.getValue();
            list.set(tempIndex, entry);
        }
        table[index] = list;
        return result;

    }
    public V get(K key){
        if(key == null){
            throw new IllegalArgumentException("Illegal key value!");
        }
        if(defaultSize <= 0){
            throw new RuntimeException("Hashmap is empty!");
        }
        Entry entry;
        int index = Math.abs(key.hashCode()) % defaultSize;
        LinkedList list = table[index];
        if (list == null) {
            return null;
        }
        for (Object o : list) {
            entry = (Entry) o;
            if (entry.getKey().equals(key)) {
                return (V) entry.getValue();
            }
        }
        return null;
    }

    private void resize() {
        defaultSize = defaultSize*2;
        HashMap<K,V> newHashMap = new HashMap<>(defaultSize);
        transfer(newHashMap);
        table = newHashMap.getTable();
    }

    private void transfer(HashMap<K,V> newHashMap) {
        for (LinkedList list : table) {
            if(list != null)
            for (Object o : list) {
                if(o != null)
                newHashMap.put((K) ((Entry) o).key, (V) ((Entry) o).value);
            }
        }
    }

    private LinkedList[] getTable() {
        return table;
    }

    public int getThreshold() {
        int result = (int)(defaultSize * DEFAULT_LOAD_FACTOR);
        return result;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                " defaultSize= " + defaultSize +
                ", size=" + size +
                ", table=" + Arrays.toString(table) +
                '}';
    }
}
