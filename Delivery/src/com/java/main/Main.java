package com.java.main;

import com.java.bean.Express;
import com.java.dao.DeliveryDao;
import com.java.view.Views;

/**
 * @Author: YNB
 * @Description:快递管理系统
 * @Date Created in 2020-08-30 21:49
 * @Modified By:
 */
public class Main {
    private static Views v = new Views();
    private static DeliveryDao dao = new DeliveryDao();

    public static void main(String[] args) {
        v.welcome();
        p:
        while (true) {
            int num = v.menu();
            switch (num) {
                case 0:
                    break p;
                case 1:
                    adminClient();
                    break ;
                case 2:
                    userClient();
                    break ;
            }
        }
        v.bye();
    }

    private static void adminClient() {
        while (true) {
            int num = v.adminMenu();
            switch (num) {
                case 0:
                    return;
                case 1: {//1、快递录入
                    //1、 提示输入
                    Express es = v.insert();
                    //2、 判断是否能够存储快递
                    Express es2 = dao.findByNumber(es.getNum());
                    //3、存储快递
                    if (es2 == null) {
                        //单号不存在，可以存储
                        dao.add(es);
                        v.printExpress(es);
                    } else {
                        //单号已存在
                        v.printExist();
                    }
                }
                break;
                case 2: {//2、删除快递
                    //1、提示输入单号
                    String num1 = v.findByNumber();
                    //2、判断单号是否存在
                    Express ex = dao.findByNumber(num1);
                    if (ex == null) {
                        v.printNull();
                    } else {
                        v.printExpress(ex);
                        int type = v.delete();
                        if (type == 1) {
                            dao.delete(ex);
                            v.success();
                        }

                    }

                }
                break;
                case 3: {//3、修改快递
                    //1、提示输入单号
                    String num1 = v.findByNumber();
                    //2、判断单号是否存在
                    Express ex = dao.findByNumber(num1);
                    if (ex == null) {
                        v.printNull();
                    } else {
                        //3、打印快递信息
                        v.printExpress(ex);
                        //4、提示用户新的输入
                        v.update(ex);
                        //5、更新数据，删除旧数据录入新快递
                        dao.update(ex, ex);
                        v.success();
                        v.printExpress(ex);
                    }
                }
                break;
                case 4: {//4、查看所有快递
                    Express[][] es1 = dao.findAll();
                    if(es1 != null){
                        v.printAll(es1);
                    }else{
                        v.printNull();
                    }


                }
                break;

            }
        }

    }

    private static void userClient() {
        //获取取件码
        int code = v.userMenu();
        //用取件码取快递
        Express es = dao.findByCode(code);
        //判断是否存在
        if(es == null){
            v.printNull();
        }else{
            v.success();
            v.printExpress(es);
            dao.delete(es);
        }

    }


}
