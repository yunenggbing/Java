package com.java.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @Author: YNB
 * @Description:XML解析本地文件
 * @Date Created in 2020-09-10 21:39
 * @Modified By:
 */
public class Demo1 {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        //1、获取流
        FileInputStream fis = new FileInputStream("E:\\IDEA\\Projects\\XML_JSON\\src\\Demo.xml");
        //2、创建XML读取对象
        SAXReader sar = new SAXReader();
        //3、读取得到文档对象
        //Ctrl+Alt+V  快速创建对象
        Document doc = sar.read(fis);
        //4、通过文档获取根元素
        Element root = doc.getRootElement();
        //5、开始解析元素
        System.out.println(root.getName());

        //操作其他内容
//        Element person = root.element("person");
//        Element name = person.element("name");
//        System.out.println(name.getText());

        List<Element> list = root.elements();
        for(int i = 0; i<list.size();i++){
            Element e = list.get(i);
            System.out.println(e.attributeValue("id"));
            System.out.println(e.elementText("name"));
            System.out.println(e.elementText("age"));
            System.out.println("------------");
        }
    }
}
