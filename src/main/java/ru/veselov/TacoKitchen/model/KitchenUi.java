package ru.veselov.TacoKitchen.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class KitchenUi {
    public void displayOrder(TacoOrder order) {
      log.info("Order received at {}", new Date().toString());
    }
}
