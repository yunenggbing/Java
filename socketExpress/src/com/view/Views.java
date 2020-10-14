package com.view;



import com.bean.Express;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Views {
    private Scanner input = new Scanner(System.in);
    private Random rand = new Random();
    private List<Integer> list = new ArrayList<Integer>();
    //开始
    public void start(){
        System.out.println("---欢迎使用---");
    }

    //结束
    public void end(){
        System.out.println("---感谢您的使用---");
        System.out.println("-------再见-------");
    }

    //文件操作异常
    public void IOError(){
        System.out.println("文件操作异常");
    }

    //接受用户输入的选项
    public int input(){
        while(true){
            int num = -1;
            try {
                num = input.nextInt();
                return num;
            }catch(Exception e){
                System.out.println("请正确输入序号！！！");
                input.next();
            }
        }
    }

    //打印信息
    public void printExpress(Express e){
        System.out.println("快递单号："+e.getId()+"， 快递公司："+e.getCompany()+"， 快递取件码："+e.getCode());
    }

    //输入信息有误
    public void error(){
        System.out.println("你输入的信息有误，快递不存在，请重新输入");
    }

    //输入选项有误
    public void choiceError(){
        System.out.println("你输入的选项有误，请重新输入");
    }

    //空快递库
    public void nullExpress(){
        System.out.println("当前快递库为空");
    }

    //随机生成取件码
    public int code(){
        while(true){
            int chongfu = 0;
            int code = (int)(rand.nextInt(900000)+100000);
            for(int i=0;i<list.size();i++){
                if(list.get(i)==code){
                    chongfu++;
                }
            }
            if(chongfu==0){
                list.add(code);
                return code;
            }
        }
    }

    //登录
    public int login(){
        System.out.println("---请选择登陆用户---");
        System.out.println("---1.管理员登录-----");
        System.out.println("---2.用户登录-------");
        System.out.println("---0.退出-----------");
        return input();
    }

    //管理员页面
    public int aindex(){
        System.out.println("---请选择要进行的操作---");
        System.out.println("---1.快递录入----------");
        System.out.println("---2.删除快递----------");
        System.out.println("---3.修改快递----------");
        System.out.println("---4.查看所有快递------");
        System.out.println("---0.返回上级目录------");
        return input();
    }

    //快递录入
    public Express insert(){
        System.out.println("---请输入快递单号---");
        String number = input.next();
        System.out.println("---请输入快递公司---");
        String company = input.next();
        int code = code();
        Express e = new Express();
        e.setId(number);
        e.setCompany(company);
        e.setCode(code);
        return e;
    }

    //重复录入
    public void youle(){
        System.out.println("快递已存在");
    }

    //录入成功
    public void printInsert(){
        System.out.println("快递录入成功");
    }

    //录入失败
    public void insertError(){
        System.out.println("快递录入失败");
    }

    //快递删除
    public String delete(){
        System.out.println("---请输入需要删除的快递单号---");
        String number = input.next();
        return number;
    }

    //删除确认
    public int deleteConfirm(){
        System.out.println("---是否确认删除该快递---");
        System.out.println("---1.是---------------");
        System.out.println("---2.否---------------");
        return input();
    }

    //删除成功
    public void printDelete(){
        System.out.println("快递删除成功");
    }

    //删除失败
    public void deleteError(){
        System.out.println("快递删除失败");
    }

    //修改快递
    public String update(){
        System.out.println("---请输入需要修改的快递单号---");
        String number = input.next();
        return number;
    }

    //新的数据
    public Express newData(){
        System.out.println("---请输入新的快递单号---");
        String number = input.next();
        System.out.println("---请输入新的快递公司---");
        String company = input.next();
        int code = code();
        Express e = new Express();
        e.setId(number);
        e.setCompany(company);
        e.setCode(code);
        return e;
    }

    //修改成功
    public void printUpdata(){
        System.out.println("快递修改成功");
    }

    //修改失败
    public void updataError(){
        System.out.println("快递修改失败");
    }

    //查询所有快递
    public void printAll(List<Express> list){
        for (Express express:list) {
            printExpress(express);
        }
    }

    //用户页面
    public int uindex(){
        System.out.println("---请选择要进行的操作---");
        System.out.println("---1.快递取出----------");
        System.out.println("---0.返回上级目录------");
        return input();
    }

    //取快递
    public int getExpress(){
        System.out.println("---请输入取件码---");
        return input();
    }

    //快递所在位置
    public void address(int index){
        System.out.println("快递在"+ index+"号快递柜");
    }

    //删除取件码
    public void deleteCode(int code){
        list.remove((Integer) code);
    }

    //取件提醒
    public void printGet(){
        System.out.println("请尽快取出快递");
    }

    //取件失败
    public void getError(){
        System.out.println("取件失败");
    }
}
