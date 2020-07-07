package com.zzj.javaSE.xml.sax;

import java.io.FileOutputStream;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * 为解决DOM的问题，出现了SAX。SAX ，事件驱动。
 * 当解析器发现元素开始、元素结束、文本、文档的开始或结束等时，发送事件，程序员编写响应这些事件的代码，保存数据。
 * 优点：不用事先调入整个文档，占用资源少；SAX解析器代码比DOM解析器代码小，适于Applet，下载。
 * 缺点：不是持久的；事件过后，若没保存数据，那么数据就丢了；
 * 无状态性；从事件中只能得到文本，但不知该文本属于哪个元素；
 * 使用场合：Applet;只需XML文档的少量内容，很少回头访问；机器内存少；
 */
public class DomDemo1 {
	public String createXml() {
		String xmlStr = null;  
        try {  
        	//相对路径(或者写成带盘符的绝对路径)：src\\com\\zzj\\javaSE\\xml\\test\\cities.xml
            Result resultXml = new StreamResult(new FileOutputStream("src\\com\\zzj\\javaSE\\xml\\test\\cities.xml"));  
            StringWriter writerStr = new StringWriter();  
            SAXTransformerFactory sff = (SAXTransformerFactory) SAXTransformerFactory  
                    .newInstance();  
            TransformerHandler th = sff.newTransformerHandler();  
            Transformer transformer = th.getTransformer();  
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");  
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");  
            th.setResult(resultXml);  
            th.startDocument();  
            String four = "\n    ";  
            String eight = "\n        ";  
            AttributesImpl attr = new AttributesImpl();  
            th.startElement("", "", "country", attr);  
            th.characters(four.toCharArray(), 0, four.length());  
  
            th.startElement("", "", "china", attr);  
  
            th.characters(eight.toCharArray(), 0, eight.length());  
  
            th.startElement("", "", "city", attr);  
            String bj = "Beijing";  
            th.characters(bj.toCharArray(), 0, bj.length());  
            th.endElement("", "", "city");  
  
            th.characters(eight.toCharArray(), 0, eight.length());  
  
            th.startElement("", "", "city", attr);  
            String sh = "Shengzhen";  
            th.characters(sh.toCharArray(), 0, sh.length());  
            th.endElement("", "", "city");  
  
            th.characters(four.toCharArray(), 0, four.length());  
  
            th.endElement("", "", "china");  
            th.endElement("", "", "country");  
            th.endDocument();  
            xmlStr = writerStr.getBuffer().toString();  
        } catch (TransformerConfigurationException e) {  
            e.printStackTrace();  
        } catch (SAXException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return xmlStr;  
	} 
}
