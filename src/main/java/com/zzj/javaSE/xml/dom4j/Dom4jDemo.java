package com.zzj.javaSE.xml.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.zzj.javaSE.xml.dom.Xmldocument;

/**
 * DOM4J 是一个非常非常优秀的Java XML API，具有性能优异、功能强大和极端易用使用的特点，
 * 同时它也是一个开放源代码的软件。
 * 如今你可以看到越来越多的 Java 软件都在使用 DOM4J 来读写 XML，
 * 特别值得一提的是连 Sun 的JAXM 也在用 DOM4J。
 * （1）Dom4j解析XML文档所使用到的jar包：dom4j.jar
 */

public class Dom4jDemo implements Xmldocument {  
	  
    // Dom4j创建Xml文档  
    public void createXml(String fileName) {  
        Document document = DocumentHelper.createDocument(); // 创建一个文档对象  
        Element employees = document.addElement("employees"); // 在根节点添加元素  
        Element employee = employees.addElement("employee"); // 在employees下添加子节点  
        Element name = employee.addElement("name"); // 在employee下添加子节点  
        name.setText("ddvip"); // 给name节点添加内容  
        Element sex = employee.addElement("sex");  
        sex.setText("m");  
        Element age = employee.addElement("age");  
        age.setText("29");  
        try {  
            Writer fileWriter = new FileWriter(fileName);  
            XMLWriter xmlWriter = new XMLWriter(fileWriter);  
            xmlWriter.write(document);  
            xmlWriter.close();  
        } catch (IOException e) {  
  
            System.out.println(e.getMessage());  
        }  
  
    }  
  
    // Dom4j解释Xml文档  
    public void parserXml(String fileName) {  
        File inputXml = new File(fileName);  
        SAXReader saxReader = new SAXReader();  
        try {  
            Document document = saxReader.read(inputXml);
            //得到根节点
            Element employees = document.getRootElement(); 
            for (Iterator i = employees.elementIterator(); i.hasNext();) {  
                Element employee = (Element) i.next(); 
                // 遍例节点  
                for (Iterator j = employee.elementIterator(); j.hasNext();) {
                    Element node = (Element) j.next();  
                    System.out.print(node.getName()+":"+node.getText());  
                }  
                System.out.println();
            }  
        } catch (DocumentException e) {  
            System.out.println(e.getMessage());  
        }  
        //System.out.println("dom4j parserXml");  
    }  
}  

