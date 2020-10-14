package com.java.ks;

/**
 * @Author: YNB
 * @Description:单例设计模式
 * @Date Created in 2020-10-08 14:50
 * @Modified By:
 */
public class KS2_2 {
    private  static KS2_2 ks_2_2 = new KS2_2();
    private KS2_2(){}
    public  static KS2_2 getInstance(){
        return ks_2_2;
    }
}
