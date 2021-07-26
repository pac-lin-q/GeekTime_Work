package qianl.geektime.qianlgeektime.kafkademo;

import qianl.geektime.qianlgeektime.kafkademo.kafkautil.ConsumerImpl;

public class KafkaConsumerDemo {
    public static void main(String[] args) {
        testConsumer();
    }

    private static void testConsumer() {
        ConsumerImpl consumer = new ConsumerImpl();
        consumer.consumeOrder();

    }

}