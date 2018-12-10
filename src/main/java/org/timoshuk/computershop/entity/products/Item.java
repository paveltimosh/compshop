package org.timoshuk.computershop.entity.products;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {

    @Setter(value = AccessLevel.PRIVATE)
    private Long id;
    private String model;

    public Item(Long id, String model) {
    }

    public Item(){}
}
