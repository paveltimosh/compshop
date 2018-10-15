package org.vironit.timoshuk.computershop.model.entity.products.Components;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode()
public abstract class Component {
    private Long id;
    private Integer price;
    private String model;
    private String maker;

    Component(Long id, Integer price, String model, String maker) {
        this.id = id;
        this.price = price;
        this.model = model;
        this.maker = maker;
    }

    public Component (){

    }
}
