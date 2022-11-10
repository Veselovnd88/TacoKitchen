package ru.veselov.TacoKitchen.messaging;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import ru.veselov.TacoKitchen.model.TacoOrder;

import java.lang.reflect.Type;

@Component
@ConfigurationProperties
public class RabbitOrderReceiver implements OrderReceiver{
        private final RabbitTemplate rabbitTemplate;
        private final MessageConverter messageConverter;

        @Autowired
        public RabbitOrderReceiver(RabbitTemplate rabbitTemplate, MessageConverter messageConverter) {
                this.rabbitTemplate = rabbitTemplate;
                this.messageConverter = messageConverter;
        }


        @Override
        public TacoOrder receiveOrder()  {
                Message message = rabbitTemplate.receive("tacocloud.order");
                return message!=null ? (TacoOrder) messageConverter.fromMessage(message)
                        : null;

        }

        public TacoOrder receiveOrder2(){
                return rabbitTemplate.receiveAndConvert("tacocloud.order",
                        new ParameterizedTypeReference<TacoOrder>() {
                        });
        }

}
