package com.java.io.file;

import java.io.File;
import java.io.IOException;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-03 22:00
 * @Modified By:
 */
public class Demo {
    public static void main(String[] args) throws IOException {
//        ///若路径下不存在可以调用方法创建，若已存在则会创建失败
//        File file = new File("F:\\开课吧-Java\\第四章\\第四节\\1.txt");
//        boolean flag = file.createNewFile(); //file.createNewFile()会返回一个bool类型得数据
//        System.out.println(flag?"创建成功":"创建失败");
            File file = new File("F:\\开课吧-Java");
            File [] files =  file.listFiles();
            listFiles(files);

    }

    /**
     * 遍历文件下的所有文件
     * @param files
     */

    public  static  void listFiles(File [] files){
        if(files != null  && files.length >0){
            for (File f:files     ) {
                //是文件
                if(f.isFile()){
                    if(f.getName().endsWith(".md")){
                        //找到了.md文件
                        System.out.println("找到了一个md文件,文件名是："+f.getName()+",路径是："+f.getAbsolutePath());
                    }
                }else{
                    //是文件夹
                    File [] newf = f.listFiles();
                    listFiles(newf);
                }

            }
        }
    }

}
