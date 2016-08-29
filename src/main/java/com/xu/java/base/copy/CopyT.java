package com.xu.java.base.copy;

import net.sf.json.JSONObject;

/**
 * Class java中的深拷贝和浅拷贝
 *
 * @author hua xu
 * @version 1.0.0
 * @date 16/08/29
 */
public class CopyT {
    public static void main(String args[]) {
        /**
         * 复制一个简单变量，原始数据类型(int，boolean,char,byte,short,float,double.long)
         */
        System.out.println("-------------------case1----------------------");
        int apple = 5;
        int orange = apple;
        System.out.println("apple:" + apple + "  orange:" + orange);

        /**
         * 复制一个对象。实质是将key_a的引用赋值给key_b。key_a和key_b指向内存中的同一对象。
         */
        System.out.println("-------------------case2----------------------");
        JSONObject key_a = new JSONObject();
        key_a.put("keys", 5);
        JSONObject key_b = key_a;
        System.out.println("Before:a.keys:" + key_a.get("keys") + "  b.keys:" + key_b.get("keys"));
        key_a.put("keys", 10);
        System.out.println("After:a.keys:" + key_a.get("keys") + "  b.keys:" + key_b.get("keys"));

        /**
         * 浅拷贝(复制)
         * 1. 被复制的类需要实现Clonenable接口（不实现的话在调用clone方法会抛出CloneNotSupportedException异常) 该接口为标记接口(不含任何方法)
         * 2. 覆盖clone()方法，访问修饰符设为public。方法中调用super.clone()方法得到需要的复制对象，（native为本地方法)
         */
        System.out.println("-------------------case3----------------------");
        Student stu1 = new Student();
        stu1.setNumber(5);
        Student stu2 = (Student) stu1.clone();
        System.out.println("Before:学生1:" + stu1.getNumber()+"  学生2:"+stu2.getNumber());
        stu2.setNumber(10);
        System.out.println("After:学生1:" + stu1.getNumber()+"  学生2:"+stu2.getNumber());
    }
}

class Student implements Cloneable {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Object clone() {
        Student stu = null;
        try {
            stu = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}


