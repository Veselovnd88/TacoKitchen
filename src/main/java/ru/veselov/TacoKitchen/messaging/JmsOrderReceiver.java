package ru.veselov.TacoKitchen.messaging;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import ru.veselov.TacoKitchen.model.TacoOrder;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class JmsOrderReceiver implements OrderReceiver{
    private final JmsTemplate jmsTemplate;
    private final MessageConverter messageConverter;
    @Autowired
    public JmsOrderReceiver(JmsTemplate jmsTemplate, MessageConverter messageConverter) {
        this.jmsTemplate = jmsTemplate;
        this.messageConverter = messageConverter;
    }
    //это активная модель принятия сообщений (pull) требуется явно вызывать receive
    @Override
    public TacoOrder receiveOrder() throws JMSException {
        //забирает строку из места назначения
        Message message = jmsTemplate.receive("tacocloud.order.queue");
        return (TacoOrder) messageConverter.fromMessage(message);
        //можно сделать сразу receiveAndConvert если кроме самого сообщения ничего не нужно
    }



}
