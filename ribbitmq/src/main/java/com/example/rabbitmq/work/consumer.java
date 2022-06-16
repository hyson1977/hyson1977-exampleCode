package com.example.rabbitmq.work;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
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
            final Channel finchannel = channel;

            channel.basicQos(1);

            String queueName = "queue1";

            finchannel.basicConsume(queueName, false, new DeliverCallback() {
                        @Override
                        public void handle(String s, Delivery delivery) throws IOException {
                            try {
                                System.out.println("got message:" + new String(delivery.getBody()));
                                TimeUnit.SECONDS.sleep(2);
                                finchannel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new CancelCallback() {
                        @Override
                        public void handle(String s) throws IOException {
                            System.out.println("failed got message");

                        }
                    }

            );
            System.in.read();
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
