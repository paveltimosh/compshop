package org.timoshuk.computershop.entity.products.Components;


import lombok.*;
import org.timoshuk.computershop.entity.products.Item;

import javax.persistence.*;
import javax.validation.constraints.Digits;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true, of = {"id", "model"})
@MappedSuperclass
@Inheritance
public abstract class Component extends Item {

    @Id
    @Setter(value = AccessLevel.PRIVATE)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "comp_seq")
    @SequenceGenerator(name = "comp_seq", sequenceName = "id_component_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Digits(integer = 6,fraction = 0, message = "It can be only 1-2 digits")
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
