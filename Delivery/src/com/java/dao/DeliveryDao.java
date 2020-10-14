package com.java.dao;

import com.java.bean.Express;
import com.java.view.Views;

import java.util.Random;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-08-30 20:40
 * @Modified By:
 */
public class DeliveryDao {
    Views v = new Views();
    private   Express[][] data = new Express[10][];
    private int size ;
    {
        for(int i=0;i<10;i++){
            data[i] = new Express[10];
        }
    }

    private Random random = new Random();

    /**
     * 录入快递
     *
     * @param es
     * @return
     */
    public boolean add(Express es) {
        int x = -1;
        int y = -1;
        if (size == 100) {
            return false;
        }
        while (true) {
            //1、生成位置
            x = random.nextInt(10);
            y = random.nextInt(10);
                if (data[x][y] == null) {
                    break;
                }
                break;
        }
        //2、生成取货码
        int code = randomCode();
        es.setCode(code);
        try {
            data[x][y] = es;
        }catch (NullPointerException e){
            data[x][y] = es;
        }
        return true;
    }

    /**
     * 查找快递单号
     *
     * @param num
     * @return
     */
    public Express findByNumber(String num) {
        Express es = new Express();
        es.setNum(num);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    if (es.equals(data[i][j])) {
                        return data[i][j];
                    }
                }catch(NullPointerException e){
                    break;
                }
            }
        }
        return null;
    }


    /**
     * 生成随机取件码
     *
     * @return
     */
    private int randomCode() {
        while (true) {
            int code = random.nextInt(899999) + 100000;
            Express es = findByCode(code);
            if (es == null) {
                return code;
            }
        }
    }



    /**
     * 根据取件码查快递
     *
     * @param code
     * @return
     */
    public Express findByCode(int code) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    if (data[i][j] != null) {
                        if (data[i][j].getCode() == code) {
                            return data[i][j];
                        }
                    }
                }catch(NullPointerException e){
                    break;
                }

            }
        }
        return null;
    }

    public void update(Express oldExpress, Express newExpress) {
            delete(oldExpress);
            add(newExpress);
    }

    /**
     * 删除操作
     * @param es
     */
    public void delete(Express es) {
        p:for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (es.equals(data[i][j])) {
                    data[i][j] = null;
                    break p;
                }
            }
        }
    }

    public Express[][] findAll() {
            return data;
    }

}
