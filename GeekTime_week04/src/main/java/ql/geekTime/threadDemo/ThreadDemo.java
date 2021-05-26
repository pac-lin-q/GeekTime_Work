package ql.geekTime.threadDemo;

public class ThreadDemo {

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Thread t = Thread.currentThread();
                System.out.println("当前线程："+t.getName());
            }
        };
        Thread thread = new Thread(task);
        thread.setName("test-thread-1");
        thread.setDaemon(true); //守护线程
        thread.start();
//        try{
//            Thread.sleep(5500);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }
}
