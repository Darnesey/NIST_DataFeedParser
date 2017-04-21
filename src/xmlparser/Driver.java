
package xmlparser;

import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;

//These classes are for the exceptions that can be thrown when the XML document is parsed:

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException; 
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.*;

//These classes read the sample XML file and manage output:

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//Finally, import the W3C definitions for a DOM, DOM exceptions, entities and nodes:

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Entity;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import static java.lang.System.out;


/**
 *
 * @author Ryan Darnell
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder(); 
        Document doc = db.parse(new File("files/nvdcve-2.0-2015.xml"));
        Reader read = new Reader();
        read.parse(doc.getFirstChild());
        read.print();
        
    }

    
}
