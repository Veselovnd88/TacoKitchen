package ru.veselov.TacoKitchen.messaging;

import ru.veselov.TacoKitchen.model.TacoOrder;


public interface OrderReceiver {

    public TacoOrder receiveOrder();
}
