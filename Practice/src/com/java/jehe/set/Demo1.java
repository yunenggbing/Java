package com.java.jehe.set;

import java.util.Objects;
import java.util.TreeSet;

/**
 * @Author: YNB
 * @Description:TreeSet
 * @Date Created in 2020-09-02 22:17
 * @Modified By:
 */
public class Demo1 {
    public static void main(String[] args) {
        TreeSet<Person>  treeSet= new TreeSet<>();
        Person p1 = new Person("张三",50);
        Person p2 = new Person("李四",20);
        //因为Set是有序的集合，当我们使用自定义的类型是无法进行排序
        //我们需要实现comparable类来对排序规则进行声明。
        treeSet.add(p1);
        treeSet.add(p2);
        for (Person p: treeSet             ) {
            System.out.println(p);
        }

    }

    static  class  Person implements  Comparable<Person> {
        private  String name;
        private  int age;
        //实现排序的规则
        @Override
        public int compareTo(Person o) {
            //this与o进行比较
            //返回值：
            //负数：this小于o;零：this与o相等;正数：this大于o
            if(this.age < o.age){
                return -1;
            }else if(this.age == o.age){
                return 0;
            }
            return 1;
        }

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }


    }
}
