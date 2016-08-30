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
        System.out.println("---------------------case1:简单变量----------------------");
        int apple = 5;
        int orange = apple;
        System.out.println("apple:" + apple + "  orange:" + orange);

        /**
         * 复制一个对象。实质是将key_a的引用赋值给key_b。key_a和key_b指向内存中的同一对象。
         */
        System.out.println("---------------------case2:对象-------------------------");
        JSONObject key_a = new JSONObject();
        key_a.put("keys", 5);
        JSONObject key_b = key_a;
        System.out.println("Before:a.keys:" + key_a.get("keys") + "  b.keys:" + key_b.get("keys"));
        key_a.put("keys", 10);
        System.out.println("After:a.keys:" + key_a.get("keys") + "  b.keys:" + key_b.get("keys"));

        /**
         * 浅拷贝-shallow copy
         * 1. 被复制的类需要实现Clonenable接口（不实现的话在调用clone方法会抛出CloneNotSupportedException异常) 该接口为标记接口(不含任何方法)
         * 2. 覆盖clone()方法，访问修饰符设为public。方法中调用super.clone()方法得到需要的复制对象，（native为本地方法)
         */
        System.out.println("---------------------case3:浅拷贝-----------------------");
        Student stu1 = new Student();
        stu1.setNumber(5);
        Student stu2 = (Student) stu1.clone();
        System.out.println("Before:学生1:" + stu1.getNumber() + "  学生2:" + stu2.getNumber());
        stu2.setNumber(10);
        System.out.println("After:学生1:" + stu1.getNumber() + "  学生2:" + stu2.getNumber());
        /**此时stu1和stu2已经不是同一对象了*/
        System.out.println(stu1 == stu2);

        /**
         * 深拷贝-deep copy
         */
        System.out.println("---------------------case4:深拷贝------------------------");
        Address address = new Address();
        address.setAdd("成都市");
        Student stu3 = new Student();
        stu3.setNumber(5);
        stu3.setAddr(address);
        Student stu4 = (Student) stu3.clone();
        System.out.println("Before:\n学生3:" + stu3.getNumber() + ",地址:" + stu3.getAddr().getAdd());
        System.out.println("学生4:" + stu4.getNumber() + ",地址:" + stu4.getAddr().getAdd());

        /**只改变student4里面的number*/
        stu4.setNumber(10);
        System.out.println("After:\n学生3:" + stu3.getNumber() + ",地址:" + stu3.getAddr().getAdd());
        System.out.println("学生4:" + stu4.getNumber() + ",地址:" + stu4.getAddr().getAdd());

        /**改变student里面address实例的地址*/
        address.setAdd("高新区");
        System.out.println("After:\n学生3:" + stu3.getNumber() + ",地址:" + stu3.getAddr().getAdd());
        System.out.println("学生4:" + stu4.getNumber() + ",地址:" + stu4.getAddr().getAdd());
        /**
         * 此时两个student的address都改变了，原因是浅复制只是复制了addr变量的引用，并没有真正的开辟另一块空间，将值复制后再将引用返回给新对象。
         * 所以，为了达到真正的复制对象，而不是纯粹引用复制。我们需要将Address类可复制化，并且修改clone方法。
         * 代码见${@link CopyT2}
         */

    }
}

class Address {
    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}

class Student implements Cloneable {
    private int number;

    private Address addr;

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

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


