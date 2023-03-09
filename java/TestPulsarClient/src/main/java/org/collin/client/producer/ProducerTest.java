package org.collin.client.producer;

import static org.collin.client.common.variable.messageIds;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.impl.PulsarClientImpl;

public class ProducerTest {
    public static void main(String[] args) throws PulsarClientException, InterruptedException {
        PulsarClient client=PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();

        Producer producer=client.newProducer()
                .topic("test-topic1")
                .create();

//        MessageId[] messageIds=new MessageId[10];

        for (int i = 0; i < 10; i++) {
            messageIds[i]=producer.send("message-%d-".getBytes());
            System.out.printf("message %d send\n",i);
        }

        Thread.sleep(60*1000);

        producer.close();
        client.close();
    }
}
