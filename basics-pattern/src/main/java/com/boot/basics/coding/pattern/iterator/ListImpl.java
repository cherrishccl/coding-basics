package com.boot.basics.coding.pattern.iterator;

/**
 * @Author chencl
 * @Date 2020/8/19 10:05
 * @Version 1.0
 * @Description
 */
public class ListImpl implements List {
    private Object[] list;
    private int index;
    private int size;
    public ListImpl() {
        index = 0;
        size = 0;
        list = new Object[100];
    }
    @Override
    public Iterator iterator() {
        return new IteratorImpl(this);
    }
    @Override
    public Object get(int index) {
        return list[index];
    }
    @Override
    public int getSize() {
        return this.size;
    }
    @Override
    public void add(Object obj) {
        list[index++] = obj;
        size++;
    }
}
