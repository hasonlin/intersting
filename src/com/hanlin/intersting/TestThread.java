package com.hanlin.intersting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by admin on 2018/5/15 0015.
 */
public class TestThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int taskSize = 5;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new Mycallable(i+"");
            Future f = pool.submit(c);
            list.add(f);
        }
        pool.shutdown();

        for (Future f:list) {
            System.out.println(f.get().toString());
        }
    }
}

class Mycallable implements Callable<Object>{
    private String taskNum;

    public Mycallable(String taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("任务启动：");
        Date date1 = new Date();
        Thread.sleep(1002);
        Date date2 = new Date();
        long time = date2.getTime()-date1.getTime();
        System.out.println("任务返回运行结果,毫秒数："+time);
        return time;
    }
}
