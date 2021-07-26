package qianl.geektime.qianlgeektime.kafkademo.kafkautil;

import qianl.geektime.qianlgeektime.kafkademo.Order;

public interface Producer {
    void send(Order order);

    void close();

    // add your interface method here

    // and then implement it
}
