package ql.geekTime.lock;



public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        final GeekTime_week04.src.main.java.ql.geekTime.lock.Count2 count = new GeekTime_week04.src.main.java.ql.geekTime.lock.Count2();

        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    count.get();
                }
            }.start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    count.put();
                }
            }.start();
        }
    }
}
