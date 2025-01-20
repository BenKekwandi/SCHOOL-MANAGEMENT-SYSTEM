package com.payment_service.producer;

import com.payment_service.dto.PaymentEvent;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentProducer {

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;
    private static final String TOPIC="payment-topic";

    public void publishPaymentEvent(PaymentEvent event)
    {
        kafkaTemplate.send(TOPIC, event);
        System.out.println("Payment event published: " + event);
    }
    
}
