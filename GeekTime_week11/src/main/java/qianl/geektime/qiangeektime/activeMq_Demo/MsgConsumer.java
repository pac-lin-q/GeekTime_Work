package qianl.geektime.qiangeektime.activeMq_Demo;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MsgConsumer {
    public static void main(String[] args) throws Exception{
        //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory("tcp://localhost:61616");
        //创建连接
        Connection connection=activeMQConnectionFactory.createConnection();
        //连接
        connection.start();
        //创建会话
        Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列
        Queue queue=session.createQueue("geektime_q");
        //创建消息消费者
        MessageConsumer messageConsumer=session.createConsumer(queue);
        // 消息消费，使用监听器
        messageConsumer.setMessageListener((message)->{
            if(message instanceof TextMessage){
                String text = null;
                try {
                    text = ((TextMessage) message).getText();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                System.err.println("收到的消息是：" + text);
            }
        });
        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
