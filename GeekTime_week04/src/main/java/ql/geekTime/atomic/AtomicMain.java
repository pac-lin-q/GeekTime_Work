package ql.geekTime.atomic;

public class AtomicMain {
    public static void main(String[] args) {
        final SyncCount syc = new SyncCount();
        for (int i = 0; i <100 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <10000; j++) {
                        syc.add();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("num=" + syc.getNum());
    }
}
