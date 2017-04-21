
package xmlparser;

import java.util.ArrayList;
import org.w3c.dom.Node;

/**
 *
 * @author Ryan Darnell
 */
public class NodeBucket {

    String name;
    ArrayList<Node> storage = new ArrayList<>();
    
    public NodeBucket(String name) {
        this.name = name;
    }
    
    public void add(Node n) {
        //System.out.println("Added 1 to " + name);
        storage.add(n);
    }
    
    public Node getTopNode() {
        return storage.get(0);
    }
    
    public Node getNode(int i) {
        return storage.get(i);
    }
    
    public boolean contains(Node n) {
        return storage.contains(n);
    }
    
    public int size() { return storage.size(); }

    @Override
    public String toString() {
        return "NodeBucket{" + "name=" + name + ", storage size=" + storage.size() + '}';
    }
    
    
    
}
