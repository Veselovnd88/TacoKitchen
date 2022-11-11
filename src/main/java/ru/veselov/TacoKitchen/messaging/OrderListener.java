package ru.veselov.TacoKitchen.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import ru.veselov.TacoKitchen.model.KitchenUi;
import ru.veselov.TacoKitchen.model.TacoOrder;

//@Component
public class OrderListener {
    private final KitchenUi kitchenUi;
    @Autowired
    public OrderListener(KitchenUi kitchenUi) {
        this.kitchenUi = kitchenUi;
    }

    @KafkaListener(topics = "orders.topic")
    public void handle(TacoOrder order){
        kitchenUi.displayOrder(order);
    }


}
