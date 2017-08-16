package my.test.cache;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class AbstractCacheMap<K, V> implements Cache<K, V> {
    /**
     * 内部类。
     * @param <K2>
     * @param <V2>
     */
    class CacheObject<K2, V2> {
        final K2 key;
        final V2 cacheObject;
        long lastAccess;
        long accessCount;
        long ttl;

        CacheObject(K2 key, V2 value, long ttl) {
            this.key = key;
            this.cacheObject = value;
            this.ttl = ttl;
        }

        boolean isExpired() {
            if (ttl == 0) {
                return false;
            }
            return lastAccess + ttl > System.currentTimeMillis();
        }

        V2 getObject() {
            this.lastAccess = System.currentTimeMillis();
            accessCount++;
            return cacheObject;
        }
    }


    protected Map<K, CacheObject<K, V>> cacheMap;
    protected int cacheSize; //0 -> 无限制
    private long defaultExpire;
    private boolean existCustomExpire;
    private final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();

    private final Lock readLock = cacheLock.readLock();
    private final Lock writeLock = cacheLock.writeLock();

    public AbstractCacheMap(int cacheSize, long defaultExpire) {
        this.cacheSize = cacheSize;
        this.defaultExpire = defaultExpire;
    }

    protected boolean isNeedClearExpiredObj() {
        return defaultExpire > 0 || existCustomExpire;
    }
    public int size() {
        return cacheMap.size();
    }

    public long getDefaultExpire() {
        return defaultExpire;
    }

    public void put(K key, V value) {
        put(key, value, defaultExpire);
    }

    public void put(K key, V value, long expire) {
        writeLock.lock();
        try {
            CacheObject<K, V> cacheObject = new CacheObject<K, V>(key, value, expire);
            if (expire > 0) {
                existCustomExpire = true;
            }
            if (isFull()) {
                iliminate();
            }
            cacheMap.put(key, cacheObject);
        } finally {
            writeLock.unlock();
        }
    }

    public V get(K key) {
        readLock.lock();
        try {
            CacheObject<K, V> cacheObject = cacheMap.get(key);
            if (cacheObject == null) {
                System.out.println(key + "  'cacheObject == null");
                return null;
            }
            if (cacheObject.isExpired()) {
                cacheMap.remove(key);
                System.out.println(key + "  cacheObject is expired");
                return null;
            }
            return cacheObject.getObject();
        } finally {
            readLock.unlock();
        }
    }

    public final int iliminate() {
        writeLock.lock();
        try {
            return eliminateCache();
        } finally {
            writeLock.unlock();
        }
    }

    protected abstract int eliminateCache();

    public boolean isFull() {
        if (cacheSize == 0) {
            return false;
        }
        return cacheMap.size() >= cacheSize;
    }

    public void remove(K key) {
        writeLock.lock();
        try {
            cacheMap.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

    public void clear() {
        writeLock.lock();
        try {
            cacheMap.clear();
        } finally {
            writeLock.unlock();
        }
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
