package com.zuoshao.springboot.test.inoderTraversval;

import java.util.Random;

public class Gcdome {
    
    public static void main(String[] args){
        String str = "www.zuoshao.com";
        while (true){
            str +=str + new Random().nextInt(888888)+ new Random().nextInt(99999999);
        }
    }
}
