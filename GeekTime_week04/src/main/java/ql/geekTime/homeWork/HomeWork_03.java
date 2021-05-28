package ql.geekTime.homeWork;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HomeWork_03 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock() ;
        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Runnable R = new Runnable() {
            @Override
            public void run() {
                lock.lock();  //使用lock锁
                int result = sum(); //这是得到的返回值
                System.out.println("异步计算结果为："+result);
                lock.unlock();
//                System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
            }
        };
//        new Thread(){ //使用lock锁
//            @Override
//            public void run() {
//                lock.lock();
//                int result = sum(); //这是得到的返回值
//                System.out.println("异步计算结果为："+result);
//                lock.unlock();
//            }
//        }.start();
        Thread t = new Thread(R);
        t.start();
//        int result = sum(); //这是得到的返回值

        // 确保  拿到result 并输出
//        System.out.println("异步计算结果为："+result);
//        try {
//            Thread.sleep(200L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(){
            @Override
            public void run() {
                lock.lock();
                System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
                lock.unlock();
            }
        }.start();
//        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
