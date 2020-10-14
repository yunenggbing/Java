package com.java.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-03 23:15
 * @Modified By:
 */
public class OutputStream {
    public static void main(String[] args) throws IOException {
        //FileOutputStream
        /*
        FileOutputStream fos = new FileOutputStream("D:\\1.txt");
        byte [] bytes = "ABCDEFHDH".getBytes();
        fos.write(bytes,2,5);
        fos.close();
        System.out.println("已经写出");
         */
        //FileInputStream
//        FileInputStream  fis  = new FileInputStream("D:\\1.txt");  //文件中abcde
//        byte b1 = (byte) fis.read(); //b1=97
//        System.out.println(b1);
//        byte b2 = (byte) fis.read();//b2=98
//        System.out.println(b2);
        //使用循环
        FileInputStream  fis  = new FileInputStream("D:\\1.txt");
       /*
       while (true){
            byte b1 = (byte) fis.read();
            if (b1 == -1){
                break;
            }
            System.out.println(b1);
        }
        */
        //文件中abcdefghijklmn
        byte [] bytes = new byte[5];    //每次读取五个数据
        int len = fis.read(bytes);
        System.out.println(new String(bytes,0,len)); //abcde  从第0个读len个内容
        len = fis.read(bytes);
        System.out.println(new String(bytes,0,len));//fghij   从第0个读len个内容
        len = fis.read(bytes);
        System.out.println(new String(bytes,0,len));//klmn    从第0个读len个内容

        fis.close();


    }
}
