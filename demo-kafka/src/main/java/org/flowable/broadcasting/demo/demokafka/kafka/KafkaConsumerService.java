package org.flowable.broadcasting.demo.demokafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @KafkaListener(topics = "qc-channel")
    public void qcChannel(ConsumerRecord<?, ?> consumerRecord) {
        log.info(String.format("qc-channel: %s", consumerRecord.value()));
        this.kafkaProducerService.sendMessage(consumerRecord);
    }

    @KafkaListener(topics = "metadata-channel")
    public void metadataChannel(ConsumerRecord<?, ?> consumerRecord) {
        log.info(String.format("metadata-channel: %s", consumerRecord.value()));
        this.kafkaProducerService.sendMessage(consumerRecord);
    }

    @KafkaListener(topics = "library-channel")
    public void libraryChannel(ConsumerRecord<?, ?> consumerRecord) {
        log.info(String.format("library-channel: %s", consumerRecord.value()));
        this.kafkaProducerService.sendMessage(consumerRecord);
    }

    @KafkaListener(topics = "mam-channel")
    public void mamChannel(ConsumerRecord<?, ?> consumerRecord) {
        log.info(String.format("mam-channel: %s", consumerRecord.value()));
        this.kafkaProducerService.sendMessage(consumerRecord);
    }

    @KafkaListener(topics = "transcoding-channel")
    public void transcodingChannel(ConsumerRecord<?, ?> consumerRecord) {
        log.info(String.format("transcoding-channel: %s", consumerRecord.value()));
        this.kafkaProducerService.sendMessage(consumerRecord);
    }

    @KafkaListener(topics = "storage-channel")
    public void storageChannel(ConsumerRecord<?, ?> consumerRecord) {
        log.info(String.format("storage-channel: %s", consumerRecord.value()));
        this.kafkaProducerService.sendMessage(consumerRecord);
    }

    @KafkaListener(topics = "notification-channel")
    public void notificationChannel(ConsumerRecord<?, ?> consumerRecord) {
        log.info(String.format("notification-channel: %s", consumerRecord.value()));
    }
}