package ru.veselov.TacoKitchen.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.veselov.TacoKitchen.model.KitchenUi;
import ru.veselov.TacoKitchen.model.TacoOrder;

//@Component
public class OrderListener {
    private final KitchenUi kitchenUi;
    @Autowired
    public OrderListener(KitchenUi kitchenUi) {
        this.kitchenUi = kitchenUi;
    }

    @RabbitListener(queues = "tacocloud.order.queue")
    public void receiveOrder(TacoOrder order){
        kitchenUi.displayOrder(order);
    }


}
