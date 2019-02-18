package com.cckeep.rabbitmq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            for (int i = 0; i < 100000; i++) {
                String level = "";
                int num = i % 3;
                switch (num){
                    case 0 :
                        level = "info";
                        break;
                    case 1 :
                        level = "warning";
                        break;
                    case 2 :
                        level = "error";
                        break;
                }

                String message = "hello : " + i;


                channel.basicPublish(EXCHANGE_NAME, level, null, message.getBytes("UTF-8"));

                System.out.println(" [x] Sent '" + level + "':'" + message + "'");
            }

        }
    }

}
