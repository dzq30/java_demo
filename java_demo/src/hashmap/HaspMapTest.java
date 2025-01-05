package hashmap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dzq
 * @Date 2025/1/5 16:30
 * @Description
 */

public class HaspMapTest {

    @Test
    public void testPutAndGet() {
        HaspMap<String, Integer> map = new HaspMap<>();
        map.put("key1", 1);
        map.put("key2", 2);

        assertEquals(1, map.get("key1"));
        assertEquals(2, map.get("key2"));
    }

    @Test
    public void testResize() {
        HaspMap<String, Integer> map = new HaspMap<>(2, 0.5);
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        assertEquals(3, map.size());
        assertEquals(8, map.capacity());
    }

    @Test
    public void testRemove() {
        HaspMap<String, Integer> map = new HaspMap<>();
        map.put("key1", 1);
        map.put("key2", 2);

        map.remove("key1");

        assertNull(map.get("key1"));
        assertEquals(1, map.size());
    }

    @Test
    public void testContainsKey() {
        HaspMap<String, Integer> map = new HaspMap<>();
        map.put("key1", 1);

        assertTrue(map.containsKey("key1"));
        assertFalse(map.containsKey("key2"));
    }
}
