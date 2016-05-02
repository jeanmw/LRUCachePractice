import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jean on 4/29/16.
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int size;

    private LRUCache(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }

    public static <K, V> LRUCache<K, V> newInstance(int size) {
        return new LRUCache<K, V>(size);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }

    public static void main(String[] args) {

        LRUCache<String, String> lrucache = LRUCache.newInstance(2);
        lrucache.put("1", "1");
        lrucache.put("2", "2");
        lrucache.put("3", "3");

        System.out.println(lrucache);
    }

}
