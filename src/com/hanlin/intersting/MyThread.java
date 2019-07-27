package com.hanlin.intersting;

class ThreadRunnable implements Runnable{
    private int ticketCount = 5;   //需要卖掉的火车票数

    @Override
    public void run() {
        while (ticketCount>0){
            ticketCount--;
            System.out.println(Thread.currentThread().getName()+"卖掉了一张票,剩余票数："+ticketCount);
        }
    }

}

public class MyThread {
    public static void main(String[] args) {
        ThreadRunnable tr = new ThreadRunnable();
        //三个线程来模拟卖票
        Thread th1 = new Thread(tr,"窗口1");
        Thread th2 = new Thread(tr,"窗口2");
        Thread th3 = new Thread(tr,"窗口3");
        //启动这三个线程，也就是窗口，来卖票
        th2.start();
        th1.start();
        th3.start();
    }
}
