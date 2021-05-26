package ql.geekTime.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCount {
    private AtomicInteger sum = new AtomicInteger();

    public int add(){
        return sum.getAndIncrement();
    }

    public  int getNum(){
        return sum.get();
    }
}
