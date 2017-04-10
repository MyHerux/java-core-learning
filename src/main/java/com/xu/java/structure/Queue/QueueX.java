package com.xu.java.structure.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列：Queue接口
 */
public class QueueX {

    public static void main(String args[]){
        Queue<String> queue=new LinkedList<>();
        QueueMethod(queue);

        Deque<String> deque=new ArrayDeque<>();
    }

    private static void QueueMethod(Queue<String> queue){
        //添加元素
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        queue.offer("5");
        System.out.println(queue);

        //添加元素
        //如果队列满了，add方法会抛出一个IllegalStateException异常，而offer方法返回false。
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        System.out.println(queue);

        //返回第一个元素，并在队列中删除
        System.out.println("remove="+queue.remove());
        System.out.println(queue);

        //返回第一个元素，并在队列中删除
        //如果队列是空的，remove方法抛出一个NoSuchElementException异常，而poll方法返回false
        System.out.println("poll="+queue.poll());
        System.out.println(queue);

        //返回第一个元素
        System.out.println("element="+queue.element());
        System.out.println(queue);

        //返回第一个元素
        System.out.println("peek="+queue.peek());
        System.out.println(queue);
    }
}
