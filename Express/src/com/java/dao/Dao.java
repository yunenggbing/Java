package com.java.dao;

import com.java.bean.Express;

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
    public boolean insert(Express es){
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
    public  boolean update(Express oldExpress,Express newExpress){
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

}
