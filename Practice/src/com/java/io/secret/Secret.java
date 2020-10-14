package com.java.io.secret;

import java.io.*;
import java.util.Scanner;

/**
 * @Author: YNB
 * @Description:文件加密或解密工具
 * @Date Created in 2020-09-04 20:40
 * @Modified By:
 */
public class Secret {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入文件路径：");
        Scanner input =  new Scanner(System.in);
        String Filename  =  input.nextLine();
        //原文件
        File oldFile =  new File(Filename);
        //新文件
        File newFile = new File(oldFile.getParentFile(),"加密-"+oldFile.getName());

        FileInputStream fis =  new FileInputStream(oldFile);
        FileOutputStream fos =  new FileOutputStream(newFile);

        while(true) {
            int b = fis.read();
            if (b == -1) {
                break;
            }
            fos.write(b ^ 10);  //任何数异或一个相同的数字两次等于其本身
        }
        fis.close();
        fos.close();
        System.out.println("加密解密完成。");
    }
}
