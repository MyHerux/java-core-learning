package com.xu.java.structure.List;

import java.util.Stack;

/**
 * Stack类
 * 栈：桶型或箱型数据类型，后进先出，相对堆Heap为二叉树类型，可以快速定位并操作
 * Stack<E>，支持泛型
 * public class Stack<E> extends Vector<E>
 * Stack的方法调用的Vector的方法，被synchronized修饰，为线程安全(Vector也是)
 * Stack methods：
 * push : 把项压入堆栈顶部 ，并作为此函数的值返回该对象
 * pop : 移除堆栈顶部的对象，并作为此函数的值返回该对象
 * peek : 查看堆栈顶部的对象，，并作为此函数的值返回该对象，但不从堆栈中移除它
 * empty : 测试堆栈是否为空
 * search : 返回对象在堆栈中的位置，以 1 为基数
 */
public class StackX {

    public static void main(String[] args) {
        stackMethod();
    }

    //stack operate
    private static void stackMethod() {
        //定义一个Integer泛型的Stack
        Stack<Integer> stack = new Stack<>();
        //MyStack<Integer> stack=new MyStack<>();
        //push : 把项压入堆栈顶部，返回值泛型指定的类型
        //此处将1到5压入栈中
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(3);
        System.out.println("将1到5按顺序压入栈中后为：" + stack);
        //empty : 测试堆栈是否为空，size() == 0，返回值boolean
        System.out.println("栈中stack是否为空 : " + (stack.empty() ? "空" : stack.size()));
        //search : 返回对象在堆栈中的第一个位置，以 1 为基数，参数：search(Object o) ，返回值int
        int oStack = stack.search(3);
        System.out.println("查找栈stack中对象3的位置elementId为 : " + oStack);
        //peek : 查看堆栈顶部的对象，但不从堆栈中移除它，返回值泛型指定的类型
        int topElement = stack.peek();
        System.out.println("查看stack的栈顶元素为 : " + topElement);
        System.out.println("peek操作stack后为 : " + stack);
        //pop : 移除堆栈顶部的对象，并作为此函数的值返回该对象，返回值泛型指定的类型
        int oRemove = stack.pop();
        System.out.println("移除stack栈顶的元素为 : " + oRemove);
        System.out.println("pop操作移除stack栈顶元素后为 : " + stack);
    }
}
