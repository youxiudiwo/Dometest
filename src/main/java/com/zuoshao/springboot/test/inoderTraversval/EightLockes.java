package com.zuoshao.springboot.test.inoderTraversval;

class Phone{
    public synchronized void email(){
        System.out.println("******邮件");
    }
    public synchronized void emaSmMS(){
        System.out.println("******短信");
    }
    public synchronized void emaphone(){
        System.out.println("******打电话");
    }


}

public class EightLockes {

    public static void main(String[] args) {
        Phone a = new Phone();
        Phone b = new Phone();

        new Thread(() -> {
            try {
                a.email();
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                a.emaSmMS();
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }

}
