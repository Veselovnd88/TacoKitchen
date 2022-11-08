package ru.veselov.TacoKitchen.messaging;

import ru.veselov.TacoKitchen.model.TacoOrder;

import javax.jms.JMSException;

public interface OrderReceiver {

    public TacoOrder receiveOrder() throws JMSException;
}
