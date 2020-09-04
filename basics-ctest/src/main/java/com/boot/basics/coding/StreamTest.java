package com.boot.basics.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author cherrishccl
 * @Date 2020/9/2 16:23
 * @Version 1.0
 * @Description
 */
public class StreamTest {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(10000);
        for(int i = 1; i <= 10000; i++){
            users.add(new User(String.valueOf(i), "name" + i));
        }
        long start = System.currentTimeMillis();
        try{
            print4(users);
        }catch (Exception e){
            System.out.println("------>" + e.getLocalizedMessage());
        }
        System.out.println("cost: " + (System.currentTimeMillis() - start));
    }
    private static void print4(List<User> list){
        CountDownLatch latch = new CountDownLatch(list.size());
        AtomicInteger ai = new AtomicInteger(0);
        list.parallelStream().forEach(user -> {
            if(user.no.equals("1000")){
                int i = 10 / 0;
            }
            try {
                ai.incrementAndGet();
                latch.countDown();
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " -:-> " + user);
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("total: " + ai.get());

    }
    private static void print3(List<User> list){
        list.stream().forEach(user -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " -:-> " + user);
        });
    }
    private static void print2(List<User> list){
        list.forEach(user -> {
            System.out.println(user);
        });
    }
    private static void print1(List<User> list){
        for(User user : list){
            System.out.println(user);
        }
    }
    static class User{
        private String name;
        private String no;

        public User(String no, String name) {
            this.name = name;
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", no='" + no + '\'' +
                    '}';
        }
    }
}