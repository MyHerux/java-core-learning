package com.xu.java.structure.List;

/**
 * 实现自己的stack
 */
public class MyStack<E> {

    private int elementCount;

    private Object[] elementData;

    public MyStack() {
        this(10);
        this.elementCount = 0;
    }


    public MyStack(int initialSize) {
        if (initialSize >= 0) {
            elementData = new Object[initialSize];
        } else {
            throw new RuntimeException("初始化大小不能小于0：" + initialSize);
        }
    }

    //判空
    public boolean empty() {
        return elementCount == 0;
    }

    //进栈
    public E push(E item) {
        elementData[elementCount++] = item;

        return item;
    }

    //出栈
    public E pop() {
        E obj = peek();

        elementCount--;
        elementData[elementCount] = null;

        return obj;
    }

    //查看栈顶元素但不移除
    @SuppressWarnings("unchecked")
    public synchronized E peek() {
        int len = elementCount;
        if (len == 0)
            throw new RuntimeException("stack is null");
        return (E) elementData[len - 1];
    }

    //返回对象在堆栈中的位置
    public synchronized int search(Object o) {
        if (elementCount < 1)
            return -1;
        if (o == null) {
            for (int i = elementCount - 1; i > 0; i--) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = elementCount - 1; i > 0; i--) {
                if (o.equals(elementData[i]))
                    return i;
            }
        }
        return -1;
    }

    public int size() {
        return elementCount;
    }
}
