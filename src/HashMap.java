import java.util.Arrays;
import java.util.LinkedList;

public class HashMap {
    private  static  final int SIZE_OF_TABLE = 16;
    private int size;
    private LinkedList[] table;

    public HashMap() {
        this.size = 0;
        this.table = new LinkedList[SIZE_OF_TABLE];
    }

    public static class Entry {
        private Object key;
        private Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            boolean result;
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()){
                return false;
            }

            Entry entry = (Entry) o;
            if(key != null){
                result = key.equals(entry.key);
            } else {
                result = entry.key == null;
            }
            if(value != null){
                result = value.equals(entry.value);
            } else {
                result = entry.value != null;
            }

            return result;
        }

        @Override
        public int hashCode() {
            int hashcode;
            if(key != null){
                hashcode = key.hashCode();
            } else{
                hashcode = 0;
            }
            return hashcode;
        }


    }
    public Object put(Object key, Object value){
        Object result = null;
        if( key != null){
            if(size > SIZE_OF_TABLE){
                this.resize();
                this.put(key, value);
            }
            Entry entry = new Entry(key, value);
            int index = Math.abs(key.hashCode())% SIZE_OF_TABLE;
            LinkedList list = table[index];
            if(list == null){
                list = new LinkedList();
            }
            if(list.contains(key) == false){
                list.add(entry);
                size++;
            } else {
                int tempIndex = list.indexOf(key);
                result = list.get(tempIndex);
                list.set(tempIndex, entry);
            }
            table[index] = list;
        }
        return result;

    }
    public Object get(Object key){
        Entry entry;
        int index = Math.abs(key.hashCode())% SIZE_OF_TABLE;
        LinkedList list= table[index];
        if(list == null) {
            return null;
        }
        for(Object o : list){
            entry = (Entry)o;
            if(entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }



    private void resize() {
        LinkedList[] newTable = new LinkedList[SIZE_OF_TABLE*2];
        transfer(newTable);
        table = newTable;
    }

    private void transfer(LinkedList[] newTable) {
        Object entry;
        for (LinkedList list : table) {
            for (int i = 0; i < size ; i++) {
                entry = list.get(i);
                //TODO:пересчитать хеш-код для каждого значения в хеш-таблице
            }
        }

    }


    @Override
    public String toString() {
        return "HashMap{" +
                "size=" + size +
                ", table=" + Arrays.toString(table) +
                '}';
    }
}
