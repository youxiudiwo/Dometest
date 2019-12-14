package com.zuoshao.springboot.test.inoderTraversval;

public class JVMruntime {

    public static void main(String[] args){
        long maxMemory  = Runtime.getRuntime().maxMemory();//返回java 虚拟机试图使用的最大内存
        long totalMemory = Runtime.getRuntime().totalMemory();//返回java虚拟机的内存总量
        System.out.println("-Xmx:MAX_MEMORY = "+"字节"+(maxMemory / (double)1024/1024));
    }
}
