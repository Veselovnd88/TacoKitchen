package ru.veselov.TacoKitchen.model;


import lombok.*;

@Getter
@Setter
@ToString
/*Ломбок аннотация Дата генерирует, геттеры, сеттеры
* хешкод, иквелс, ту стринг, и конструкторы
* После добавления зависимости - нужно в разделе билд исключить из сборки эту зависимость
* Так как код генерируется на лету*/
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP,PROTEIN,VEGGIES, CHEESE, SAUCE
    }


    }
