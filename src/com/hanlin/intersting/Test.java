package com.hanlin.intersting;

/**
 * Created by admin on 2018/5/11 0011.
 */
public class Test{
    static int i;
    public int test(){
        i++;
        return i;
    }
    public static void main(String[] args) {
        Test t  = new Test();
        t.test();
        System.out.println(t.test());
//        try {
//            System.out.println("hello,jr");
//        }finally {
//            System.out.println("88");
//        }
    }
//        @Override
    public void start() {
        System.out.println(123);
        for (int i = 0; i < 10; i++) {
            System.out.println("value of i = "+i);
        }
    }
}
