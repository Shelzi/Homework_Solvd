package com.shelzi.solvdlaba.hm2_oop.daohw.parser.dom;

import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.Customer;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.User;
import com.shelzi.solvdlaba.hm2_oop.daohw.model.entity.UserRole;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomXmlUtil {
    public final void unmarshal() throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File("./book.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("customer");

        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < nList.getLength(); i++) {
            customers.add(getCustomer(nList.item(i)));
        }
        System.out.println(customers);
    }
    private Customer getCustomer(Node node) {
        Customer customer = new Customer();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) node;
            customer.setId(Integer.parseInt(getTagValue("id", elem)));
            customer.setName(getTagValue("name", elem));
            customer.setEmail(getTagValue("email", elem));
            customer.setAddress(getTagValue("address", elem));
            customer.setPassword(getTagValue("password", elem));
            customer.setUsername(getTagValue("username", elem));
            Node node1 = elem.getElementsByTagName("serviceWorker").item(0);
            User user = new User();
            if (node1.getNodeType() == Node.ELEMENT_NODE) {
                user = getUser(node1);
            }
            customer.setServiceWorker(user);
        }
        return customer;
    }

    private User getUser(Node node) {
        User user = new User();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            user.setBanned(Boolean.getBoolean(getTagValue("banned", element)));
            user.setEmail(getTagValue("email", element));
            user.setId(Integer.parseInt(getTagValue("id", element)));
            user.setName(getTagValue("name", element));
            user.setPassword(getTagValue("password", element));
            user.setRole(UserRole.valueOf(getTagValue("role", element)));
        }
        return user;
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}