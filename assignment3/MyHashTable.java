package assignment3;

public class MyHashTable<K, V>
{

    private class HashNode<K,V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "{"+ key + " " + value + "}";
        }
    }

    private HashNode<K, V> [] chainArray;
    private int M = 11;
    private int size;
    public MyHashTable() {
        chainArray = new HashNode[M];
    }
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }
    private int hash(K key) {
        return Math.abs(key.hashCode() % M);
    }
    public void put(K key, V value) {
        int index = hash(key);
        size++;
        if (chainArray[index] == null) {
            chainArray[index] = new HashNode(key, value);
        }
        else {
            HashNode<K, V> current = chainArray[index];
            while(current.next != null){
                current = current.next;
            }
            current.next = new HashNode(key, value);
        }

    }




    public V get(K key) throws Exception {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        while (current != null && !current.key.equals(key)){
            current = current.next;
        }
        if (current == null) throw new Exception("Key not found.");
        return current.value;
    }
    public V remove(K key){
        size--;
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> previous = null;
        while (current != null && !current.key.equals(key)){
            previous = current;
            current = current.next;
        }
        if (current == null) throw new Error();
        if (previous == null) {
            this.chainArray[index] = current.next;
        }
        else{
            previous.next = current.next;
        }
        return current.value;
    }
    public boolean contains(V value) {
        for (int index = 0; index < M; index++) {
            HashNode<K, V> current = chainArray[index];
            while (current != null) {
                if (current.value.equals(value)) return true;
                current = current.next;
            }
        }
        return false;
    }
    public K getKey(V value) throws Error
        {
            for(int index = 0; index < M; index++){
                HashNode<K, V> current = chainArray[index];
                while(current != null)
                {
                    if(current.value.equals(value)) return current.key;
                    current = current.next;
                }
        }
            throw new Error();
    }
    public int[] getSizeOfBucket(){
        int[] result = new int[M];
        for(int i = 0; i < M; i++)
        {
            int length = 0;
            HashNode<K, V> current = chainArray[i];
            while(current != null){
                current = current.next;
                length++;
            }
            result[i] = length;
        }
        return result;
    }


}
