package com.cckeep.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogTopic {


    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.exchangeDeclare(EXCHANGE_NAME, "topic");

            for (int i = 0; i < 100000; i++) {

                String routingKey = "";
                int num = i % 3;
                switch (num) {
                    case 0:
                        routingKey = "quick.orange.rabbit";
                        break;
                    case 1:
                        routingKey = "lazy.red.rabbit";
                        break;
                    case 2:
                        routingKey = "lazy.brown.fox";
                        break;
                }

                String message = "routingKey : " + routingKey + "_" + i;

                channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
            }
        }
    }
}
