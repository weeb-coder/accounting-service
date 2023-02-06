package com.microservices.accountingservice.kafka;

import com.microservices.accountingservice.model.EmployeeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.employee-topic}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(EmployeeEntity employeeEntity) {
        LOG.info(employeeEntity.toString());
    }
}
