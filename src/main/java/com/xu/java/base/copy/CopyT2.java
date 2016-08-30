package com.xu.java.base.copy;

/**
 * Class java中的深拷贝
 *
 * @author hua xu
 * @version 1.0.0
 * @date 16/08/29
 */
public class CopyT2 {
    public static void main(String args[]) {
        System.out.println("---------------------case4:深拷贝------------------------");
        NEWAddress addr = new NEWAddress();
        addr.setAdd("成都市");
        NewStudent stu1 = new NewStudent();
        stu1.setNumber(5);
        stu1.setAddr(addr);

        NewStudent stu2 = (NewStudent)stu1.clone();

        System.out.println("Before:\n学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());

        addr.setAdd("高新区");

        System.out.println("After:\n学生1:" + stu1.getNumber() + ",地址:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getNumber() + ",地址:" + stu2.getAddr().getAdd());

    }
}
class NEWAddress implements Cloneable {
    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public Object clone() {
        NEWAddress addr = null;
        try{
            addr = (NEWAddress)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return addr;
    }
}

class NewStudent implements Cloneable{
    private int number;

    private NEWAddress addr;

    public NEWAddress getAddr() {
        return addr;
    }

    public void setAddr(NEWAddress addr) {
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
        NewStudent stu = null;
        try{
            stu = (NewStudent)super.clone(); //浅复制
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        stu.addr = (NEWAddress)addr.clone();   //深度复制
        return stu;
    }
}