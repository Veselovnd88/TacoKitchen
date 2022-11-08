package ru.veselov.TacoKitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.veselov.TacoKitchen.model.KitchenUi;

@SpringBootApplication
public class TacoKitchenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoKitchenApplication.class, args);
		KitchenUi kitchenUi = new KitchenUi();

	}

}
