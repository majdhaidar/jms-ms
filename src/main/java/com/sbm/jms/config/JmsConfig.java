package com.sbm.jms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/**
 * Class to hold all related jms configurations
 * Including the message convertor which is used for jms messaging
 *
 */
@Configuration
public class JmsConfig {

    public static final String JMS_HELLO_WORLD_QUEUE = "jms-hello-world";

    @Bean
    public MessageConverter jmsMessageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
