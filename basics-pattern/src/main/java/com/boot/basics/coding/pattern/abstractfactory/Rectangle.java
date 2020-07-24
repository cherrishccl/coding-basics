package com.boot.basics.coding.pattern.abstractfactory;

/**
 * @Author cherrishccl
 * @Date 2020/7/24 14:00
 * @Version 1.0
 * @Description
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("画方");
    }
}
