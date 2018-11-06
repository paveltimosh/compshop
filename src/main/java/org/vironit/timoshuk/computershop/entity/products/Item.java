package org.vironit.timoshuk.computershop.entity.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {
    private Long id;
    private String model;

    public Item(Long id, String model) {
    }

    public Item(){}
}
