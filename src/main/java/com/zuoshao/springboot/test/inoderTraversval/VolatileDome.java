package com.zuoshao.springboot.test.inoderTraversval;

import java.util.Collection;
import java.util.concurrent.locks.Condition;

/**
 * valatile 关键字相当于将这个变量可视化 在a线程修改了过后 及时暴露给其他线程 让其他线程知道他已经修改了
 */
class Mynumber{
   volatile int i = 10;
    public void add(){
        this.i=1456;
    }
}

public class VolatileDome {
    public static void main(String[] args){
        Mynumber mynumber = new Mynumber();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
                mynumber.add();
                System.out.println(Thread.currentThread().getName()+"   "+mynumber.i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"aaa").start();

        while (mynumber.i==10){

        }

        System.out.println("线程结束"+mynumber.i);
    }
}
