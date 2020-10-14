package com.java.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: YNB
 * @Description:XML解析网上内容
 * @Date Created in 2020-09-10 22:08
 * @Modified By:
 */
public class Demo2 {
    public static void main(String[] args) throws IOException, DocumentException {
        String phone = "15645893265";
        //1、获取XML资源的输入流
        URL url = new URL("http://apis.juhe.cn/mobile/get? phone="+phone+"&dtype=xml&key=9f3923e8f87f1ea50ed4ec8c39cc9253");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        //2、创建一个XML读取对象
        SAXReader sr = new SAXReader();
        //3、通过读取对象，读取XML数据，并返回文档对象
        Document doc = sr.read(is);
        //4、获取根节点
        Element rootElement = doc.getRootElement();
        //5、解析内容
        String code = rootElement.elementText("resultcode");
        if ("200".equals(code)){
            Element result = rootElement.element("result");
            String province = result.elementText("province");
            String city = result.elementText("city");
            if (province.equals(city)){
                System.out.println("手机号码归属地为："+city);
            }else{
                System.out.println("手机号码归属地为："+province+"  "+city);
            }
        }else{
            System.out.println("手机号输入错误！！");
        }

    }
}
