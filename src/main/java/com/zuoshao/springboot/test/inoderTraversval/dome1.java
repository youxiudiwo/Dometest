package com.zuoshao.springboot.test.inoderTraversval;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class dome1 {
    public static void main(String[] args) {

        dome2 dome = new dome2();
        new Thread(()->{ for (int i = 0; i < 40; i++) dome.sale();},"a" ).start();
        new Thread(()->{ for (int i = 0; i < 40; i++) dome.sale();},"b" ).start();
        new Thread(()->{ for (int i = 0; i < 40; i++) dome.sale();},"c" ).start();

    }

}

 class dome2 {
        Lock lock = new ReentrantLock();
        private int number = 30;
        public void sale(){
            lock.lock();
            try {
                if(number>0)
                {
                    System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下："+number);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
}
