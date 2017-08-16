package my.test.test;

import my.test.cache.LRUCacheMapImpl;

public class CacheTest {
    public static void main(String[] args) throws InterruptedException {
        LRUCacheMapImpl<String, String> cacheMap= new LRUCacheMapImpl<String, String>(3, 0);
        cacheMap.put("aaa", "111111111");
        cacheMap.put("bbb", "222222222");
        cacheMap.put("ddd", "333333333");
        cacheMap.put("eee", "444444444");

        System.out.println("bbb" + cacheMap.get("bbb"));
        System.out.println("bbb" + cacheMap.get("bbb"));
        System.out.println("eee" + cacheMap.get("eee"));
    }
}
