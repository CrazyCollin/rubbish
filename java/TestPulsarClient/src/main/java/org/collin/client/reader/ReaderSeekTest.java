package org.collin.client.reader;

import static org.collin.client.common.variable.messageIds;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.SubscriptionType;

public class ReaderSeekTest {

    private static MessageId[] messageIds=new MessageId[10];

    public static void main(String[] args) throws PulsarClientException {
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

        Consumer consumer=client.newConsumer()
                .topic("test-topic1")
                .subscriptionName("test-sub1")
                .subscriptionType(SubscriptionType.Exclusive)
                .startMessageIdInclusive()
                .subscribe();


        consumer.seek(messageIds[3]);

        // should start form 5th message now

        Message msg=consumer.receive();

        System.out.println(messageIds[3].toString()+"=="+msg.getMessageId().toString());

        producer.close();
        consumer.close();
        client.close();
    }
}
