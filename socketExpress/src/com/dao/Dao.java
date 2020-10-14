package com.dao;



import com.bean.Express;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    private List<Express> list = new ArrayList<>();
    private File file = new File("E:\\Express.txt");

    //从文件中读取数据
    public void readFromFile() throws IOException, ClassNotFoundException {
        if(file.length()>0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.file));
            Object obj = ois.readObject();
            if (obj instanceof List) {
                list = (List) obj;
            }
            ois.close();
        }
    }

    //将数据写入文件中
    public void writeToFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.file));
        oos.writeObject(this.list);
        oos.close();
    }

    //数据录入
    public boolean insert(Express e){
        list.add(e);
        return true;
    }

    //数据删除
    public boolean delete(Express e){
        return list.remove(e);
    }

    //数据修改
    public boolean updata(Express e,Express e2){
        list.remove(e);
        insert(e2);
        return true;
    }

    //获取所有数据
    public List<Express> getAll(){
        return list;
    }

    //数据查询
    public Express getByNumber(String number){
        for (Express express:list) {
            if (number.equals(express.getId())) {
                return express;
            }
        }
        return null;
    }

    public Express getByCode(int code){
        for (Express express:list) {
            if (express.getCode() == code) {
                return express;
            }
        }
        return null;
    }

    //获取位置
    public int getIndex(Express express){
        return list.indexOf(express)+1;
    }
}
