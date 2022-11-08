package ru.veselov.TacoKitchen.model;


import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder implements Serializable {

    private static final long serialVersionUID=1L;
    private Long id;

    private Date placedAt = new Date();

    @NotBlank(message = "Обязательное поле")
    private String deliveryName;
    @NotBlank(message = "Обязательное поле")
    private String deliveryStreet;
    @NotBlank(message = "Обязательное поле")
    private String deliveryCity;
    @NotBlank(message = "Обязательное поле")
    private String deliveryState;
    @NotBlank(message = "Обязательное поле")
    private String deliveryZip;
    @CreditCardNumber(message = "Неправильный формат номера карты")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",message = "Формат MM/YY")
    //паттерн или 01-09, или 1 (0-2), далее косая черта, далее первое число от 2 до 9, дальше от 0 до 0
    //далее знак доллара - конец строки!
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0,message = "invalid CVV")
    //поле содержит ровно 3 цифры
    private String ccCVV;
    private List<Taco> tacos=new ArrayList<>();
    private User user;

    public  void addTaco(Taco taco){
        this.tacos.add(taco);
    }


}
