package com.boot.basics.coding;

/**
 * @Author cherrishccl
 * @Date 2020/8/26 10:44
 * @Version 1.0
 * @Description
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
    public static void main(String[] args) {
        //创建第一个线程
        Thread threadA = new Thread(()->{
            threadLocal.set("ThreadA：" + Thread.currentThread().getName());
            System.out.println("线程A本地变量中的值为：" + threadLocal.get());
        });
        //创建第二个线程
        Thread threadB = new Thread(()->{
            threadLocal.set("ThreadB：" + Thread.currentThread().getName());
            System.out.println("线程B本地变量中的值为：" + threadLocal.get());
        });
        //启动线程A和线程B
        threadA.start();
        threadB.start();
    }
}
