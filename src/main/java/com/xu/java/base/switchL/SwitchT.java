package com.xu.java.base.switchL;

/**
 * java7特性：switch语句可以使用string类型
 */
public class SwitchT {
    public static void main(String[] args) {
        String a = "fruit";
        switch (a) {
            case "apple":
                System.out.println("this is a apple");
                break;
            default:
                System.out.println("this is a fruit");
                break;
        }

        /**
         * 使用带标签的continue，打印100到200的质数
         */
        outers:
        for (int i = 100; i < 200; i++) {
            for (int j = 2; j < i / 2; j++)
                if (i % j == 0)
                    continue outers;
            System.out.println(i);
        }
    }
}
