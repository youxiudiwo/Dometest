package com.zuoshao.springboot.test.inoderTraversval;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Acitions{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void addnumber() throws Exception{
        lock.lock();
        try{
        //判断该不该它干
        while (number != 0){
            condition.await();
        }
        //干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

//        //判断该不该它干
//        while (number != 0){
//            this.wait();
//        }
//        //干活
//        number++;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        //通知
//        this.notifyAll();
    }
    public void reducenumber() throws Exception{
        lock.lock();
        try{
            //判断该不该它干
            while (number == 0){
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //通知
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
        //判断该不该它干
//        while (number == 0){
//            this.wait();
//        }
//        //干活
//        number--;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        //通知
//        this.notifyAll();
    }
}


public class ProdConsumerDemo04 {


    /**
     * 实现一个线程加1 一个线程减1
     *
     * 高内聚低耦合的前期提下 线程 操作 资源类
     * 判断 / 干活 / 通知
     * 防止虚假唤醒  多线程的调度交互判断不准用if 必须用while 多线程的横向通信调用
     * 为什么会变成2 a线程生产了一个 c线程抢到了 if判读为1 等待 释放资源 a线程抢到了 这时候等待的有两个ac线程 最后一个消费线程进来
     * 消费完了 ac两个线程同时生产
     *
     * 总结 ：多线程套路 + while判断 + 新版本写法
     *
     * synchronized,ReentrantLock() 可重入递归的非公平锁
     *
     * ，notify 仅仅通知一个线程，并且我们不知道哪个线程会收到通知,然而 notifyAll 会通知所有等待中的线程
     *
     * 变更历史 synchronized ->reentranlock    wait() -> await()   notifyAll() -> singnalAll()
     *
     *
     *
     */
    public static void main(String[] args) throws Exception {
        Acitions a = new  Acitions();

        new Thread(()->{
            for (int i = 1; i < 10; i++) {
                try {
                    a.addnumber();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"a").start();

        new Thread(()->{
            for (int i = 1; i < 10; i++) {
                try {
                    a.reducenumber();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"b").start();


        new Thread(()->{
            for (int i = 1; i < 10; i++) {
                try {
                    a.addnumber();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"c").start();

        new Thread(()->{
            for (int i = 1; i < 10; i++) {
                try {
                    a.reducenumber();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"d").start();
    }
}
