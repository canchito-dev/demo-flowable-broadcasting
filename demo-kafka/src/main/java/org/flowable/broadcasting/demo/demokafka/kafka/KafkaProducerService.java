package org.flowable.broadcasting.demo.demokafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Scope("prototype")
@Slf4j
public class KafkaProducerService {

    private static final String FLOWABLE_CHANNEL = "flowable-channel";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(ConsumerRecord<?, ?> consumerRecord) {
        this.send(consumerRecord);
    }

    private void send(ConsumerRecord<?, ?> consumerRecord) {
        ListenableFuture<SendResult<String, Object>> future = this.kafkaTemplate.send(FLOWABLE_CHANNEL, consumerRecord.value());

        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("Sent message=[" + consumerRecord.value() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=["
                        + consumerRecord.value() + "] due to : " + ex.getMessage());
            }
        });
    }
}