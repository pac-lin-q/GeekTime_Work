package jvm;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class GCLogAnalysis {
    private static Random random = new Random();
    public static void main(String[] args) {
        //当前毫秒时间戳
        long startMills = System.currentTimeMillis();
        //持续运行毫秒时间戳
        long timeoutMills = TimeUnit.SECONDS.toMillis(1);
        //结束时间戳
        long endMills = startMills + timeoutMills;
        LongAdder counter = new LongAdder();
        System.out.println("正在执行......");
        //缓存一部分对象
        int cacheSize = 2000;
        Object[] cachedGarbage = new Object[cacheSize];
        //在此时间范围内，持续循环
        while (System.currentTimeMillis() < endMills) {
            Object garbage = genergenerateGeekTime(100 * 1024);
            counter.increment();
            int randomIndex = random.nextInt(2 * cacheSize);
            if (randomIndex < cacheSize) {
                cachedGarbage[randomIndex] = garbage;
            }
        }
        System.out.println("执行结束，共生成对象次数："+counter.longValue());
    }

    //生成对象
    private  static  Object genergenerateGeekTime(int max) {
        int randomSize = random.nextInt(max);
        int t = randomSize % 4;
        Object result = null;
        switch (t) {
            case 0:
                result = new int[randomSize];
                break;
            case 1:
                result = new byte[randomSize];
                break;
            case 2:
                result = new double[randomSize];
                break;
            default:
                StringBuilder builder = new StringBuilder();
                String randomString = "randomString-Anything";
                while (builder.length() < randomSize) {
                    builder.append(randomString);
                    builder.append(max);
                    builder.append(randomSize);
                }
                result = builder.toString();
                break;
        }
        return result;
    }
}
