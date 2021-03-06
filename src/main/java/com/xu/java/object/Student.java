package com.xu.java.object;

/**
 * 程序执行过程中的内存分析
 */
public class Student {
    //静态的数据
    private String name;

    //静态的行为
    private void study() {
        System.out.println(name + " is studying");
    }

    public static void main(String args[]) {
        /*通过类加载器class loader加载Student类。加载后在方法区（堆）就有了Student类的信息。*/
        Student s1 = new Student();//s1（局部变量）存放在栈中,new出来的对象在堆中，s1指向Student对象

        s1.name = "xu";
        s1.study();
    }
}
