package ru.veselov.TacoKitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.veselov.TacoKitchen.messaging.OrderReceiver;
import ru.veselov.TacoKitchen.model.KitchenUi;
import ru.veselov.TacoKitchen.model.TacoOrder;


@Controller
@RequestMapping("/kitchen")
public class KitchenController {

    private final KitchenUi kitchenUi;
    private final OrderReceiver orderReceiver;
    @Autowired
    public KitchenController(KitchenUi kitchenUi, OrderReceiver orderReceiver) {
        this.kitchenUi = kitchenUi;
        this.orderReceiver = orderReceiver;
    }
    @GetMapping
    public String getOrder(){

            TacoOrder tacoOrder = orderReceiver.receiveOrder();
            kitchenUi.displayOrder(tacoOrder);

        return "home";
    }
}
