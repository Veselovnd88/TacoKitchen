package ru.veselov.TacoKitchen.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data

public class Taco {
    private Long id;
    private Date createdAt = new Date();
    @NotNull
    @Size(min=5, message = "Название должно иметь не меньше 5 символов")
    private String name;
    @NotNull
    @Size(min=1,message = "Должен быть выбран хотя бы 1 ингредиент")
    private List<Ingredient> ingredients= new ArrayList<>();

}
