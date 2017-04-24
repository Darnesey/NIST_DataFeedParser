package xmlparser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 *
 * @author Ryan Darnell
 */
public class Reader {

    private int indent = 0;
    private final String basicIndent = " ";
    NodeDB db = new NodeDB();
    NodeBucket bucket;
    FileWriter writer;
    File file;
    
    public Reader() throws IOException{
        file = new File("OutputData2015.txt");
        writer = new FileWriter(file);
    }
    
    public void print() throws IOException {
        System.out.println(db.toString());
        writer.write(db.toString());
        writer.close();
    }
    
    public void parse(Node n) {
        int type = n.getNodeType();

        switch (type) {
            case Node.ATTRIBUTE_NODE:
                //out.print("ATTR:");
                break;

            case Node.ELEMENT_NODE:
                //out.print("ELEM:");
                //printlnCommon(n);

                if (n.getNodeName() == "vuln:cwe") {
                    NamedNodeMap atts = n.getAttributes();
                    Node id = atts.getNamedItem("id");
                    //System.out.println("Node is " + id);
                    if (id == null) break;
                    //else System.out.println("Found id");
                    if (!db.exists(id.getNodeValue())) {
                        bucket = new NodeBucket(id.getNodeValue());
                        bucket.add(id.getParentNode());
                        db.addBucket(bucket);
                    } else {
                        db.getBucket(id.getNodeValue()).add(id.getParentNode());
                    }
                }
                

            case Node.TEXT_NODE:
//                if (n.getNodeValue().trim().length() != 0) {
//                    out.print("TEXT:");
//                    printlnCommon(n);
//                }
                break;

            default:
                // do nothing
                break;
        }
        for (Node child = n.getFirstChild(); child != null;
                child = child.getNextSibling()) {
            parse(child);
        }
    }
}
