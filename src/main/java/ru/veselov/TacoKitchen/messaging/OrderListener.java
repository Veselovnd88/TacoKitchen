package ru.veselov.TacoKitchen.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.veselov.TacoKitchen.model.KitchenUi;
import ru.veselov.TacoKitchen.model.TacoOrder;

@Component
@Profile("jms-listener")//хорошо для быстрой обработки сообщений, но плохо когда сервис может не успеть отработать
public class OrderListener {
    private final KitchenUi kitchenUI;

    @Autowired
    public OrderListener(KitchenUi kitchenUI) {
        this.kitchenUI = kitchenUI;
    }
    @JmsListener(destination = "tacocloud.order.queue")
    public void receiverOrder(TacoOrder order){
        kitchenUI.displayOrder(order);
    }


}
