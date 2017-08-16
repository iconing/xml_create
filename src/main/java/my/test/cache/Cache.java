package my.test.cache;

public interface Cache<K, V> {
    int size();

    long getDefaultExpire();

    void put(K key, V value);

    void put(K key, V value, long expire);

    V get(K key);

    int iliminate();

    boolean isFull();

    void remove(K key);

    void clear();

    int getCacheSize();

    boolean isEmpty();
}
