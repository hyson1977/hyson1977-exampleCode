package com.example.rabbitmq.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class consumer {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/");

        Connection connection = null;
        Channel channel = null;

        try {
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();
            String queueName = "queue1";

            channel.basicConsume(queueName, true, new DeliverCallback() {
                        @Override
                        public void handle(String s, Delivery delivery) throws IOException {
                            System.out.println("got message:" + new String(delivery.getBody()));

                        }
                    }, new CancelCallback() {
                        @Override
                        public void handle(String s) throws IOException {
                            System.out.println("failed got message");

                        }
                    }

            );

            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
