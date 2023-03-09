package org.collin.client.consumer;

import static org.collin.client.common.variable.messageIds;
import org.apache.logging.log4j.core.util.Assert;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.SubscriptionType;

public class ConsumerTest {

    public static void main(String[] args) throws PulsarClientException {
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();

        Consumer consumer=client.newConsumer()
                .topic("test-topic1")
                .subscriptionName("test-sub1")
                .subscriptionType(SubscriptionType.Exclusive)
                .startMessageIdInclusive()
                .subscribe();


        consumer.seek(messageIds[3]);

        // should start form 5th message now

        Message msg=consumer.receive();

        System.out.println(messageIds[5].toString()+"=="+msg.getMessageId().toString());

    }
}
