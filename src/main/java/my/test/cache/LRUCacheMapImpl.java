package my.test.cache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheMapImpl<K, V> extends AbstractCacheMap<K, V> {
    public LRUCacheMapImpl(int cacheSize, long defaultExpire) {
        super(cacheSize, defaultExpire);
        this.cacheMap = new LinkedHashMap<K, CacheObject<K, V>>(cacheSize + 1, 1f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, CacheObject<K, V>> eldest) {
                return LRUCacheMapImpl.this.removeEledestEntry(eldest);

            }
        };
    }

    private boolean removeEledestEntry(Map.Entry<K, CacheObject<K, V>> eldest) {
        if (super.cacheSize == 0) {
            return false;
        }
        return size() > cacheSize;

    }
    protected int eliminateCache() {
        if (!isNeedClearExpiredObj()) {
            return 0;
        }
        Iterator<CacheObject<K, V>> iterator = cacheMap.values().iterator();
        int count = 0;
        while (iterator.hasNext()) {
            CacheObject<K, V> co = iterator.next();
            if (co.isExpired()) {
                iterator.remove();
                count ++;
            }
        }
        return count;
    }
}
