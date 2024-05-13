package com.sbm.jms.listener;


import com.sbm.jms.config.JmsConfig;
import com.sbm.jms.model.HelloWorldMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.JMS_HELLO_WORLD_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders messageHeaders){
        log.info("Listening to message");
        log.info("Message: {}", helloWorldMessage);
    }

}
