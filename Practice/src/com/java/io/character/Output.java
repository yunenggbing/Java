package com.java.io.character;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-04 21:34
 * @Modified By:
 */
public class Output {
    public static void main(String[] args) throws IOException {
//        FileWriter fw = new FileWriter("D:\\1.txt");
//        fw.write("aaaaa");
//        FileWriter fw = new FileWriter("D:\\1.txt",true);//在文件内容后面追加
//        FileWriter fw2 = (FileWriter) fw.append("hahahhh");
//        fw.close();
//        System.out.println(fw == fw2);  //返回true
        /*

        FileReader fr =  new FileReader("D://1.txt");

//        while(true){
//            int c = fr.read();
//            if(c ==  -1){
//                break;
//            }
//            System.out.println(c);
//        }
        char [] c = new char[100];
        int  len =  fr.read(c);
        System.out.println(new String(c,0,len));
        fr.close();
         */


//        //字节流转换为字符流
//        FileInputStream fs = new FileInputStream("D:\\1.txt");
//
//        //参数1  要转换的字节流
//        //参数2  指定编码名称  utf-8、gbk....
//        InputStreamReader isr =  new InputStreamReader(fs,"gbk");
//        while(true){
//            int c = isr.read();
//            if(c == -1){
//                break;
//            }
//            System.out.println((char) c);
//        }
//        FileOutputStream fos =  new FileOutputStream("d:2.txt");
//        OutputStreamWriter osr = new OutputStreamWriter(fos);
//
//        osr.write("楚河汉界");
//        osr.flush();
//        osr.close();
        //打印流
//        PrintStream  ps =  new PrintStream("d:\\2.txt");
//        ps.println("楚河汉界");
//        ps.println("楚河汉界");
//        ps.println("楚河汉界");
//        ps.close();
//        PrintWriter pw = new PrintWriter("d:\\1.txt");
//        pw.println("楚河汉街");
//        pw.println("楚河汉街");
//        pw.println("楚河汉街");
//        pw.flush();
//        pw.close();

//        FileOutputStream fos = new FileOutputStream("d:\\1.txt");
//        PrintWriter pw = new PrintWriter(fos);
//        pw.println("楚河汉街");
//        pw.println("楚河汉街");
//        pw.println("楚河汉街");
//        pw.flush();
//        pw.close();

        //缓存读取流
//        FileReader fr = new FileReader("d:\\1.txt");
//        BufferedReader br = new BufferedReader(fr);
//        String text = br.readLine();
//        System.out.println(text);

//        try {
//            String s = null;
//            s.toString();
//        }catch (Exception e){
//            PrintWriter pw = new PrintWriter("D:\\java.log");
//            SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH-mm");
//            pw.println(sdt.format(new Date()));
//            e.printStackTrace(pw);
//            pw.close();
//        }

        Properties pp = new Properties();
        //写
//        pp.put("name","hhhh");
//        pp.put("age","19");
//        FileWriter fw = new FileWriter("d:\\2.properties");
//        pp.store(fw,"这是注释");
//        fw.close();
        //读取
        Reader r = new FileReader( "d:\\2.properties");
        pp.load(r);
        System.out.println(pp.get("name"));
        System.out.println(pp.get("age"));






    }


}

