Public Methods:

MyHashTable(): Default constructor with default size 11.
MyHashTable(int M): Constructor that creates an instance of the hash table with the specified size.
void put(K key, V value): Adding elements to the hash table.
V get(K key):  Getting element from hashTable by key
V remove(K key): Removes the key-value from the hash table.
boolean contains(V value): Returns true if the hash table contains the specified value, otherwise false.
K getKey(V value): Getting key by value.
int[] getSizeOfBucket(): Returns an array of integers representing the number of elements in each bucket of the hash table.

Private Methods:

int hash(K key): Computes and returns the hash code for the specified key.
class HashNode: Represents a node in the hash table that holds a key-value pair and a reference to the next node in the chain.


