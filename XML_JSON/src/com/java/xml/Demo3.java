package com.java.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @Author: YNB
 * @Description:XPATH解析本地文件
 * @Date Created in 2020-09-10 21:39
 * @Modified By:
 */
public class Demo3 {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        //1、获取流
        FileInputStream fis = new FileInputStream("E:\\IDEA\\Projects\\XML_JSON\\src\\Demo.xml");
        //2、创建XML读取对象
        SAXReader sar = new SAXReader();
        //3、读取得到文档对象
        //Ctrl+Alt+V  快速创建对象
        Document doc = sar.read(fis);
        //4、通过文档对象+XPATH,查找所有的那么节点
        //有多条数据
        List<Node> names = doc.selectNodes("//person//name");
        for (int i =0;i<names.size();i++){
            System.out.println(names.get(i).getName());
            System.out.println(names.get(i).getText());
        }
        //一条数据
        Node node = doc.selectSingleNode("//person[@id='001']//name");
        System.out.println(node.getName()+":"+node.getText());

    }
}
