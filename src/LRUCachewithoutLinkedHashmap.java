import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;


public class LRUCachewithoutLinkedHashmap<Key, Value> {

    private int size;

    private ConcurrentLinkedQueue<Key> linkedQueue;
    private ConcurrentHashMap<Key, Value> hashMap;


    private LRUCachewithoutLinkedHashmap(int size) {
        this.size = size;
        this.linkedQueue = new ConcurrentLinkedQueue<Key>();
        this. hashMap = new ConcurrentHashMap<Key, Value>();
    }

    public Value get(final Key key) {
        return hashMap.get(key);
    }

    public void put(final Key key, final Value value) {
        if(hashMap.contains(key)) {
            linkedQueue.remove(key);
        }

        while(linkedQueue.size() >= size) {
            Key oldestKey = linkedQueue.poll();
            if(oldestKey != null) {
                hashMap.remove(oldestKey);
            }
        }

        linkedQueue.add(key);
        hashMap.put(key, value);
    }

    public static void main(String args[]) {

        LRUCachewithoutLinkedHashmap lrucachewithoutlinkedhashmap = new LRUCachewithoutLinkedHashmap<String, String>(3);

        lrucachewithoutlinkedhashmap.put("1", "3");
        lrucachewithoutlinkedhashmap.put("2", "2");
        lrucachewithoutlinkedhashmap.put("3", "llamasauce");
        lrucachewithoutlinkedhashmap.put("4", "blueberries");

        System.out.println("size is: " + lrucachewithoutlinkedhashmap.size);
        System.out.println(lrucachewithoutlinkedhashmap.get(""));
    }

}
