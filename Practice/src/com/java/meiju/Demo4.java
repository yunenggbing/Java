package com.java.meiju;

import java.lang.annotation.*;

/**
 * @Author: YNB
 * @Description:自定义注解
 * @Date Created in 2020-09-11 21:41
 * @Modified By:
 */
@Mytype
public class Demo4 {
    public static void main(String[] args) {

    }

}
//注解是否包含在文档中
@Documented
//用途类型   类、方法
@Target({ElementType.TYPE,ElementType.METHOD})
//保存策略
@Retention(RetentionPolicy.RUNTIME)
//可以继承
@Inherited
@interface Mytype{

}