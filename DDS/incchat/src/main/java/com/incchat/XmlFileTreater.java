package com.incchat;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


@Component

public class XmlFileTreater {
    
    public void xmlParser(String fileName) throws ParserConfigurationException, SAXException, IOException{
        File file = new File(fileName);  
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        System.out.println("Root element: " + document.getDocumentElement().getNodeName());  
    }
}
