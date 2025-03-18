// to learn about the internal working of the hashmap in Java8

public class MyHashMap<K,V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    Entry[] hashTable;

    MyHashMap(){
     hashTable = new Entry[DEFAULT_CAPACITY];
    }

    MyHashMap(int capacity){
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    final int tableSizeFor(int capacity){
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n<0)?1:(n>=MAXIMUM_CAPACITY)?MAXIMUM_CAPACITY:n + 1;
    }

    static class Entry<K,V>{
        K key;
        V value;
        Entry next;

        public Entry(K key,V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public void setKey(K key){
            this.key = key;
        }
        public V getValue(){
            return value;
        }
        public void setValue(V value){
            this.value = value;
        }

    }

    public void put(K key,V value){
        int hashCode = key.hashCode()%hashTable.length;
        Entry node =  hashTable[hashCode];
        if(node == null){
            Entry newNode = new Entry(key,value);
            hashTable[hashCode] = newNode;
        } //if not null that means there exists a collision
        else{
            Entry previousNode = node;
            while(node!=null){
                if(node.getKey().equals(key)){
                    node.setValue(value);
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key,value);
            previousNode.next = newNode;
        }
    }

    public V get(K key){
        int hashCode = key.hashCode()%hashTable.length;
        Entry node = hashTable[hashCode];
        while(node!=null){
            if(node.getKey().equals(key)){
                return (V)node.value;
            }
            node = node.next;
        }
        return null;
    }

    public Entry<K,V> getEntryAtIndex(int index) {
        if (index < 0 || index >= hashTable.length) {
            return null;
        }
        return hashTable[index];
    }

    public void printAllEntriesAtIndex(int index) {
        if (index < 0 || index >= hashTable.length) {
            System.out.println("Invalid index");
            return;
        }
        
        Entry node = hashTable[index];
        if (node == null) {
            System.out.println("No entries at index " + index);
            return;
        }
        
        System.out.println("All entries at index " + index + ":");
        while (node != null) {
            System.out.println("Key: " + node.getKey() + ", Value: " + node.getValue());
            node = node.next;
        }
    }

    private int getCapacity() {
        return hashTable.length;
    }

    private int size() {
        int count = 0;
        for(int i = 0; i < hashTable.length; i++){
            Entry node = hashTable[i];
            while(node!=null){
                count++;
                node = node.next;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //HashMap<Integer,String> map = new HashMap<>();
        //MyHashMap<Integer, String> map = new MyHashMap<>(7);

        MyHashMap<Integer, String> map = new MyHashMap<>(5);
        map.put(1, "hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Deepshikha");
        map.put(6, "how");
        map.put(7, "are");
        map.put(8, "are");
        map.put(9, "you");
        map.put(10, "doing");
        map.put(11, "well");
        map.put(12, "?");
        map.put(13, "I");
        map.put(14, "am");

        // Get entry at any index
        int index = 2;
        // Print all entries at any index
        map.printAllEntriesAtIndex(index);
        Entry<Integer, String> entry = map.getEntryAtIndex(index);
        if (entry != null) {
            System.out.println("Key at index "+ index + " are: " + entry.getKey());
            System.out.println("Value at index " + index + " are: " + entry.getValue());
        } else {
            System.out.println("No entry at index " + index);
        }

        String value = map.get(14);
        int size = map.size();
        int len = map.getCapacity();
        System.out.println(value);
        System.out.println(size);
        System.out.println(len);
    }

}