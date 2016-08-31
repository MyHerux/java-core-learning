package com.xu.java.base.string;

import net.sf.json.JSONObject;

/**
 * Class java的值传递，如果参数类型是原始类型，那么传过来的就是这个参数的一个副本，也就是这个原始参数的值;
 * 如果参数类型是引用类型，那么传过来的就是这个引用参数的副本，这个副本存放的是参数的地址(java除了基本类型都是靠引用对其操作的)。
 * 如果在函数中改变了副本的地址，如new一个，那么副本就指向了一个新的地址，此时传入的参数还是指向原来的地址，所以不会改变参数的值。
 *
 * @author hua xu
 * @version 1.0.0
 * @date 16/08/29
 */
public class StringT {
    public static void main(String[] args) {

        /**
         * Test 1: 原始类型数据-不改变
         */
        int percent = 10;
        System.out.println("Before: percent=" + percent);
        t1(percent);
        System.out.println("After: percent=" + percent);

        /**
         * Test 2: 引用类型数据-会改变
         */
        System.out.println("\nTesting t2:");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", "123");
        System.out.println("Before: jsonObject=" + jsonObject);
        t2(jsonObject);
        System.out.println("After: jsonObject=" + jsonObject.toString());

        /**
         * Test 3: 地址改变-不改变
         */
        System.out.println("\nTesting t3:");
        JSONObject a = new JSONObject();
        a.put("key", "123");
        JSONObject b = new JSONObject();
        b.put("key", "456");
        System.out.println("Before: a=" + a.toString());
        System.out.println("Before: b=" + b.toString());
        t3(a, b);
        System.out.println("After: a=" + a.toString());
        System.out.println("After: b=" + b.toString());
    }

    private static void t3(JSONObject x, JSONObject y) {
        JSONObject temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x.toString());
        System.out.println("End of method: y=" + y.toString());
    }

    private static void t2(JSONObject x) {
        x.put("key2", "456");
        System.out.println("End of method: x=" + x.toString());
    }

    private static void t1(int x) {
        x = 3 * x;
        System.out.println("End of Method X= " + x);
    }
}

