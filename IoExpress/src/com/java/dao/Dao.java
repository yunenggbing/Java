package com.java.dao;

import com.java.bean.Express;
import com.java.views.View;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-03 19:27
 * @Modified By:
 */
public class Dao {
    private List<Express> list=new ArrayList<>();



    /**
     * 快递录入
     * @param es
     * @return
     */
    public boolean insert(Express es) throws IOException {
        iowrite(es);
        list.add(es);
        return  true;
    }

    /**
     * 快递删除
     * @param es
     * @return
     */
    public  boolean delete(Express es){
        list.remove(es);
        return  true;
    }

    /**
     * 快递更新
     * @param oldExpress
     * @param newExpress
     * @return
     */
    public  boolean update(Express oldExpress,Express newExpress) throws IOException {
        list.remove(oldExpress);
        insert(newExpress);
        return true;
    }

    /**
     * 获取所有数据
     * @return
     */
    public  List<Express> getAll(){
        return list;
    }

    /**
     * 找快递单号
     * @param number
     * @return
     */
    public Express findByNumber(String number){
        for (Express es : list) {
            if(number.equals(es.getId())){
                return es;
            }
        }
        return null;
    }

    /**
     * 找取件码
     * @param code
     * @return
     */
    public  Express findByCode(int code){
        for (Express es:list) {
            if(code == es.getCode()){
                return es;
            }
        }
        return null;
    }

    /**
     * 找快递位置
     * @param es
     * @return
     */
    public  int findPos(Express es){
        return list.indexOf(es)+1;
    }

    //数据读取
    public  void ioreadALL() throws IOException {
        View v = new View();
        FileReader fr =new FileReader("Express.txt");
        BufferedReader br  =new BufferedReader(fr);

        while(true){
            String text = br.readLine();
            if (text != null) {
                Integer i1 = text.indexOf("id=");
                Integer i2 = text.indexOf("company=");
                Integer i3 = text.indexOf("code=");
                String id = text.substring(i1 + 4, i2 - 3);
                String  company = text.substring(i2 + 9, i3 - 3);
                String code =  text.substring(i3+5,i3+11);

                v.printIoExpress(id,company,code);
            }else{
                v.printNull();
                break;
            }

        }

        br.close();
        fr.close();
    }



    //数据写入
    public  void iowrite(Express es) throws FileNotFoundException {

        FileOutputStream fos =  new FileOutputStream("Express.txt",true);
        PrintWriter pw =  new PrintWriter(fos);
        pw.println(es);
        pw.flush();
        pw.close();
        }

}
