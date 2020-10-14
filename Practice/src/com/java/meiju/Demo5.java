package com.java.meiju;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-11 22:18
 * @Modified By:
 */
public class Demo5 {
    public static void main(String[] args) throws ClassNotFoundException {
        //第一种方式，通过包名.类名.class 加载类
        Class<Person> c1 = com.java.meiju.Person.class;
        System.out.println(c1);
        //第二种方式，通过类的对象获取类的信息
        Person p = new Person();
        Class<Person> c2 = (Class<Person>) p.getClass();
        System.out.println(c2);
        //第三种  动态加载，只要运行程序的时候，类存在就会运行成功。

        Class<Person> c3 = (Class<Person>) Class.forName("com.java.meiju.Person");
        System.out.println(c3);
    }
}
