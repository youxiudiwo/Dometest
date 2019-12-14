package com.zuoshao.springboot.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
    private Integer Id;
    private String name;
    private int age;
}


/**
 *偶数id 年龄大于24 将名字转为大写 到排序
 * 输出一个用户
 */
public class WorkDome {
    public static void main(String[] args){

         Lock lock = new ReentrantLock();


        User user = new User(11,"a",23);
        User user1 = new User(12,"c",24);
        User user2 = new User(13,"d",22);
        User user3 = new User(14,"e",28);
        User user4 = new User(16,"f",26);
        List<User> list = Arrays.asList(user,user1,user2,user3,user4);


//        Stack<User> stack = new Stack<>();
//        for (User user5 : list) {
//            if (user5.getId()%2==0 && user5.getAge()>24){
//                    user5.setName(user5.getName().toUpperCase());
//                    stack.add(user5);
//            }
//        }
//        for (User user5 : stack) {
//            System.out.println(user5.toString());
//        }

    }
}
