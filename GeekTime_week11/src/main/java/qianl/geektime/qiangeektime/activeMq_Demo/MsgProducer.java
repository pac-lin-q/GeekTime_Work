package qianl.geektime.qiangeektime.activeMq_Demo;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MsgProducer {
    public static void main(String[] args) throws Exception {
        //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列
        Queue queue = session.createQueue("geektime_q");
        //创建消息生产者
        MessageProducer messageProducer = session.createProducer(queue);
        //创建消息对象
        for (int i = 0; i <= 3; i++) {
            String msg = "GeekTime_HomeWork_Msg" + i;
            Message message = session.createTextMessage(msg);
            //发送消息
            messageProducer.send(message);
        }
        //关闭所有连接
        messageProducer.close();
        session.close();
        connection.close();
    }
}
