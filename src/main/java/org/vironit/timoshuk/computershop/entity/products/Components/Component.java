package org.vironit.timoshuk.computershop.entity.products.Components;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.vironit.timoshuk.computershop.entity.products.Item;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public abstract class Component extends Item {
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
