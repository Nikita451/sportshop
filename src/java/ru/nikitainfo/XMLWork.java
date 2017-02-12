package ru.nikitainfo;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author Никита
 */
public class XMLWork {

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db;
    Document doc;
    private File f;
    public XMLWork(File buffer) {
        this.f = buffer;
    }
    
    public void beginWork() throws IOException
    {
        
        try {
            db =  dbf.newDocumentBuilder();
            doc =  db.parse(f);
            doc.normalizeDocument();
           doc.normalize();
                      
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLWork.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLWork.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLWork.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void addNewElement(String name,String text) throws XPathExpressionException
    {
            Element mes_el = doc.createElement("message");
            
            
            int i = generateIntId();
            mes_el.setAttribute("id", String.valueOf(i));
            
            Element name_el = doc.createElement("name");
            Element text_el = doc.createElement("text");
            
            Text name_text =  doc.createTextNode(name);
            Text text_text = doc.createTextNode(text);
            
            name_el.appendChild(name_text);
            text_el.appendChild(text_text);
            mes_el.appendChild(name_el);
            mes_el.appendChild(text_el);
            
            Element messages =  doc.getDocumentElement();
            messages.insertBefore(mes_el, messages.getFirstChild());
    }
    
       public int generateIntId() throws XPathExpressionException
    {
        int da = 0;
        XPathFactory xPathF = XPathFactory.newInstance();
        XPath xPath = xPathF.newXPath();
        XPathExpression xPathExp = xPath.compile("//message");
        NodeList nodeList = (NodeList) xPathExp.evaluate(doc, XPathConstants.NODESET);
        Node node = nodeList.item(0);
        Element el = (Element) node;
        String myattr =  el.getAttribute("id");
        da = Integer.valueOf(myattr) + 1;
        return da;
    }
    
    public int countOfMessage() throws XPathExpressionException
    {
        int countMessage = 0;
        
        XPathFactory xPathF = XPathFactory.newInstance();
        XPath xPath = xPathF.newXPath();
        XPathExpression xPathExp = xPath.compile("//message");
        NodeList nodeList = (NodeList) xPathExp.evaluate(doc, XPathConstants.NODESET);
        countMessage = nodeList.getLength();
        return countMessage;
    }
    
    public void deleteMessageById(String id) throws XPathExpressionException
    {
        XPathFactory xPathF = XPathFactory.newInstance();
        XPath xPath = xPathF.newXPath();
        XPathExpression xPathExp = xPath.compile("//message[@id='" + id  +"']");
        NodeList nodeList = (NodeList) xPathExp.evaluate(doc, XPathConstants.NODESET);
        Node node = nodeList.item(0);
        doc.getDocumentElement().removeChild(node);
    }
    
    
    public void saveChangeInXml()
    {
        try {
            DOMSource source = new DOMSource(doc);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult(f);
           
            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XMLWork.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLWork.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
}
