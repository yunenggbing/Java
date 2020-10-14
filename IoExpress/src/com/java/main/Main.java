package com.java.main;

import com.java.bean.Express;
import com.java.dao.Dao;
import com.java.views.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-03 20:16
 * @Modified By:
 */
public class Main {
    private static Dao d;

    static {
        d = new Dao();
    }

    private static View v = new View();
    private static List<Express> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        v.welcom();
        p:while (true) {
            int num = v.menu();
            switch (num) {
                case 1: {
                    admin();
                }
                break ;
                case 2: {
                    user();
                }
                break ;
                case 0: {
                    break p;
                }
            }
        }
        v.bye();
    }

    private static void user() throws IOException {
        int code = v.userMenu();

        Express es = d.findByCode(code);

        if(es == null){
            v.printNull();
        }else{
            v.success();
            int pos = d.findPos(es);
            v.printAll(es,pos);
            d.delete(es);
        }
    }

    private static void admin() throws IOException {
        int num = v.adminMenu();
        switch (num){
            case 1:{
                Express es = v.insert();
                Express es2 = d.findByNumber(es.getId());
                if (es2 == null){
                    d.insert(es);
                    int pos  = d.findPos(es);
                    v.printAll(es,pos);
//                    v.printExpress(es);
                }else{
                    v.printExist();
                }
            }
            break;
            case 2:{
                String num1 = v.findByNumber();

                Express es = d.findByNumber(num1);
                if (es == null){
                    v.printNull();
                }else {
                    int pos  = d.findPos(es);
                    v.printAll(es,pos);
//                    v.printExpress(es);
                    int i = v.delete();
                    if (i == 1) {
                        d.delete(es);
                        v.success();
                    }
                }
            }
            break;
            case 3:{
                String num1 = v.findByNumber();

                Express es = d.findByNumber(num1);
                if (es == null){
                    v.printNull();
                }else{
                    v.printExpress(es);
                    v.update(es);
                    v.success();
                    int pos  = d.findPos(es);
                    v.printAll(es,pos);

                }
            }
            break;
            case 4:{
                /**
                   list = d.getAll();
                   if(list.size() == 0){
                       v.nullExpress();
                   }
                for (Express es: list ) {
                    int i = d.findPos(es);
                    v.printAll(es ,i);

                }
                 */
            d.ioreadALL();
            }
            break;
            case 0:{
                return ;
            }
        }
    }
}
