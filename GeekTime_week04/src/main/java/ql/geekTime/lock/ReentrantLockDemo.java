package ql.geekTime.lock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        final GeekTime_week04.src.main.java.ql.geekTime.lock.Count count = new GeekTime_week04.src.main.java.ql.geekTime.lock.Count();

        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    count.get();
                }
            }.start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    count.put();
                }
            }.start();
        }
    }
}
