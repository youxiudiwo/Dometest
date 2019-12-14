package com.zuoshao.springboot.test.inoderTraversval;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 异常现象 java.util.ConcurrentModificationException
 *
 * 导致原因
 *
 * 解决方法
 *
 * new vector<>() 并发效率变低 线程安全 同一时间段只有一个线程操作
 *Collections.synchronizedList(new ArrayList<>());
 *new CopyOnWriteArrayList<>();写实复制
 *Collections  集合工具类
 *Collection   集合几接口
 *
 * 优化建议
 */
public class NotSafeDemo03 {

    public static void main(String[] args) {
        Set<String> set = new ConcurrentSkipListSet<>();
//        List<String> list = new Vector<>();
//        List<String> list1 = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }

    }
//    public static void main(String[] args) {
//        Map<String , String > map =new ConcurrentHashMap<>();
////        List<String> list = new Vector<>();
////        List<String> list1 = Collections.synchronizedList(new ArrayList<>());
////        List<String> list = new CopyOnWriteArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            new Thread(() -> {
//                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
//                System.out.println(map);
//            },String.valueOf(i)).start();
//        }
//
//    }
}
