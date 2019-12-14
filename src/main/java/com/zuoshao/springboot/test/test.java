package com.zuoshao.springboot.test;

public class test extends Thread{
//    static final int v2 = new Random().nextInt();
  static int count=0;
    @Override
    public void run() {

        for (int i = 0; i < 5000 ; i++) {
            count = count + 1;
            System.out.println(count);
        }
        System.out.println(count+" fddff ");
    }
    public static void main(String[] args){
        test thread = new test();
        test thread2 = new test();
        thread.start();
        thread2.start();






//        for (int i = 0; i < 5; i++) {
//              count =  ++count;
//
//        }
//        System.out.println(count);

//        Scanner sc = new Scanner(System.in);
//        String num = sc.nextLine();//将用户输入的一整行字符串赋给s
//        String[] arr = num.split(",+");//用空格将其分割成字符串数组
//        int size = arr.length;


//第一种 思想先全部乘起来最后除以个最小数
//        LinkedList<Integer> objects = new LinkedList<>();
//        for (int i = 0; i < size; i++) {
//          objects.add(Integer.parseInt(arr[i]));
//        }
//        int pugs = 1;
//        int min = objects.get(0);
//        for(Integer ins:objects)
//        {
//               if (ins<min){
//                   min = ins;
//               }
//               pugs = ins * pugs;
//        }
//
//        System.out.println(min);
//          pugs = pugs/min;
//        System.out.println(pugs);


        //第二种 思想先排序然后去掉最小数撑起来
//        int[] arrint =new int[size];
//        for (int i = 0; i < size; i++) {
//            arrint[i] = Integer.parseInt(arr[i]);
//        }
//
//        int temp=0;
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size-i-1; j++) {
//                if (arrint[j]>arrint[j+1]){
//                    temp = arrint[j];
//                    arrint[j] = arrint[j+1];
//                    arrint[j+1] = temp;
//                }
//            }
//        }
//        int sum = 1;
//        int number = 1;
//        if (size%2!=0){
//            for (int i = 1; i < size ; i =i+2) {
//                number  = arrint[i] * arrint[i+1];
//                sum = number * sum;
//            }
//            System.out.println(sum);
//        }else {
//            for (int i = 1; i < size ; i++) {
//                number  = arrint[i] * number;
//            }
//            System.out.println(number);
//        }

        }

    }
