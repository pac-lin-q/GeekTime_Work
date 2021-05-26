package ql.geekTime.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(16);
        for (int i = 0; i < 1000; i++) {
            final int no=i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try{
                        System.out.println("START:" + no);
                        Thread.sleep(1000L);
                        System.out.println("END:" + no);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            //10S后执行
            executorService.schedule(runnable,10, TimeUnit.SECONDS);
        }
        executorService.shutdown();
        System.out.println("Main Thread End ！");
    }
}
