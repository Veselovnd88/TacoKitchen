package ru.veselov.TacoKitchen.config;

import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.veselov.TacoKitchen.model.TacoOrder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {

    @Bean
    MessageConverter messageConverter(){
        return new SimpleMessageConverter();
    }

}
