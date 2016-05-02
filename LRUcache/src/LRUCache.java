/**
 * Created by jean on 4/13/16.
 */
public class LRUCache {

    private int capacity;
    private Map<Integer, Node> data;
    private Node head;
    private Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.data = new HashMap<>();
    }


}
