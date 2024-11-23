package lru;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author dzq
 * @Date 2024/11/23 10:05
 * @Description
 */
public class LRUCacheTest {
    @Test
    public void testPutAndGet() {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);

        assertEquals(10, cache.get(1));
        assertEquals(20, cache.get(2));
        assertEquals(30, cache.get(3));
    }

    @Test
    public void testCapacityExceeded() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);

        assertEquals(-1, cache.get(1));
        assertEquals(20, cache.get(2));
        assertEquals(30, cache.get(3));
    }

    @Test
    public void testMoveNodeToHead() {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);

        cache.get(2);

        assertEquals(20, cache.top());
    }

    @Test
    public void testEmptyCache() {
        LRUCache cache = new LRUCache(3);

        assertEquals(-1, cache.top());
    }
}
