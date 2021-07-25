package qianl.geektime.qiangeektime.activeMq_Demo;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

import java.net.URI;

public class ActiveMQServer {

    public static void main(String[] args) throws Exception{
        // 创建 broker 服务器
//        BrokerService brokerService = new BrokerService();
//        // 设置使用 Jmx
//        brokerService.setUseJmx(true);
//        // 绑定服务地址
//        brokerService.addConnector("tcp://localhost:61616");
//        // 启动服务器
//        brokerService.start();

        //BrokerFactory启动
        String uri = "properties:broker.properties";
        BrokerService broker = BrokerFactory.createBroker(new URI(uri));
        broker.addConnector("tcp://localhost:61616");
        broker.start();

        System.in.read();
    }
}
