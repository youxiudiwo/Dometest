package com.zuoshao.springboot.test.inoderTraversval;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * aad打印5次 b打印10次 c打印15次
 * notify 通知线程
 * 当a执行完成后通知b这时候如果有多个线程 就只能用线程的优先级来实现
 *condition 相当于钥匙
 * 一把锁有多个钥匙
 * 能做到精确唤醒
 *
 * Condition c1  = lock.newCondition();
 * Condition c2  = lock.newCondition();
 * Condition c3  = lock.newCondition();
 */

class Prints{
    private int number = 1;
    private Lock lock = new ReentrantLock();
   private Condition c1 = lock.newCondition();
   private Condition c2 = lock.newCondition();
   private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            //判断
            while (number != 1){
                c1.await();
            }
            //干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number = 2;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try{
            //判断
            while (number != 2){
                c2.await();
            }
            //干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number = 3;
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try{
            //判断
            while (number != 3){
                c3.await();
            }
            //干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number = 1;

            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}

public class ConditionDemo {
    public static void main(String[] args){
        Prints prints = new Prints();
        new Thread(() -> {
            for (int i = 1; i <=10; i++) {
                prints.print5();
            }
        },"a").start();
        new Thread(() -> {
            for (int i = 1; i <=10; i++) {
                prints.print10();
            }
        },"b").start();

        new Thread(() -> {
            for (int i = 1; i <=10; i++) {
                prints.print15();
            }
        },"c").start();

    }
}
