package com.java.view;

import com.java.bean.Express;

import java.util.Scanner;

/**
 * @Author: YNB
 * @Description:快递系统视图
 * @Date Created in 2020-08-30 17:15
 * @Modified By:
 */
public class Views {
    Scanner  input =  new Scanner(System.in);

    /**
     * 欢迎界面
     */
    public  void  welcome(){

        System.out.println("-------欢迎进入爱情公寓小区快递管理系统-------");
    }

    /**
     * 退出界面
     */
    public  void bye(){

        System.out.println("-------欢迎下次继续光临爱情公寓小区快递管理系统-------");
    }


    /**
     * 选择身份主菜单
     * @return 身份序号
     */
    public  int  menu(){
        System.out.println("请输入您的的身份序号：");
        System.out.println("1、快递管理员");
        System.out.println("2、普通用户");
        System.out.println("0、退出");
        String s = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(s);
        }catch (NumberFormatException e){

        }
        if(num<0 || num >2 ){
            return menu();
        }
        return  num;
    }

    /**
     * 快递管理员菜单
     * @return
     */
    public  int  adminMenu(){
        System.out.println("请输入您的功能序号：");
        System.out.println("1、快递录入");
        System.out.println("2、删除快递");
        System.out.println("3、修改快递");
        System.out.println("4、查看所有快递");
        System.out.println("0、返回上级目录");
        String s = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(s);
        }catch (NumberFormatException e){

        }
        if(num<0 || num >4 ){
            System.out.println("输入的数据有误，请重新输入");
            return adminMenu();
        }
        return  num;
    }

    /**
     * 快递录入功能
     * @param
     * @return
     */
    public Express insert(){
        System.out.println("请输入需要录入的单号：");
        String number = input.nextLine();
        System.out.println("请输入需要录入的快递公司：");
        String text =  input.nextLine();

        Express es  = new Express();
        es.setNum(number);
        es.setCompany(text);
        return es;
    }

    /**
     * 删除功能
     * @return 需要删除的单号
     */
    public  int   delete(){
        System.out.println("是否确认删除：");
        System.out.println("1、确认删除");
        System.out.println("2、取消删除");

        String s = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(s);
        }catch (NumberFormatException e){

        }
        if(num<1 || num >2 ) {
            System.out.println("输入的数据有误，请重新输入");
            return delete();
        }
        return  num;
    }

    /**
     * 修改数据
     * @param es
     */
    public  void update(Express es){
        System.out.println("输入需要修改的单号：");
        String num  = input.nextLine();
        System.out.println("请输入公司:");
        String company =  input.nextLine();

        es.setCompany(company);
    }

    public  String findByNumber(){
        System.out.println("请根据提示进行操作：");
        System.out.println("输入需要修改的单号：");
        String num  = input.nextLine();

        return  num;
    }

    /**
     * 给定数组进行遍历数据
     * @param es
     */

    public   void printAll(Express[][] es){
        int count = 0;
        for(int i = 0; i<10;i++){
            for(int j=0; j<10;j++){
                if(es[i][j] != null){
                    System.out.print("第"+i+"行 第"+j+"列");
                    printExpress(es[i][j]);
                    count ++;
                }
            }
        }
        if(count  == 0){
            System.out.println("暂无快递。");
        }
    }

    /**
     *显示快递信息
     * @param es
     */
    public  void printExpress(Express es) {
        System.out.println("快递信息如下：");
        System.out.println("快递单号是："+es.getNum()+",快递公司是："+es.getCompany()+",取件码是："+es.getCode());
    }


    /**
     * 用户菜单
     * @return
     */
    public  int   userMenu(){
        System.out.println("请根据提示操作：");
        System.out.println("请输入取件码：");
        String code = input.nextLine();
        int num =-1;
        try {
            num  = Integer.parseInt(code);
        }catch (NumberFormatException e){

        }
        if(num <100000 || num  >999999 ){
            System.out.println("输入的数据有误，请重新输入");
            return userMenu();
        }

        return num;
    }

    /**
     * 查找单号
     * @return
     */
    public  String findByCode(){
        System.out.println("请根据提示进行操作：");
        System.out.println("请输入您的取件码：");
        String num = input.nextLine();
        return num;
    }
//
//    public String [] findByPos(){
//        String []pos =new String[2];
//        System.out.println("请根据提示进行操作：");
//        System.out.println("请输入您的快递在第几行：");
//        pos[0] = input.nextLine();
//        System.out.println("请输入您的快递在第几列：");
//        pos[1] = input.nextLine();
//        return  pos;
//    }

    /**
     * 存储时数据已存在
     */
    public  void printExist(){
        System.out.println("该单号已存在，请勿再次存储。");
    }

    /**
     * 修改时单号为空
     */
    public  void printNull(){
        System.out.println("该单号不存在，请检查您的输入！");
    }

//    public  void printCode(Express es){
//        System.out.println("快递的取件码为："+es.getCode());
//    }

    public  void success(){
        System.out.println("操作成功。");
    }
}
