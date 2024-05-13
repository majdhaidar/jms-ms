package com.sbm.jms.sender;

import com.sbm.jms.config.JmsConfig;
import com.sbm.jms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        HelloWorldMessage helloWorldMessage = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("hello from jms")
                .build();


        log.info("sending jms message");
        jmsTemplate.convertAndSend(JmsConfig.JMS_HELLO_WORLD_QUEUE, helloWorldMessage);
    }
}
