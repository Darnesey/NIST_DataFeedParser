
package xmlparser;
import java.util.HashMap;

/**
 *
 * @author Ryan Darnell
 */
public class NodeDB {
    
    public HashMap<String, NodeBucket> buckets = new HashMap<>();
    //public ArrayList<NodeBucket> buckets = new ArrayList<>();
    
    public NodeDB() {}
    
    public void addBucket(NodeBucket bucket) {
        buckets.put(bucket.name, bucket);
    }
    
    public NodeBucket getBucket(String i) {
        return buckets.get(i);
    }
    
    public boolean exists(String s) {
        return buckets.containsKey(s);
    }
    
    public int size() { return buckets.size(); }
    
    @Override
    public String toString() {
        String result = "";
        for (NodeBucket bucket : buckets.values()) {
            result += bucket.toString() + "\n";
        }
        return result;
    }

}
