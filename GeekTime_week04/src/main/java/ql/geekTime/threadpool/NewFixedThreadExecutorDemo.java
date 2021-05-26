package ql.geekTime.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        for (int i = 0; i <1000 ; i++) {
            final int no=i;
            executorService.execute(()->{
                try{
                    System.out.println("START:" + no);
                    Thread.sleep(1000L);
                    System.out.println("END:" + no);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        System.out.println("Main Thread End ！");
    }
}
