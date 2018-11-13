package org.vironit.timoshuk.computershop.entity.products.Components;


import lombok.*;
import org.vironit.timoshuk.computershop.entity.products.Item;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true, of = {"id", "model"})
@MappedSuperclass
@Inheritance
public abstract class Component extends Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private Integer price;

    @Column(name = "model")
    private String model;

    @Column(name = "maker")
    private String maker;

    Component(Long id, Integer price, String model, String maker) {
        super(id, model);
        this.id = id;
        this.price = price;
        this.model = model;
        this.maker = maker;
    }

    public Component (){
    }
}
